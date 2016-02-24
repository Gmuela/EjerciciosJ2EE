package Ejercicios2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Ejercicios2.beans.Libro;
import Ejercicios2.helper.Helper;
import Ejercicios2.model.Libro_model;

@WebServlet({"/Crear" , "/Libro/Crear"})

public class Crear extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Crear() {
		super();

	}
  
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/views/formularioLibros.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String titulo = request.getParameter("tit");
		String categoria = request.getParameter("cat");
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		
		Libro libro = new Libro(titulo,categoria,isbn);
		
		boolean insertado = new Libro_model().insertarLibro(libro);
		
		if (insertado){
			
			response.sendRedirect(Helper.getBaseUrl(request)+"Libro/Listar");
			
		}
	}
}
