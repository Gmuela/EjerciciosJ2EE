<%@include file="/views/_templates/cabecera.jsp" %>
<body>    
	<table>
		<tr>
			<th>Título</th>
			<th>Categoría</th>
			<th>ISBN</th>
                        <th colspan="2">Operaciones</th>
		</tr>
		<jstl:forEach var="libro" items="${listaLibros}">
			<tr>
				<td>${libro.titulo}</td>
				<td>${libro.categoria}</td>
				<td>${libro.isbn}</td>
                                <td><a href="Modificar?id=${libro.id}" class="mod">Modificar</a></td>
                                <td><a href="Borrar?id=${libro.id}" class="bor">Borrar</a></td>
                                
			</tr>
		</jstl:forEach>
	</table>
	
</body>
</html>