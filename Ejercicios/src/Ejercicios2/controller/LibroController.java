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

        ejecutar(request,response);
               
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void ejecutar(HttpServletRequest request, HttpServletResponse response) throws IOException {

        
        
        String[] partes = request.getPathInfo() != null ? request.getPathInfo().split("/") : null;
        
        String accion = (partes != null && partes.length > 0 ? partes[1] : "index");
        
        response.getWriter().print(accion);
        response.getWriter().print(Helper.getBaseUrl(request));
        
        /*if(accion.equalsIgnoreCase("index")){
        
            request.getRequestDispatcher("index.jsp");
            
        }
        
        response.sendRedirect(accion);*/
        
    }

}
