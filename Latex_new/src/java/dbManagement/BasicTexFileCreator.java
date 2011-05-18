/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dbManagement;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author morthimer
 */
public class BasicTexFileCreator extends HttpServlet {
   
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("STSRT");

        //PrintWriter out2 = response.getWriter();

        /*out2.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" "
            + "\"http://www.w3.org/TR/html4/loose.dtd\"><html>	<head>		"
            + "<meta http-equiv=\"Content-Type\" content=\"text/html; "
            + "charset=ISO-8859-1\"><link rel=\"stylesheet\" type=\"text/css\" "
            + "href=\"basic_style.css\"><title>TemplaTex</title></head><body>"
            + "<div id=\"div_header\" class=\"x-div-header\"><div "
            + "id=\"div_header_top\" class=\"x-div-header-top\"><div "
            + "id=\"div_header_top_left\" class=\"x-div-header-top-left\"></div>"
            + "<div id=\"div_header_top_center\" class=\"x-div-header-top-center\">"
            + "<span class=\"x-span-header-text\">TemplaTeX</span></div>"
            + "<div id=\"div_header_top_right\" class=\"x-div-header-top-right\">"
            + "<img class=\"x-erbeere\" src=\"logo_trans.gif\"></div></div>"
            + "<div id=\"div_header_bottom\" class=\"x-div-header-bottom\"></div>"
            + "</div><div id=\"div_main_spacer_top\" class=\"x-div-main-spacer-top\">"
            + "</div><div id=\"div_main\" class=\"x-div-main\">"
            + "<div id=\"content\" class=\"x-div-content\">");*/
         
//                File test_file = new File("bla.tex");
//                ServletOutputStream outs = response.getOutputStream();
//                BufferedWriter out = new BufferedWriter(new FileWriter( test_file ));
//
//                out.write("\\documentclass[11pt]{scrartcl} ");
//                out.write("\\usepackage[utf8x]{inputenc}");
//                out.write("\\usepackage{ngerman}");
//                //document start
//                out.write("\\begin{document}");
//                out.write("Sample LaTeX file.");
//                out.write("Zeile2");
//                //document end
//                out.write("\\end{document}");
//                out.flush();
//                out.close();
//                System.out.println("BLAAA");S
        String filename = "test.tex";

        File                f        = new File(filename);
        if(!f.exists()){
          f.createNewFile();
        }
        
        BufferedWriter out = new BufferedWriter(new FileWriter( filename ));
        test(out);
        out.flush();
        out.close();

//                out.write("\\documentclass[11pt]{scrartcl} ");
//                out.write("\\usepackage[utf8x]{inputenc}");
//                out.write("\\usepackage{ngerman}");
//                //document start
//                out.write("\\begin{document}");
//                out.write("Sample LaTeX file.");
//                out.write("Zeile2");
//                //document end
//                out.write("\\end{document}");
//                out.flush();
//                out.close();


        
        int                 length   = 0;
        ServletOutputStream op       = response.getOutputStream();
        ServletContext      context  = getServletConfig().getServletContext();


       // test(op);
        //op.println(f.getAbsolutePath());
        //
        //  Set the response and go!
        //
        //
        //response.setContentType( (mimetype != null) ? mimetype : "application/octet-stream" );
        response.setContentLength( (int)f.length() );
        response.setHeader( "Content-Disposition", "attachment; filename=\"" + filename + "\"" );

        //
        //  Stream to the requester.
        //
       byte[] bbuf = new byte[5000];
        DataInputStream in = new DataInputStream(new FileInputStream(f));

        while ((in != null) && ((length = in.read(bbuf)) != -1))
        {
            op.write(bbuf,0,length);
        }

        in.close();
        op.flush();
        op.close();


        

    }

    public BasicTexFileCreator(/*String filename, BufferedWriter out*/) throws IOException{
      //String test_file = "bla";
      //out = new BufferedWriter(new FileWriter( filename + ".tex" ));
	}

	/*
	 * Creating sample .tex file
	 */
	private void test(BufferedWriter out) throws IOException{
 		ArrayList<String> test_data = new ArrayList<String>();

		test_data.add("\\documentclass[11pt]{scrartcl} ");
		test_data.add("\\usepackage[utf8x]{inputenc}");
		test_data.add("\\usepackage{ngerman}");
		//document start
		test_data.add("\\begin{document}");
		test_data.add("Sample LaTeX file.");
		test_data.add("Zeile2");
		//document end
		test_data.add("\\end{document}");

		for(int i=0; i<test_data.size(); i++){
			out.write( test_data.get(i) );
			out.write( System.getProperty("line.separator") );
			out.write( System.getProperty("line.separator") );
		}
		//out.close();
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
    throws ServletException, IOException {
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
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}



