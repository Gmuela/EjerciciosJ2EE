package Ejercicios1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ejercicio6")
public class Ejercicio6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Ejercicio6() {
        super();
        
    }

	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.getWriter().println("<form action='Ejercicio6' method='post'>"
				+ "Nombre <input type='text' name='nombre'>"
				+ "<br>"
				+ "<h2>Aficiones</h2>"
				+ "Bailar <input type='checkbox' name='aficion[]' value='bailar' /><br>"
				+ "Cantar <input type='checkbox' name='aficion[]' value='cantar' /><br>"
				+ "<input type='submit' value'Enviar'>"							
				+ "</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String nombre = request.getParameter("nombre");
		
		String[] aficiones = request.getParameterValues("aficion[]");
		
		if(nombre != ""){
			
			if(aficiones == null){
				
				response.getWriter().println("A "+ nombre + " no le gusta nada");
				
			}
			
			else{
				
				response.getWriter().println("A "+ nombre +" le gusta");
				
				for(int i=0;i<aficiones.length;i++){
					
					response.getWriter().println(aficiones[i]+", ");
					
				}				
			}			
		}
					
		else{
			
			response.getWriter().println("Debes introducir un nombre");
			
		}		
	}

}
