/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package templatex;

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
 * @author lena
 */
public class UserAdministration extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    protected void addUserIntoDB(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String print_back_button = "<button type=\"button\" " +
           "onclick=\"window.location.href='UserDelete.html'\">" +
           "Return to Form</button>";
        String print_home_button = "<button type=\"button\" " +
          "onclick=\"window.location.href='start_admin.html'\">" +
          "Go to Startpage</button>";

       /*
       * get parameters for new user
       * check if all parameters given
       * check if given passwords match
       * insert new user to table
       * buttons to go back to input form or startpage
       */
        try {
          boolean input_good = true,
                  pwd_good = false,
                  email_good = true;

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
          String permission = request.getParameter("permission");
          // no check -> set standard value for combobox

          // Check if given email doesn't exist yet
          // is used to identify user in UserDelete and has to be unique anyway (-> so make shure it is)
          // see check in UserDelete

          HTMLHelper.printHeader(out);
          out.println("<p aligh=\"center\">");
          Connection connection = DBManager.establishConnection();
          Statement statement = connection.createStatement();
          ResultSet rset = statement.executeQuery("SELECT email FROM user WHERE email =' " + email + "';");
          if(rset.getFetchSize() > 0)
            email_good = false;

          if (!pwd_good || !input_good)
          {
            if(!input_good)
              out.println("Please provide all Parameters for the new User!");

            if(!pwd_good)
              out.println("Password confirmation has to match original password!");

            if(!email_good)
              out.println("<p>Given email address already exists! Must be unique!</p>");


            out.println(print_back_button);
          }
          else
          {
            try
            {
              String insert_sql_stmt = "INSERT INTO users VALUES (" + password + ","
                      + username + ", '' ," + request.getParameter("permission") + "," + "Firma X" + degree
                      + "," + name + "," + surname + "," + street +"," + zip_code
                      + "," + city + "," + country + "," + email + ","
                      + phone + "," + fax + ")";
              
              statement.executeUpdate(insert_sql_stmt);  //insert new user
              out.println("New user successfully added!");
              out.println(print_back_button);
              out.println(print_home_button);
            }catch(SQLException exc){
              exc.printStackTrace();
              out.println("Unable to insert a new user: database error!");
              out.println(print_back_button);
              out.println(print_home_button);
            }
          }

        out.println("</p>");

        HTMLHelper.printFooter(out);
        out.close();

        } catch (SQLException ex)
    {
      Logger.getLogger(UserAdministration.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex)
        {
          Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void deleteUserFromDB(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            String print_back_button = "<button type=\"button\" " +
               "onclick=\"window.location.href='UserDelete.html'\">" +
               "Return to Form</button>";
            String print_home_button = "<button type=\"button\" " +
              "onclick=\"window.location.href='start_admin.html'\">" +
              "Go to Startpage</button>";

            /*
             * check if there is input
             * look for table entry with the given email
             * delete entry with corresponding email
             * buttons to go back to form or startpage
             */
            try {
              boolean input_good = true,
                      pwd_good = false;

              String email = request.getParameter("email");
              if (email.isEmpty()) input_good = false;

              HTMLHelper.printHeader(out);
              out.println("<p align=\"center\">");

              if(!input_good)
              {
                out.println("<p>Please insert email address!</p>");
                out.println(print_back_button);
              }
              else
              {
                Connection connection = DBManager.establishConnection();
                Statement statement = connection.createStatement();
                ResultSet rset = statement.executeQuery("SELECT email FROM user WHERE email =' " + email + "';");
                if(rset.getFetchSize() == 0)
                {
                  out.println("<p>No User with given email address!</p>");
                  out.println(print_back_button);
                  out.println(print_home_button);
                }
                else
                {
                  try
                  {
                    String delete_stmt = "DELETE FROM user WHERE email = '" + email + "';";
                    statement.execute(delete_stmt);
                    out.println("<p>User successfully deleted!</p>");
                    out.println(print_back_button);
                    out.println(print_home_button);
                  }catch(SQLException exc){
                    exc.printStackTrace();
                    out.println("<p>Unable to delete user: database error!</p>");
                    out.println(print_back_button);
                    out.println(print_home_button);
                  }
                }

              }

              out.println("</p>");
              HTMLHelper.printFooter(out);
              out.close();

              } catch (SQLException ex)
              {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
              } catch (ClassNotFoundException ex)
              {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
              }

        }


}
