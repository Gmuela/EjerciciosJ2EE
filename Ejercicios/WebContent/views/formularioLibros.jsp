<%@include file="/views/_templates/cabecera.jsp" %>
<body>
    <form action='Crear' method='post'>
        <h1>Crear Libro</h1>
        ISBN <input type='text' name='isbn'/> 
        Título <input type='text' name='tit'/> 
        Categoría <input type='text' name='cat'/>
        <input type='submit' value='Crear' class="button"/>
    </form>

</body>