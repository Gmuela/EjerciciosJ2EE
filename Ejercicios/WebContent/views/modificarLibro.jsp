<%@include file="/views/_templates/cabecera.jsp" %>
<body>
	<form action='Modificar' method='post'>
            <h1>Modificar Libro</h1>                
		ISBN <input type='text' name='isbn' value="${libro.isbn}"/> 
		T�tulo <input type='text' name='tit' value="${libro.titulo}"/> 
		Categor�a <input type='text' name='cat' value="${libro.categoria}"/>
		<input type="hidden" name="id" value="${libro.id}"/>
		<input type='submit' value='Modificar' />
	</form>
	
</body>
