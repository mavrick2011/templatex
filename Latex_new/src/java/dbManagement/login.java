/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbManagement;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
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
public class login extends HttpServlet
{
  
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException
  {
    try
    {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      HTMLHelper.printHeader(out);
      Connection connection = DBManager.establishConnection();
      Statement statement = connection.createStatement();
      ResultSet rs;

      String username = request.getParameter("username");
      String password = request.getParameter("password");
      if (username.isEmpty())
      {
        HTMLHelper.printErrorNoUsername(out);
      } else if (password.isEmpty())
      {
        HTMLHelper.printErrorNoPassword(out);
      }


      //Get username from DB
      rs = statement.executeQuery("SELECT username FROM users WHERE username='" + username + "';");
      String username_rs = "";
      while (rs.next())
      {
        username_rs = rs.getString("username");
      }

      //Get password from DB
      rs = statement.executeQuery("SELECT password FROM users WHERE username='" + username + "';");
      String password_rs = "";
      while (rs.next())
      {
        password_rs = rs.getString("password");
      }

      //Get permission from DB
      rs = statement.executeQuery("SELECT Permission FROM users WHERE username='" + username + "';");
      String permission_rs = "";
      while (rs.next())
      {
        permission_rs = rs.getString("Permission");
      }

      if (password_rs.equals(password))
      {
        if (permission_rs.equals("admin"))
        {
          HTMLHelper.printAdminMenu(out);
        } else if (permission_rs.equals("user"))
        {
          HTMLHelper.printUserMenu(out);
        }
      } else if (!username.isEmpty() && !password.isEmpty())
      {
        HTMLHelper.printErrorInvalidCombination(out);
      }
      HTMLHelper.printFooter(out);
      statement.close();
      connection.close();
      out.close();
    } catch (SQLException ex)
    {
      Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex)
    {
      Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    }


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
    processRequest(request, response);


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
    processRequest(request, response);


  }
  /**
   * Returns a short description of the servlet.
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo()
  {
    return "Short description";


  }// </editor-fold>
}
