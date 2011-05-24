/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package templatex;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import java.util.Enumeration;

/**
 *
 * @author user
 */
public class import_template extends HttpServlet {
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        MultipartRequest multi =
        new MultipartRequest(request, "/", 50 *1024 * 1024,
          new com.oreilly.servlet.multipart.DefaultFileRenamePolicy());


        try {
            
        HTMLHelper.printHeader(out);
        Enumeration imported_file = multi.getFileNames();

        //BasicTexFileStructure bla = new BasicTexFileParser(imported_file);
        //bla.saveToBase();
          while (imported_file.hasMoreElements()) {
            String name = (String)imported_file.nextElement();
            String filename = multi.getFilesystemName(name);
            String original = multi.getOriginalFileName(name);
            String type = multi.getContentType(name);
            File f = multi.getFile(name);
            out.println("name: " + name);
            out.println("filename: " + filename);
            if (filename != null && !filename.equals(original)) {
              out.println("original file name: " + original);
            }
            out.println("type: " + type);
            if (f != null) {
              out.println("length: " + f.length());
            }
            out.println();
          }
        HTMLHelper.printFooter(out);
        } finally { 
            out.close();
        }
    } 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
