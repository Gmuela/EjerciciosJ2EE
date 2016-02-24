package Ejercicios1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ejercicio4")

public class Ejercicio4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ejercicio4() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.getWriter().println("<form action='Ejercicio4' method='post'>"
				+ "Nombre <input type='text' name='nombre'>" + "<input type='submit' value'Enviar'>" + "</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.getWriter().println("Hola " + request.getParameter("nombre"));

	}

}
