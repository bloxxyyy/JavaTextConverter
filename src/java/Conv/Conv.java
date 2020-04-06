package Conv;

/*
 * Copyright (C) 2020 Mark Blokker ~ Ad-Blokker
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mark Blokker ~ Ad-Blokker
 */
@WebServlet(urlPatterns = {"/Conv"})
public class Conv extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Content-Type", "text/plain; charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String input = request.getParameter("input");
        String convtype = request.getParameter("format");
        String output = "";
        boolean validConvType = false;

        // <editor-fold defaultstate="collapsed" desc="ALL CAPS. Click on the + sign on the left to edit the code.">
        if (convtype.equals("caps")) {
            validConvType = true;
            output = input.toUpperCase();
        }
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Alternating and Inverted alternating Case. Click on the + sign on the left to edit the code.">
        if (convtype.equals("altcase") || convtype.equals("invaltcase")) {
            input = input.toLowerCase();
            validConvType = true;
            for (int i = 0; i < input.length(); i++) {

                char test = input.charAt(i);
                if (Character.isWhitespace(test)) {
                    output += input.charAt(i);
                    if (i + 1 < input.length()) {
                        i++;
                    }                     
                }
                if (convtype.equals("invaltcase")) {
                    output += input.charAt(i);
                } else { //altcase
                    output += input.toUpperCase().charAt(i);
                }
                if (i + 1 < input.length()) {
                    i++;
                    test = input.charAt(i);
                    if (Character.isWhitespace(test)) {
                        output += input.charAt(i);
                        if (i + 1 < input.length()) {
                            i++;
                        }
                    }
                    if (convtype.equals("invaltcase")) {
                        output += input.toUpperCase().charAt(i);
                    } else { //altcase
                        output += input.charAt(i);
                    }
                }
            }
        }
        
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Random Case. Click on the + sign on the left to edit the code.">
        if (convtype.equals("randomcase")) {
            input = input.toLowerCase();
            validConvType = true;
            Random coin = new Random();  

            for (int i = 0; i < input.length(); i++) {
                if (coin.nextInt(2) == 0) { //change to higher number and try to dived by 2
                    output += input.toUpperCase().charAt(i);
                } else {
                    output += input.charAt(i);
                }
            }
        }
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Leetspeak. Click on the + sign on the left to edit the code.">
        if (convtype.equals("leet")) {
            input = input.toLowerCase();
            validConvType = true;
            Leet l33t = new Leet();
            l33t.leetConv(input.toLowerCase());
            output = l33t.getLeet();
        }
        
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Angry case. Click on the + sign on the left to edit the code.">
        if (convtype.equals("angrycase")) {
            validConvType = true;
            boolean lastCharDot = false;
            output += input.toUpperCase().charAt(0);
            for (int i = 1; i < input.length(); i++) {
                char test = input.charAt(i);
                if (test == '.'){
                    continue;
                }
                if (Character.isWhitespace(test)) {
                    output += ". ";
                    if (i + 1 < input.length()) {
                        i++;
                        output = output + input.toUpperCase().charAt(i);
                    }                     
                } else {
                    output += input.charAt(i);
                }
                test = input.charAt(i);
                lastCharDot = test == '.' || test == '!' || test == '?';
               
            }
            if (!lastCharDot){
                output += ".";
            }
            
        }
        // </editor-fold>
        
        
        // <editor-fold defaultstate="collapsed" desc="Print out. Click on the + sign on the left to edit the code.">

        try (PrintWriter writer = response.getWriter()) {
            if (validConvType) {
                writer.print(output);
            } else {
                response.setStatus(400);
                writer.print("You dum-dum, conversion type no exist. :(");
            }
        }
        // </editor-fold>
        
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "CaseConverter";
    }
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + "Get is not supported" + "</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>You donut! You can't use 'get' on this part of the application</h2>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}
