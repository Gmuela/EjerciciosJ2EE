package Ejercicios1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

	LibroEj15 libro;

	Connection conBD = null;

	PreparedStatement sentenciaSQL = null;

	ResultSet resultadoQuery = null;

	public LibroDAO() {
	
	}
	public LibroDAO(LibroEj15 libro) {

		this.libro = libro;
	}

	public void conectarBD() {

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

	}

	public void prepararBD() {

		try {

			sentenciaSQL = conBD.prepareStatement("INSERT INTO libros(isbn,titulo,categoria) VALUES (?,?,?)");

			sentenciaSQL.setInt(1, libro.getISBN());

			sentenciaSQL.setString(2, libro.getTitulo());

			sentenciaSQL.setString(3, libro.getCategoria());

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void ejecutarBD() {

		try {

			sentenciaSQL.execute();

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public List<LibroEj15> consultaBD() {
		
		conectarBD();

		List<LibroEj15> libros = new ArrayList<LibroEj15>();

		try {
			sentenciaSQL = conBD.prepareStatement("SELECT isbn,titulo,categoria FROM libro");
		}

		catch (SQLException e1) {

			e1.printStackTrace();
		}

		try {

			resultadoQuery = sentenciaSQL.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {

			while (resultadoQuery.next()) {

				int isbn = resultadoQuery.getInt("isbn");

				String titulo = resultadoQuery.getString("titulo");

				String categoria = resultadoQuery.getString("categoria");

				LibroEj15 libro = new LibroEj15(isbn, titulo, categoria);

				libros.add(libro);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		System.out.println(libros);
		return libros;

	}

}
