/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbManagement;

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
            + "        <title>Flower Buds</title>"
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
    out.println("<h2>User operations:</h2>"
            + "<h3><a href=\"createTemplate.html\">Create new template</a><br></h3>"
            + "<h3><a href=\"openTemplate.html\">Open template</a><br></h3>"
            + "<h3><a href=\"loadTemplate.html\">Upload template</a><br></h3>");
  }
  static void printAdminMenu(PrintWriter out)
  {
    out.println("<h2>Admin operations:</h2>"
            + "<h3><a href=\"addUser.html\">Create new user</a><br></h3>"
            + "<h3><a href=\"deleteUser.html\">Delete user</a><br></h3>"
            + "<h3><a href=\"addCategory.html\">Create new category</a><br></h3>"
            + "<h3><a href=\"createTemplate.html\">Create new template</a><br></h3>"
            + "<h3><a href=\"openTemplate.html\">Open template</a><br></h3>"
            + "<h3><a href=\"loadTemplate.html\">Upload template</a><br></h3>");
  }
  static void printErrorInvalidCombination(PrintWriter out)
  {
    out.print("<h1>Incorrect Username/Password Combination!</h1><br><br>"
            + "<h1><a href=\"index.html\">Try again!</a></h1>");
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
}