package Ejercicios1;

public class LibroEj15 {

	public LibroEj15(int isbn, String titulo, String categoria) {

		this.isbn = isbn;

		this.titulo = titulo;

		this.categoria = categoria;

	}

	private int isbn;

	private String titulo;

	private String categoria;

	public int getISBN() {

		return this.isbn;

	}

	public String getTitulo() {

		return this.titulo;

	}

	public String getCategoria() {

		return this.categoria;

	}
}
