/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package templatex;

import java.io.PrintWriter;

/**
 *
 * @author user
 */
public class HTMLHelper
{
  static void printHeader(PrintWriter out)
  {
    out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \""
            + "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">"
            + "<html xmlns=\"http://www.w3.org/1999/xhtml\">"
            + "    <head>"
            + "        <meta name=\"keywords\" content=\"\" />"
            + "        <meta name=\"description\" content=\"\" />"
            + "        <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />"
            + "        <title>Templatex</title>"
            + "        <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />"
            + "    </head>"
            + "    <body>"
            + "        <div id=\"wrapper\">"
            + "            <!-- end #menu -->"
            + "            <div id=\"header\">"
            + "                <div id=\"logo\">"
            + "                    <h1><a href=\"#\">TempLaTeX   </a></h1>"
            + "                    <p>designed by RedBerry Software Solutions</p>"
            + "                </div>"
            + "            </div>"
            + "            <!-- end #header -->"
            + "            <div id=\"page\">"
            + "                <div id=\"page-bgtop\">"
            + "                    <div id=\"page-bgbtm\">"
            + "                        <div id=\"content\">"
            + "                            <div class=\"post.links\">"
            + "                                <div style=\"clear: both;\">&nbsp;</div>"
            + "                                <div class=\"entry\">");

  }
  static void printFooter(PrintWriter out)
  {
    out.println("</div>"
            + "                            </div>"
            + "                            <div style=\"clear: both;\">&nbsp;</div>"
            + "                        </div>"
            + "                        <!-- end #content -->"
            + "                        <div style=\"clear: both;\">&nbsp;</div>"
            + "                    </div>"
            + "                </div>"
            + "            </div>"
            + "            <!-- end #page -->"
            + "        </div>"
            + "        <div id=\"footer\">"
            + "            <p>Design by <a href=\"http://www.freecsstemplates.org/\">Free CSS Templates</a></p>"
            + "        </div>"
            + "        <!-- end #footer -->"
            + "    </body>"
            + "</html>");
  }
  static void printUserMenu(PrintWriter out)
  {
    out.println("<table>"
            + "<tr>"
            + "  <td><h3><a href=\"addUser.html\">Create new user</a></h3></td>"
            + "  <td><h3><a href=\"deleteUser.html\">Delete user</a></h3></td>"
            + "  <td><h3><a href=\"loadTemplate.html\">Upload template</a></h3></td>"
            + "</tr>"
            + "</table>");
  }
  static void printAdminMenu(PrintWriter out)
  {
    out.println("<table>"
            + "<tr>"
            + "  <td><h3><a href=\"addUser.html\">Create new user</a></h3></td>"
            + "  <td><h3><a href=\"deleteUser.html\">Delete user</a></h3></td>"
            + "  <td><h3><a href=\"addCategory.html\">Create new category</a></h3></td>"
            + "</tr>"
            + "<tr>"
            + "  <td><h3><a href=\"createTemplate.html\">Create new template</a></h3></td>"
            + "  <td><h3><a href=\"openTemplate.html\">Open template</a></h3></td>"
            + "  <td><h3><a href=\"loadTemplate.html\">Upload template</a></h3></td>"
            + "</tr>"
            + "</table>");
  }
  static void printErrorInvalidCombination(PrintWriter out)
  {
    out.print("<h1>Incorrect Username/Password Combination!</h1><br><br>"
            + "<h1><a href=\"index.html\">Try again!</a></h1>");
  }
  static void printErrorUsernameTaken(PrintWriter out)
  {
    out.print("<h1>The username is already taken!</h1><br><br>"
            + "<h1><a href=\"addUser.html\">Try again!</a></h1>");
  }
  static void printErrorIncompatibelPawwords(PrintWriter out)
  {
    out.print("<h1>The two passwords are not the same!</h1><br><br>"
            + "<h1><a href=\"addUser.html\">Try again!</a></h1>");
  }
  static void printErrorNoPassword(PrintWriter out)
  {
    out.println("<h1>Please also enter your password!</h1>"
            + "<br><br><h1><a href=\"index.html\">Try again!</a></h1>");
  }
  static void printErrorNoUsername(PrintWriter out)
  {
    out.println("<h1>Please enter your username!</h1>"
            + "<br><br><h1><a href=\"index.html\">Try again!</a></h1>");
  }
  static void printErrorNoTexFileParameter(PrintWriter out)
  {
    out.println("<h1>No TexFileParameter!</h1>" /* + "<br><br><h1><a href=\"____.html\">Try again!</a></h1>"*/);
  }
  static void printErrorInvalidTexFileSaveOption(PrintWriter out)
  {
    out.print("<h1>No save option selected!</h1><br><br>"
            + "<h1><a href=\"createTemplate.html\">Try again!</a></h1>");
  }
  static void printNotAllFilledIn(PrintWriter out)
  {
    out.println("<h1>Please enter all required Information marked by *!</h1>");
  }
  static void printErrorMsg(PrintWriter out, String error_message)
  {
    out.println("<h1>" + error_message + "</h1>");
  }

  /*
   * debug only
   */
  static void printDebugMsg(PrintWriter out, String debug_msg)
  {
    out.println("<h1>" + debug_msg + "</h1>");
  }
  static void printInsertCompleted(PrintWriter out, String password, String username, int userid, String permission, String company, String degree, String name, String surname, String street, String zipcode, String city, String country, String email, String phone, String fax)
  {
    out.println("<h1>You've added an user with the following data:</h1>");
    out.println("<h2>Password:      " + password + "</h2>");
    out.println("<h2>Username:      " + username + "</h2>");
    out.println("<h2>UserID:        " + userid + "</h2>");
    out.println("<h2>Permission:    " + permission + "</h2>");
    out.println("<h2>Company:       " + company + "</h2>");
    out.println("<h2>Degree:        " + degree + "</h2>");
    out.println("<h2>Name:          " + name + "</h2>");
    out.println("<h2>Surname:       " + surname + "</h2>");
    out.println("<h2>Street:        " + street + "</h2>");
    out.println("<h2>Zipcode:       " + zipcode + "</h2>");
    out.println("<h2>City:          " + city + "</h2>");
    out.println("<h2>Country:       " + country + "</h2>");
    out.println("<h2>Email:         " + email + "</h2>");
    out.println("<h2>Phone:         " + phone + "</h2>");
    out.println("<h2>Fax:           " + fax + "</h2>");
  }
}
