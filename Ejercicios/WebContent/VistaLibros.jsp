<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jstl/core_rt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
table, tr, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 3px;
}
</style>

</head>
<body>
	<table>
		<tr>
			<th>Título</th>
			<th>Categoría</th>
			<th>ISBN</th>
		</tr>

		<h1>
	
		</h1>
		
		<jstl:forEach var="libro" items="${listaLibros}">
			<tr>
				<td>${libro.titulo}</td>
				<td>${libro.categoria}</td>
			</tr>
		</jstl:forEach>
	</table>
</body>
</html>