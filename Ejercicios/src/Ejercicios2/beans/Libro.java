package Ejercicios2.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Libro {

	private String titulo;
	private String categoria;
	private int isbn;
	private Long id;
	
	public Libro(){}

	public Libro(String titulo, String categoria, int isbn) {
		super();
		this.titulo = titulo;
		this.categoria = categoria;
		this.isbn = isbn;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getIsbn() {
		return isbn;
	}
	
	
	
	
}
