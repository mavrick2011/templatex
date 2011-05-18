/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dbManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class DBManager {
  //----------------------------------------------------------------------------
  // METHOD      : establishConnection()
  // Desciption  : Creates the connection to the database with username and
  //               password "student"
  //----------------------------------------------------------------------------
  public static Connection establishConnection() throws SQLException,
  ClassNotFoundException
  {
    Class.forName("com.mysql.jdbc.Driver");
    return DriverManager.getConnection("jdbc:mysql://localhost/sw", "student",
                                       "student");
  }

  public static boolean saveTemplateIntoDB(Connection con, String template)
  {
    ResultSet rs;


    return true;
  }

}
