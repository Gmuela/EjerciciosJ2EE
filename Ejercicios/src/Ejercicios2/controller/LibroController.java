package Ejercicios2.controller;

import Ejercicios2.helper.Helper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Libro/*")
public class LibroController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {               
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected static void ejecutar(String accion, HttpServletRequest request, HttpServletResponse response) throws IOException {       
               
        response.sendRedirect(Helper.getBaseUrl(request)+accion);
        
    }

}
