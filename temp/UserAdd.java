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
public class UserAdd extends HttpServlet {

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

          String username = request.getParameter("username");
          if (username.isEmpty()) input_good = false;
          String password = request.getParameter("password");
          if (username.isEmpty()) input_good = false;
          String password2 = request.getParameter("password2");
          if (username.isEmpty()) input_good = false;
          if (password.equals(password2))  pwd_good = true;
          String company = request.getParameter("company");
          if (company.isEmpty()) input_good = false;
          String degree = request.getParameter("degree");
          String name = request.getParameter("name");
          if (name.isEmpty()) input_good = false;
          String surname = request.getParameter("surname");
          if (surname.isEmpty()) input_good = false;
          String street = request.getParameter("street");
          if (street.isEmpty()) input_good = false;
          String street_no = request.getParameter("streetno");
          if (street_no.isEmpty()) input_good = false;
          String zip_code = request.getParameter("zipcode");
          if (zip_code.isEmpty()) input_good = false;
          String city = request.getParameter("city");
          if (city.isEmpty()) input_good = false;
          String country = request.getParameter("country");
          if (country.isEmpty()) input_good = false;
          String email = request.getParameter("email");
          if (email.isEmpty()) input_good = false;
          String bank_account = request.getParameter("bankaccount");
          if (bank_account.isEmpty()) input_good = false;
          String uid = request.getParameter("uid");
          if (uid.isEmpty()) input_good = false;
          String phone = request.getParameter("telephone");
          if (phone.isEmpty()) input_good = false;
          String fax = request.getParameter("fax");
          if (fax.isEmpty()) input_good = false;

          out.println("<html>\n<head><title>Add User</title></head><body>");

          if (!pwd_good || !input_good)
          {
            if(!input_good)
              out.println("<p>Please insert content into all fields!</p>");

            if(!pwd_good)
              out.println("<p>Passwords must match!</p>");

            out.println("</body>\n</html>");
            return;
          }



          try
          {
            Connection connection = establishConnection();

            String insert_sql_stmt = "INSERT INTO user VALUES (" + username + ","
                    + password + "," + degree + "," + name + "," + surname + ","
                    + street +"," + street_no + "," + zip_code + "," + city + ","
                    + country + "," + phone + "," + fax + "," + email + ","
                    + company + "," + bank_account + "," + uid + ")";

          Statement statement = connection.createStatement();
          statement.executeUpdate(insert_sql_stmt);  //insert new user
          out.println("<p>New user successfully added!</p>");

        }catch(SQLException exc){
          exc.printStackTrace();
          out.println("<p>Can not insert a new user: database error!</p>");
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
