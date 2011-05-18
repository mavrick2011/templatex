///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
//
//
//package dbManagement;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//
///**
// *
// * @author Administrator
// */
//public class BasicTexFileParser {
//    BasicTexFileStructure file_structure_ = null;
//
//    BasicTexFileParser(File file_to_parse){
//        parseFile(file_to_parse);
//    }
//
//    public BasicTexFileStructure getBasicTexFileStructure(){
//
//
//        return file_structure_;
//    }
//
//    private void parseFile(File file_to_parse) {
//        BufferedReader br;
//        try {
//          br = new BufferedReader(new FileReader(file_to_parse));
//        } catch (FileNotFoundException fnfe) {
//          System.out
//              .println("Cannot locate input file! " + fnfe.getMessage());
//          System.exit(0);
//        }
//        try {
//          String REGEX = "_SPACER_\\w_";
//          INPUT = br.readLine();
//        } catch (IOException ioe) {
//        }
//
//        // http://www.java2s.com/Code/Java/Regular-Expressions/JavaRegularExpressionFileandFind.htm
//
//        pattern = Pattern.compile(REGEX);
//        matcher = pattern.matcher(INPUT);
//
//    }
//
//
//
//
//
//}*/
