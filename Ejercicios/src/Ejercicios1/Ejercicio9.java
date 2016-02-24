package Ejercicios1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Ejercicio9")

@MultipartConfig(location = "d:\\upload", maxFileSize = 10485760L)

public class Ejercicio9 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ejercicio9() {
		super();

	}

	public String generaInput(Map<String, String> datos, String tipo) {

		String inputs = "";

		for (String clave : datos.keySet()) {

			inputs += datos.get(clave) + " <input type='" + tipo + "' name='" + clave + "' /><br>";

		}

		return inputs;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String> inputArchivo = new HashMap<String, String>();

		Map<String, String> inputNombre = new HashMap<String, String>();

		inputArchivo.put("miArchivo", "");

		inputNombre.put("nombreArchivo", "Nuevo nombre");

		String html1 = generaInput(inputArchivo, "file");

		String html2 = generaInput(inputNombre, "text");

		response.setContentType("text/html");

		response.getWriter().println("<form action='Ejercicio9' method='post' enctype='multipart/form-data'>");

		response.getWriter().println(html1 + "<br>");

		response.getWriter().println(html2 + "<br>");

		response.getWriter().println("<input type='submit' value='Enviar'></form>");

		// response.getWriter().println("Descomenta el código");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombreArchivo = request.getParameter("nombreArchivo");

		Part archivo = request.getPart("miArchivo");

		archivo.write(nombreArchivo);

		response.getWriter().println("Archivo \"" + nombreArchivo + "\" subido con éxito");

	}

}
