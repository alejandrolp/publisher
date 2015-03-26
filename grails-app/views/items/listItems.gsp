<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title>Items list</title>
<g:javascript library="jquery" plugin="jquery" />
</head>
<body>
	<h2>Lista de items a publicar</h2>
	 
	<!-- TODO: check a better location for the template -->
	<g:render template="login" />
	</p>

	<hr>
	<g:each in="${items}" var="i">
	
		<g:each in="${i.images}" var="im"> 
	   		  <img src="<%= "${im}" %>" witdh="60" height="60"/>
		</g:each> <br>
		
    	Item: <%= "${i.name}" %> <br>
    	description:  <%= "${i.description}" %> <br>
    	amount:  <%= "${i.amount}" %> <br>
    	price:  <%= "${i.price}" %> <br><br>
		
		<a href="<g:createLink action='toChoseCategory' params='[id: "${i.idd}" ]'/>">Elegir Categoria</a> <br>
		
		<hr>
	</g:each>
	
	 
</body>
</html>