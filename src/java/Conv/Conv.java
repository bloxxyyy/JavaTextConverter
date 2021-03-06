package Conv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Conv"})
public class Conv extends HttpServlet {

    private string CheckAltInval(String input) {
        
        String output = "";
        
        for (int i = 0; i < input.length(); i++) {

            char text = input.charAt(i);
            
            if (Character.isWhitespace(text)) {
                output += input.charAt(i);
                    if (i + 1 < input.length()) i++;              
            }
            
            output += convtype.equals("invaltcase") : input.charAt(i) ? input.toUpperCase().charAt(i);
            
            if (i + 1 < input.length()) {
                i++;
                text = input.charAt(i);
                
                
                if (Character.isWhitespace(text))
                    output += input.charAt(i);
                    if (i + 1 < input.length()) i++;
                }
                
                output += convtype.equals("invaltcase") : input.toUpperCase().charAt(i) ? input.charAt(i);
            }
        }
        
        return output;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Content-Type", "text/plain; charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        
        String input = request.getParameter("input");
        String convtype = request.getParameter("format");
        String output = "";
        
        input = input.toLowerCase();
        
        boolean valid = true;
        
        switch (convtype) {
            case "caps":
                output = input.toUpperCase();
            break;
                
            case "altcase":
                output = CheckAltInval(input);
            break;
                
            case "invaltcase":
                output = CheckAltInval(input);
            break;
                
            case "randomcase":
                Random coin = new Random();  
                for (int i = 0; i < input.length(); i++) {
                    output += (coin.nextInt(2) == 0) : input.toUpperCase().charAt(i) ? input.charAt(i);
                }
            break;
                
            case "leet":
                Leet l33t = new Leet();
                l33t.leetConv(input);
                output = l33t.getLeet();
            break;
                
            case "angrycase":
                boolean lastCharDot = false;
                output += input.toUpperCase().charAt(0);
                
                for (int i = 1; i < input.length(); i++) {
                    char text = input.charAt(i);
                    if (text == '.') continue; 
                    
                    if (Character.isWhitespace(text)) {
                        output += ". ";
                        if (i + 1 < input.length()) {
                            i++;
                            output += input.toUpperCase().charAt(i);
                        }                     
                    } else {
                        output += input.charAt(i);
                    }
                    
                    text = input.charAt(i);
                    lastCharDot = text == '.' || test == '!' || test == '?';
                   
                }
                if (!lastCharDot) output += ".";
            break;
            
            default:
                valid = false;
            break;
        }
        

        try (PrintWriter writer = response.getWriter()) {
            if (valid) writer.print(output);
            else {
                response.setStatus(400);
                writer.print("You dum-dum, conversion type no exist. :(");
            }
        }
    }

    @Override
    public String getServletInfo() => return "CaseConverter";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
