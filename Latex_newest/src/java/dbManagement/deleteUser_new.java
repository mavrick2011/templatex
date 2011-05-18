/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbManagement;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class deleteUser_new extends HttpServlet
{
  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, ClassNotFoundException
  {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    String print_back_button = "<button type=\"button\" " + "onclick=\"window.location.href='UserDelete.html'\">" + "Return to Form</button>";
    String print_home_button = "<button type=\"button\" " + "onclick=\"window.location.href='start_admin.html'\">" + "Go to Startpage</button>";
    response.setContentType("text/html;charset=UTF-8");
    HTMLHelper.printHeader(out);
    Connection connection = null;
    ResultSet rs = null;
    boolean input_good = true;
    boolean pwd_good = false;
    String email = request.getParameter("email");

    try
    {
      connection = DBManager.establishConnection();
    } catch (SQLException ex)
    {
      Logger.getLogger(deleteUser_new.class.getName()).log(Level.SEVERE, null, ex);
    }

    Statement statement = null;
    try
    {
      statement = connection.createStatement();
    } catch (SQLException ex)
    {
      Logger.getLogger(deleteUser_new.class.getName()).log(Level.SEVERE, null, ex);
    }


    if (email.isEmpty())
    {
      input_good = false;
      out.println("<p>Please insert email address!</p>");
      out.println(print_back_button);
      out.println(print_home_button);
    } else
    {
      try
      {
        rs = statement.executeQuery("SELECT email FROM users WHERE email = \"" + email + "\";");
      } catch (SQLException ex)
      {
        Logger.getLogger(deleteUser_new.class.getName()).log(Level.SEVERE, null, ex);
      }

      try
      {
        statement.execute("DELETE FROM users WHERE email = '" + email + "' ;");
        out.println("<p>User successfully deleted!</p>");
        out.println(print_back_button);
        out.println(print_home_button);
      } catch (SQLException ex)
      {
        Logger.getLogger(deleteUser_new.class.getName()).log(Level.SEVERE, null, ex);
      }


    }
    HTMLHelper.printFooter(out);
    out.close();
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
      processRequest(request, response);
    } catch (ClassNotFoundException ex)
    {
      Logger.getLogger(deleteUser_new.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException
  {
    try
    {
      processRequest(request, response);
    } catch (ClassNotFoundException ex)
    {
      Logger.getLogger(deleteUser_new.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
 