<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title>Items list</title>
<g:javascript library="jquery" plugin="jquery" />
</head>
<body>
	<h3>my items list</h3>

	<!-- TODO: check a better location for the template -->
	<g:render template="login" />
	</p>

	<hr>
	<g:each in="${items}" var="i">
    	Item: <%= "${i.name}" %> <br>
    	description:  <%= "${i.description}" %> <br>
    	amount:  <%= "${i.amount}" %> <br>
    	price:  <%= "${i.price}" %> <br>
        
		<g:each in="${i.images}" var="im">
	   		  <img src="<%= "${im}" %>" witdh="60" height="60"/>
		</g:each>
        
		<a href="<g:createLink action='publish' params='[id: "${i.idd}" ]'/>">publish!</a>  
		<hr>
	</g:each>
	
	 
</body>
</html>