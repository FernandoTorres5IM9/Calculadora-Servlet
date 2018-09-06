/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletHTML;

/**
 *
 * @author Gina
 */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class ServletCalculadora extends HttpServlet {
    int Numero1 = 0;
    int Numero2 = 0;
    String Operacion;
    double Resultado = 0;
    
    @Override
    public void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException{
        Numero1 = Integer.parseInt(peticion.getParameter("Num1"));
        Numero2 = Integer.parseInt(peticion.getParameter("Num2"));
        Operacion = peticion.getParameter("Operacion");
        if (Operacion.equals("Suma")) {
                Resultado = Numero1 + Numero2;
	} else if (Operacion.equals("Resta")) {
		Resultado = Numero1 - Numero2;
	} else if (Operacion.equals("Division")) {
		Resultado = Numero1 / Numero2;
	} else if (Operacion.equals("Multiplicacion")) {
		Resultado = Numero1 * Numero2;
	} else if (Operacion.equals("Seno")) {
		Resultado = Math.sin(Math.toRadians(Numero1));
	} else if (Operacion.equals("Coseno")) {
		Resultado = Math.cos(Math.toRadians(Numero1));
	} else if (Operacion.equals("Tangente")) {
		Resultado = Math.tan(Math.toRadians(Numero1));
	} else if (Operacion.equals("Logaritmo")) {
		Resultado = Math.log10(Numero1);
	} else if (Operacion.equals("Raiz")) {
		Resultado = Math.sqrt(Numero1);
	}
        PrintWriter out = new PrintWriter(respuesta.getOutputStream());
        out.println("<html>");
        out.println("<heaad><title>Resultado de operacion</title></head>");
        out.println("<body>");
        out.println("<p><h1><center>El resultado es:<b>" + Resultado + "</b></center></h1></p>");
        out.println("</body></html>");
        out.close();
    }
    
}
