/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dbManagement;

import org.junit.* ;
import static org.junit.Assert.* ;


/**
 *
 * @author user
 */
public class BasicTexFieldTest {

   @Test
   public void test_returnEuro() {
      System.out.println("Test if getters in BasicTexField are working") ;
      BasicTexField tf1 = new BasicTexField("name1");

      assertTrue(tf1.getName().equals("name1")) ;
   }


}
