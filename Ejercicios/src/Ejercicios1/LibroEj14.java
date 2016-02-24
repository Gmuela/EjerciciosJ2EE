package Ejercicios1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibroEj14 {
	
	public LibroEj14(int isbn, String titulo, String categoria){
		
		this.isbn = isbn;
		
		this.titulo = titulo;
		
		this.categoria= categoria;
	}
	
	private int isbn;
	
	private String titulo;
	
	private String categoria;
	
	Connection conBD = null;
	
	PreparedStatement sentenciaSQL = null;
	
	ResultSet resultadoQuery = null;
	
	public void conectarBD(){		

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
	
	public void prepararBD(){
		
		try {

			sentenciaSQL = conBD.prepareStatement("INSERT INTO libros(isbn,titulo,categoria) VALUES (?,?,?)");

			sentenciaSQL.setInt(1, this.isbn);

			sentenciaSQL.setString(2, this.titulo);

			sentenciaSQL.setString(3, this.categoria);

		}

		catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	public void ejecutarBD(){
		
		try {

			sentenciaSQL.execute();

		}

		catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	public String consultaBD(){
		
		String consulta = null;
		
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

		consulta = "<table><tr><th>ISBN</th><th>Título</th><th>Categoría</th></tr>";

		try {

			while (resultadoQuery.next()) {

				int isbn = resultadoQuery.getInt("isbn");
				String titulo = resultadoQuery.getString("titulo");
				String categoria = resultadoQuery.getString("categoria");

				consulta += "<tr><td>" + isbn + "</td><td>" + titulo + "</td><td>" + categoria + "</td></tr>";

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		consulta += "</table>";
		
		return consulta;
		
	}
	
}
