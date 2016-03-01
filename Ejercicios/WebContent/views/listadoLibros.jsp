<%@include file="/views/_templates/cabecera.jsp" %>
<body>    
    <table>
        <tr>
            <th>Título</th>
            <th>Categoría</th>
            <th>ISBN</th>
            <th>Modificar</th>
            <th>Borrar</th>
        </tr>
        <jstl:forEach var="libro" items="${listaLibros}">
            <tr>
                <td>${libro.titulo}</td>
                <td>${libro.categoria}</td>
                <td>${libro.isbn}</td>
                <td><a href="${baseUrl}Modificar?id=${libro.id}" class="mod"><img class="imgMod" src="/img/edit.png"></a></td>
                <td><a href="${baseUrl}Borrar?id=${libro.id}" class="bor"><img class="imgBor" src="/img/delete.png"></a></td>

            </tr>
        </jstl:forEach>
    </table>

</body>
</html>