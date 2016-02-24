package Ejercicios1;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ejercicio8")
public class Ejercicio8 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ejercicio8() {
		super();

	}

	public String generaInput(Map<String, String> datos) {

		String inputs = "";

		for (String clave : datos.keySet()) {

			inputs += datos.get(clave) + "<input type='text' name='" + clave + "' /><br>";

		}

		return inputs;

	}

	public String generaSelect(Map<String, String> datos) {

		String select = "País <select name='pais'>";

		for (String clave : datos.keySet()) {

			select += "<option value='" + clave + "'> " + datos.get(clave) + "</option>";

		}

		select += "</select>";

		return select;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String> inputs = new LinkedHashMap<String, String>();

		Map<String, String> paises = new HashMap<String, String>();

		inputs.put("nombre", "Nombre");

		inputs.put("clave", "Clave");

		paises.put("espania", "España");

		paises.put("francia", "Francia");

		paises.put("italia", "Italia");

		paises.put("portugal", "Portugal");

		String html1 = generaInput(inputs);

		String html2 = generaSelect(paises);

		response.setContentType("text/html");

		response.getWriter().println("<form action='Ejercicio8' method='post'>");

		response.getWriter().println(html1 + "<br>");

		response.getWriter().println(html2 + "<br>");

		response.getWriter().println("<input type='submit' value='Enviar'></form>");

		// response.getWriter().println("Descomenta el código");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");

		String clave = request.getParameter("clave");

		String pais = request.getParameter("pais");

		if (clave.length() < 6 || clave.length() > 12 || nombre == "") {

			response.getWriter().println("<h1> Datos Erróneos</h1><br>");

			doGet(request, response);

		}

		else {

			response.getWriter().println("Hola " + nombre + ", tu clave es "+clave+" y tu país "+pais);

		}
	}

}
