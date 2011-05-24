/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package templatex;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author morthimer
 */
public class addUser extends HttpServlet
{
  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, SQLException, ClassNotFoundException
  {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    HTMLHelper.printHeader(out);
    Connection con = DBManager.establishConnection();
    ResultSet rs;
    Connection connection = DBManager.establishConnection();
    Statement statement = connection.createStatement();
    String password, password2, username, permission = "user", company = "", degree = "", name, surname, street, city, country, email = "", phone = "", fax = "", name2 = "", zipcode = "";
    int userid = 0;


    password = request.getParameter("password");
    password2 = request.getParameter("password2");
    username = request.getParameter("username");
    permission = request.getParameter("permission");
    company = request.getParameter("company");
    degree = request.getParameter("degree");
    name = request.getParameter("name");
    surname = request.getParameter("surname");
    street = request.getParameter("street");
    city = request.getParameter("city");
    country = request.getParameter("country");
    email = request.getParameter("email");
    phone = request.getParameter("telephone");
    fax = request.getParameter("fax");
    zipcode = request.getParameter("zipcode");

    if (password.isEmpty() || username.isEmpty() || name.isEmpty()
            || surname.isEmpty() || street.isEmpty() || city.isEmpty()
            || country.isEmpty())
    {
      HTMLHelper.printNotAllFilledIn(out);
    } else
    {
      if (!password.equals(password2))
      {
        HTMLHelper.printErrorIncompatibelPawwords(out);
      } else
      {

        rs = statement.executeQuery("SELECT username FROM users where username='" + username + "';");
        while (rs.next())
        {
          name2 = rs.getString("username");
        }
        if (!name2.isEmpty())
        {
          HTMLHelper.printErrorUsernameTaken(out);
        } else
        {
          rs = statement.executeQuery("SELECT MAX(userid) FROM users;");
          rs.next();
          userid = rs.getInt("MAX(userid)");
          userid++;
//          out.println("INSERT INTO `users` (`password`, `username`, `userid`, `Permission`, `company`, `degree`, `name`, `surname`, `street`, `zipcode`, `city`, `country`, `email`, `phone`, `fax`) VALUES "
//                  + "('" + password + "', '" + username + "', " + userid + ", '" + permission + "', '" + company + "', '" + degree + "', '" + name + "', '" + surname + "', '" + street + "', '" + zipcode + "', '" + city + "', '" + country + "', '" + email + "', '" + phone + "', '" + fax + "');");
          statement.executeUpdate("INSERT INTO `users` (`password`, `username`, `userid`, `Permission`, `company`, `degree`, `name`, `surname`, `street`, `zipcode`, `city`, `country`, `email`, `phone`, `fax`) VALUES ('" + password + "', '" + username + "', " + userid + ", '" + permission + "', '" + company + "', '" + degree + "', '" + name + "', '" + surname + "', '" + street + "', '" + zipcode + "', '" + city + "', '" + country + "', '" + email + "', '" + phone + "', '" + fax + "');");

          HTMLHelper.printInsertCompleted(out, password, username, userid, permission, company, degree, name, surname, street, zipcode, city, country, email, phone, fax);
        
          con.close();
        }
      }
    }
    HTMLHelper.printFooter(out);
  }
  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException
  {
    try
    {
      try
      {
        processRequest(request, response);
      } catch (ClassNotFoundException ex)
      {
        Logger.getLogger(addUser.class.getName()).log(Level.SEVERE, null, ex);
      }
    } catch (SQLException ex)
    {
      Logger.getLogger(addUser.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  /**
   * Handles the HTTP <code>POST</code> method.
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException
  {
    try
    {
      try
      {
        processRequest(request, response);
      } catch (ClassNotFoundException ex)
      {
        Logger.getLogger(addUser.class.getName()).log(Level.SEVERE, null, ex);
      }
    } catch (SQLException ex)
    {
      Logger.getLogger(addUser.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  /**
   * Returns a short description of the servlet.
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo()
  {
    return "Short description";
  }
}
