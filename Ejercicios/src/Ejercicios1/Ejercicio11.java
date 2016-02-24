package Ejercicios1;

import java.io.IOException;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Ejercicio11")

@MultipartConfig(location = "d:\\upload", maxFileSize = 10485760L)

public class Ejercicio11 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ejercicio11() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		

		response.setContentType("text/html");

		response.getWriter().println("<form action='Ejercicio11' method='post' enctype='multipart/form-data'>");

		response.getWriter().println("Nombre <input type='text' name='nombre' /> <br>");

		response.getWriter().println("<input type='submit' value='Enviar'></form>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashSet<String> users = new HashSet<String>();
		
		users.add("guille");
		
		users.add("maria");

		HttpSession sesion = request.getSession(true);
		
		String nombre = request.getParameter("nombre");
		
		if (users.contains(nombre)) {
			
			Integer contador = (Integer)sesion.getAttribute(nombre);
			
			int contadorVisitas = 0;
			
			if(contador == null){
				
				sesion.setAttribute(nombre, new Integer(0));			
			}
			
			else{
				
				contadorVisitas = contador.intValue();
				
				contadorVisitas++;
				
				sesion.setAttribute(nombre, (Integer)contadorVisitas);
			}			
					
			if(contadorVisitas == 0){
				
				response.getWriter().println("Bienvenido "+ nombre + ". Este es tu primer inicio de sesión");
				
			}

			else{
				
				response.getWriter().println("Bienvenido "+ nombre + ". Número de inicio de sesiones: "+ contadorVisitas);				
			}	
		}
		
		else{
			
			response.getWriter().println("Usuario incorrecto");
			
		}
	}
}
