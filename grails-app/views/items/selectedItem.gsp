<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title>Items list</title>
<g:javascript library="jquery" plugin="jquery" />
</head>
<body>
    <script type="text/javascript">

    	function setLevel(value) {
        	document.getElementById("level").value = value;
        }

    </script>	

		<h2>Elegi la categoria para publicar el item</h2>
		
		<g:each in="${item.images}" var="im"> 
	   		  <img src="<%= "${im}" %>" witdh="60" height="60"/>
		</g:each> <br>
		
    	Item: <%= "${item.name}" %> <br>
    	description:  <%= "${item.description}" %> <br>
    	amount:  <%= "${item.amount}" %> <br>
    	price:  <%= "${item.price}" %> <br>
    	category: <%= "${categoryDescriptionSelected}" %> <br><br>

		
			<g:form url="[controller:'items', action:'getChildrenCategory']" >
		
			    <g:select name="idCategory" from="${levels[0]}" size="10" optionKey="id" optionValue="name" onchange="setLevel(0);this.form.submit()" />
				<g:select name="idCategory" from="${levels[1]}" size="10" optionKey="id" optionValue="name" onchange="setLevel(1);this.form.submit()" />
				<g:select name="idCategory" from="${levels[2]}" size="10" optionKey="id" optionValue="name" onchange="setLevel(2);this.form.submit()" />
				<g:select name="idCategory" from="${levels[3]}" size="10" optionKey="id" optionValue="name" onchange="setLevel(3);this.form.submit()" />
				<g:select name="idCategory" from="${levels[4]}" size="10" optionKey="id" optionValue="name" onchange="setLevel(4);this.form.submit()" />
				<g:select name="idCategory" from="${levels[5]}" size="10" optionKey="id" optionValue="name" onchange="setLevel(5);this.form.submit()" />
				<g:select name="idCategory" from="${levels[6]}" size="10" optionKey="id" optionValue="name" onchange="setLevel(6);this.form.submit()" />
				
				<g:hiddenField name="level" value="-1" /> <br> <br>
				<g:hiddenField name="idCategorySelected" value="${categoryIdSelected}" /> <br>
			
				<!-- <g:submitButton name="publish" value="Publicar Item" /> <br> <br> -->
			
			   <!-- Hago el submit del form omitiendo el action del formulario establecido -->
				<g:actionSubmit action="publish" value="Publicar Item" />
			
		</g:form>
	 
</body>
</html>		
