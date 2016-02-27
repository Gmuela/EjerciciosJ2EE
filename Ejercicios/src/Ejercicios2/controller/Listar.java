package Ejercicios2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Ejercicios2.beans.Libro;
import Ejercicios2.helper.Helper;
import Ejercicios2.model.Libro_model;


@WebServlet({"/Listar"})
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Listar() {
        super();
        
    }	
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Libro> listaLibros = new ArrayList<Libro>();

        listaLibros = new Libro_model().listarLibros();

        request.setAttribute("listaLibros", listaLibros);

        String baseUrl = Helper.getBaseUrl(request);

        request.setAttribute("baseUrl", baseUrl);

        request.getRequestDispatcher("/views/listadoLibros.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

}
