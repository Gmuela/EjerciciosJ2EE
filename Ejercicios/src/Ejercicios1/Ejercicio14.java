package Ejercicios1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ejercicio14")

@MultipartConfig(location = "d:\\upload", maxFileSize = 10485760L)

public class Ejercicio14 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ejercicio14() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/JSPEjercicios.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		int isbn = Integer.parseInt(request.getParameter("isbn"));

		String titulo = (String) request.getParameter("tit");

		String categoria = (String) request.getParameter("cat");
		
		LibroEj14 libro = new LibroEj14(isbn,titulo,categoria);
		
		libro.conectarBD();
		
		libro.prepararBD();
		
		libro.ejecutarBD();
		
		String consulta = libro.consultaBD();
		
		response.getWriter().println(consulta);
	}
}
