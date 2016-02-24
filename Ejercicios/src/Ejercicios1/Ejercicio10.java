package Ejercicios1;


import java.io.IOException;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ejercicio10")

@MultipartConfig(location = "d:\\upload", maxFileSize = 10485760L)

public class Ejercicio10 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ejercicio10() {
		super();

	}

	public String generaInput(Map<String, String> datos, String tipo) {

		String inputs = "";

		for (String clave : datos.keySet()) {

			inputs += datos.get(clave) + " <input type='" + tipo + "' name='" + clave + "' /><br>";

		}

		return inputs;

	}	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String> inputDatos = new LinkedHashMap<String, String>();

		inputDatos.put("nombre", "Nombre");
		
		inputDatos.put("clave", "Clave");		

		String html1 = generaInput(inputDatos, "text");

		response.setContentType("text/html");

		response.getWriter().println("<form action='Ejercicio10' method='post' enctype='multipart/form-data'>");

		response.getWriter().println(html1 + "<br>");

		response.getWriter().println("<input type='submit' value='Enviar'></form>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] recupCookie = request.getCookies();
		
		boolean tieneCookie=false;
		
		long tiempoResultado=0;

		
		if (recupCookie == null){
			
			long tiempoActual = System.currentTimeMillis();
			
			String miliSeg = Long.toString(tiempoActual);
			
			Cookie tiempo = new Cookie("tiempo", miliSeg);
			
			response.addCookie(tiempo);		
		}
		
		else{
			
			String miliSeg = recupCookie[0].getValue();
			
			long tiempoAnterior=Long.parseLong(miliSeg);

			long tiempoActual = System.currentTimeMillis();
			
			tiempoResultado = (tiempoActual - tiempoAnterior)/1000;
			
			tieneCookie=true;
			
			miliSeg = Long.toString(tiempoActual);
			
			Cookie tiempo = new Cookie("tiempo", miliSeg);
			
			response.addCookie(tiempo);
			
		}
		
		

		
		Map<String, String> users = new LinkedHashMap<String, String>();	
		
		users.put("guille", "gml");
		
		users.put("guille2", "gml2");
				
		String nombre = request.getParameter("nombre");
		
		String clave = request.getParameter("clave");

		if(users.containsKey(nombre) && users.get(nombre).equals(clave)){
			
			if(tieneCookie){
				
				if(tiempoResultado<60){
					
					response.getWriter().println("Hola "+nombre+" hace "+tiempoResultado+" segundos que no te conectas");
					
				}
				
				else{
					
					response.getWriter().println("Hola "+nombre+" hace más de 1 minuto que no te conectas");
					
				}
				
				
			}
			
			else{
				
				response.getWriter().println("Hola "+nombre+". Este es tu primer inicio de sesión.");
				
			}
			
			
			
		}
		
		else{
			
			response.getWriter().println("<h1>Usuario/Contraseña incorrectos</h1>");
			
		}
			
	}
}
