package Ejercicios1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ejercicio7")
public class Ejercicio7 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ejercicio7() {
		super();

	}

	public String generaRadio(Map<String, String> datos) {

		String radios = "";	

		for (String clave : datos.keySet()) {

			radios += datos.get(clave) + "<input type='radio' name='aficion' value='"
					+ clave + "' /><br>";

		}

		return radios;

	}

	public String generaCheckBox(Map<String, String> datos) {

		String checkboxes = "";

		for (String clave : datos.keySet()) {

			checkboxes += datos.get(clave) + "<input type='checkbox' name='aficiones[]' value='"
					+ clave + "'/><br>";

		}

		return checkboxes;

	}

	public String generaSelect(Map<String, String> datos) {

		String select = "<select name='aficiones'>";

		for (String clave  : datos.keySet()) {

			select += "<option value='" + clave + "'> " + datos.get(clave) + "</option>";

		}

		select += "</select>";

		return select;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String,String> datos = new HashMap<String,String>();
		
		datos.put("cantar","Cantar");
		
		datos.put("jugar","Jugar");
		
		datos.put("programar","Programar");
		
		datos.put("nadar","Nadar");
		
		datos.put("bailar","Bailar");

		String html1 = generaRadio(datos);

		String html2 = generaCheckBox(datos);

		String html3 = generaSelect(datos);

		response.setContentType("text/html");

		response.getWriter().println(html1+"<br><br>");

		response.getWriter().println(html2+"<br><br>");

		response.getWriter().println(html3);

		// response.getWriter().println("Descomenta el código");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		doGet(request, response);
	}

}
