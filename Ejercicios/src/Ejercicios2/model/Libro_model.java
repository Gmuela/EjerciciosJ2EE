package Ejercicios2.model;


import java.util.List;

import Ejercicios2.beans.Libro;

public class Libro_model extends Hibernate_model {	
	
	public Libro_model(){
		super();
	}
	
	
	public boolean insertarLibro(Libro libro){
		
		session.save(libro);	
		transaction.commit();		
		return true;
		
	}
	
	public Libro getLibro(Long id){
		
		return session.load(Libro.class, id);
		
	}
	
	public List<Libro> listarLibros(){
		
		@SuppressWarnings("unchecked")
		List<Libro> listaLibros = session.createQuery("FROM Libro").list();
		
		return listaLibros;
	}
	
	public boolean borrarLibro(Long id){
		
		Libro libro = (Libro)session.load(Libro.class, id);
		
		session.delete(libro);
		
		transaction.commit();
		
		return true;
		
	}
	
	public boolean modificarLibro(String titulo, String categoria, int isbn, Long id){
		
		Libro lib = session.load(Libro.class, id);
		
		lib.setTitulo(titulo);
		
		lib.setCategoria(categoria);
		
		lib.setIsbn(isbn);
		
		session.merge(lib);
		
		transaction.commit();
		
		return true;
		
	}
	
	
	

}
