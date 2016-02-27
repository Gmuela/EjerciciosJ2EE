package Ejercicios2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Ejercicios2.model.Libro_model;

@WebServlet({"/Borrar" , "/Libro/Borrar"})
public class Borrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Borrar() {
        super();
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		new Libro_model().borrarLibro(id);

		LibroController.ejecutar("Listar",request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
