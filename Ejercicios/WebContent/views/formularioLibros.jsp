<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<form action='Crear' method='post'>
		ISBN <input type='text' name='isbn'/> 
		T�tulo <input type='text' name='tit'/> 
		Categor�a <input type='text' name='cat'/>
		<input type='submit' value='Enviar' />
	</form>
	<a href="Listar">Lista de Libros</a>
</body>
</html>