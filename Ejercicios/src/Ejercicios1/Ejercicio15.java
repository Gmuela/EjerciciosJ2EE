package Ejercicios1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ejercicio15")

@MultipartConfig(location = "d:\\upload", maxFileSize = 10485760L)

public class Ejercicio15 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ejercicio15() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/JSPEjercicios.jsp").forward(request, response);
		doPost(request,response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		response.setContentType("text/html");

		
		int isbn = Integer.parseInt(request.getParameter("isbn"));

		String titulo = (String) request.getParameter("tit");

		String categoria = (String) request.getParameter("cat");

		LibroEj15 libro = new LibroEj15(isbn, titulo, categoria);

		LibroDAO libroDAO = new LibroDAO(libro);

		libroDAO.conectarBD();

		libroDAO.prepararBD();

		libroDAO.ejecutarBD();
		
		List<LibroEj15> consulta = libroDAO.consultaBD();

		request.setAttribute("listaLibros", consulta);

		request.getRequestDispatcher("/VistaLibros.jsp").forward(request, response);

	}
}
