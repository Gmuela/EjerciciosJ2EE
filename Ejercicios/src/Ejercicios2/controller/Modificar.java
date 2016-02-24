package Ejercicios2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Ejercicios2.beans.Libro;
import Ejercicios2.model.Libro_model;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Modificar")
public class Modificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Modificar() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		Libro libro = new Libro_model().getLibro(id);
		
		request.setAttribute("libro", libro);
		
		request.getRequestDispatcher("views/modificarLibro.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titulo = request.getParameter("tit");
		
		String categoria = request.getParameter("cat");
		
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		
		Long id = Long.parseLong(request.getParameter("id"));	
		
		new Libro_model().modificarLibro(titulo, categoria, isbn, id);
                
                List<Libro> listaLibros = new ArrayList<Libro>();
		
		listaLibros = new Libro_model().listarLibros();			
		
		request.setAttribute("listaLibros", listaLibros);
                
                request.getRequestDispatcher("views/listadoLibros.jsp").forward(request, response);
		
	}

}
