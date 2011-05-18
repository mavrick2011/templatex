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
        //PrintWriter pout = response.getWriter();

        String filename = "test.tex";       //test
        File f = null;

        String test_string = request.getParameter("test_string");
        String save_db = request.getParameter("cb_save_db");
        String save_hd = request.getParameter("cb_save_hd");

        f = test(filename, test_string);

        if( (save_db == null) && (save_hd == null) ){
            PrintWriter pout = response.getWriter();
            HTMLHelper.printErrorInvalidTexFileSaveOption(pout);
            pout.flush();
            pout.close();
            return;
        }
        else if( !(save_hd == null) ){
            saveToHarddisk(response, f);
        }
        else if( !(save_db == null)){
            PrintWriter pout = response.getWriter();
            HTMLHelper.printDebugMsg(pout, "Not implemented yet!") ;
            pout.flush();
            pout.close();
            saveToDatabase(response, f);
        }
        
    }

    /*
     */
    public void saveToHarddisk(HttpServletResponse response, File f)
    throws ServletException, IOException{
        int                 length   = 0;
        ServletOutputStream op       = response.getOutputStream();
        //ServletContext      context  = getServletConfig().getServletContext();

        response.setContentLength( (int)f.length() );

        response.setHeader( "Content-Disposition", "attachment; filename=\"" + f.getName() + "\"" );

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

    public void saveToDatabase(HttpServletResponse response, File f){
        //not implemented yet
    }


    public BasicTexFileCreator(/*String filename, BufferedWriter out*/) throws IOException{
	}

	/*
	 * Creating sample .tex file
	 */
	private File test(String filename, String test_string) throws IOException{
        ArrayList<String> test_data = new ArrayList<String>();
        File sample_file = new File(filename);
        if(!sample_file.exists()){
          sample_file.createNewFile();
        }
        BufferedWriter out = new BufferedWriter(new FileWriter( sample_file ));

		test_data.add("\\documentclass[11pt]{scrartcl} ");
		test_data.add("\\usepackage[utf8x]{inputenc}");
		test_data.add("\\usepackage{ngerman}");
		//document start
		test_data.add("\\begin{document}");
		test_data.add("Sample LaTeX file.");
		test_data.add("User Test Sring: " + test_string);
		//document end
		test_data.add("\\end{document}");

		for(int i=0; i<test_data.size(); i++){
			out.write( test_data.get(i) );
			out.write( System.getProperty("line.separator") );
			out.write( System.getProperty("line.separator") );
		}

        out.flush();
        out.close();

        return sample_file;
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



