<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<form action='Modificar' method='post'>
		ISBN <input type='text' name='isbn' value="${libro.isbn}"/> 
		Título <input type='text' name='tit' value="${libro.titulo}"/> 
		Categoría <input type='text' name='cat' value="${libro.categoria}"/>
		<input type="hidden" name="id" value="${libro.id}"/>
		<input type='submit' value='Enviar' />
	</form>
	<a href="Listar">Lista de Libros</a>
</body>
</html>