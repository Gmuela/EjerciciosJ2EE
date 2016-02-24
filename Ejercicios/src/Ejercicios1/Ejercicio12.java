package Ejercicios1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ejercicio12")

@MultipartConfig(location = "d:\\upload", maxFileSize = 10485760L)

public class Ejercicio12 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ejercicio12() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.getWriter()
				.println("<form action='' method='post'>" + "ISBN <input type='text' name='isbn'>"
						+ "TÌtulo <input type='text' name='tit'>" + "CategorÌa <input type='text' name='cat'>"
						+ "<input type='submit' value'Enviar'>" + "</form>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		/*************************
		 * CONEXIÛN CON BASE DE DATOS
		 ***********************************/

		Connection conBD = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
		}

		catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		try {

			conBD = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		/*******************
		 * PREPARACIÛN DE SENTENCIA DE INSERCIÛN
		 ********************************/

		PreparedStatement sentenciaSQL = null;

		try {

			int isbn = Integer.parseInt(request.getParameter("isbn"));

			String titulo = (String) request.getParameter("tit");

			String categoria = (String) request.getParameter("cat");

			sentenciaSQL = conBD.prepareStatement("INSERT INTO libros(isbn,titulo,categoria) VALUES (?,?,?)");

			sentenciaSQL.setInt(1, isbn);

			sentenciaSQL.setString(2, titulo);

			sentenciaSQL.setString(3, categoria);

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		/*******************
		 * EJECUCIÛN DE SENTENCIA DE INSERCIÛN
		 ********************************/

		try {

			sentenciaSQL.execute();

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		/*******************
		 * CONSULTA A LA BASE DE DATOS(QUERY)
		 ********************************/

		ResultSet resultadoQuery = null;
		
		try {
			sentenciaSQL = conBD.prepareStatement("SELECT * FROM libros");
		} 
		
		catch (SQLException e1) {
			
			e1.printStackTrace();
		}

		try {

			resultadoQuery = sentenciaSQL.executeQuery();
		}
		catch (SQLException e) {

			e.printStackTrace();
		}

		response.getWriter().println("<table><tr><th>ISBN</th><th>TÌtulo</th><th>CategorÌa</th></tr>");

		try {

			while (resultadoQuery.next()) {

				int isbn = resultadoQuery.getInt("isbn");
				String titulo = resultadoQuery.getString("titulo");
				String categoria = resultadoQuery.getString("categoria");

				response.getWriter()
						.println("<tr><td>" + isbn + "</td><td>" + titulo + "</td><td>" + categoria + "</td></tr>");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		response.getWriter().println("</table>");

	}
}
