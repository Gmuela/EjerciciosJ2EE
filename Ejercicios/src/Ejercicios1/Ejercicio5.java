package Ejercicios1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Ejercicio5")

public class Ejercicio5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ejercicio5() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String authType = request.getAuthType();
		int contentLength = request.getContentLength();
		String contentType = request.getContentType();
		String documentRoot = request.getServletContext().getRealPath("/");
		String pathInfo = request.getPathInfo();
		String pathTrans = request.getPathTranslated();
		String queryString = request.getQueryString();
		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		String remoteUser = request.getRemoteUser();
		String method = request.getMethod();
		String scriptName = request.getServletPath();
		String servername = request.getServerName();
		int serverPort = request.getServerPort();
		String serverProtocol = request.getProtocol();
		String serverSoft = request.getServletContext().getServerInfo();
		
		
		String prueba = "prueba";

		response.getWriter().print("<table border='1'>" + "<tr><th>Variable</th><th>Valor</th></tr>" 
						+ "<tr><td>Auth_Type</td><td>" + authType + "</td></tr>" 
						+ "<tr><td>Content_Length</td><td>" + contentLength + "</td></tr>"
						+ "<tr><td>Content_Type</td><td>" + contentType + "</td></tr>"
						+ "<tr><td>Document_Root</td><td>" + documentRoot + "</td></tr>"
						+ "<tr><td>Path_Info</td><td>" + pathInfo + "</td></tr>"
						+ "<tr><td>Path_Translated</td><td>" + pathTrans + "</td></tr>"
						+ "<tr><td>Query_String</td><td>" + queryString + "</td></tr>"
						+ "<tr><td>Remote_Addr</td><td>" + remoteAddr + "</td></tr>"
						+ "<tr><td>Remote_Host</td><td>" + remoteHost + "</td></tr>"
						+ "<tr><td>Remote_User</td><td>" + remoteUser + "</td></tr>"
						+ "<tr><td>Remote_Method</td><td>" + method + "</td></tr>"
						+ "<tr><td>Script_Name</td><td>" + scriptName + "</td></tr>"
						+ "<tr><td>Server_Name</td><td>" + servername + "</td></tr>"
						+ "<tr><td>Server_Port</td><td>" + serverPort + "</td></tr>"
						+ "<tr><td>Server_Protocol</td><td>" + serverProtocol + "</td></tr>"
						+ "<tr><td>Server_Software</td><td>" + serverSoft + "</td></tr>"
						+ "<tr><td><b>pruebas</b></td><td>" + prueba + "</td></tr>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().println("<h1>Esto es el doPost</h1>");

	}

}
