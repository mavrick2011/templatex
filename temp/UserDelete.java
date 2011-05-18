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
 * @author lena
 */
public class UserDelete extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    private static Connection establishConnection() throws SQLException,
          ClassNotFoundException
    {
      Class.forName("com.mysql.jdbc.Driver");
      return DriverManager.getConnection("jdbc:mysql://localhost/sw", "student",
            "student");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        try {
          boolean input_good = true, pwd_good = false;

          String email = request.getParameter("email");
          if (email.isEmpty()) input_good = false;

          out.println("<html>\n<head><title>Add User</title></head><body>");

          if(!input_good)
          {
            out.println("<p>Please insert email address!</p>");
            out.println("</body>\n</html>");
            return;
          }

          Connection connection = establishConnection();
          String entry_exist = "SELECT COUNT(*) FROM user WHERE username LIKE " + email;
          Statement statement = connection.createStatement();
          statement.executeQuery(entry_exist);  //delete user
          if(entry_exist.equals("0"))
            out.println("Email address not found!");


        try
        {
          String delete_sql_stmt = "DELETE FROM user WHERE email =" + email;

          out.println("<p>User successfully deleted!</p>");

        }catch(SQLException exc){
          exc.printStackTrace();
          out.println("<p>Can not delete user: database error!</p>");
        }

        out.println("</body>\n</html>");



        HTMLHelper.printFooter(out);
        } finally {
            out.close();
        }
    }




/*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {  */
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addUser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addUser at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
     /*   } finally {
            out.close();
        }
    } */



}
