<%@page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" context="text/html" charset="UTF-8">
<title>Cadastro de produtos</title>
</head>
<body>
 	<c:url var="save" value="/usuario/save" />
	<form:form modelAttribute="usuario" action="${save}" method="post">
		<form:hidden path="id"/>
		<div>
		<label for="tipoUsuario">Tipo de Usuário</label>
 		<form:select path="tipoUsuario">
		    <form:options items="${tipos}" />
		</form:select>
		<div>
		</div>
			<label for="nome">Nome</label> 
			<form:input path="nome"/>
			<form:errors path="nome" />
		</div>
		<div>
			<label for="email">E-mail</label> 
			<form:input path="email"/>
			<form:errors path="email" />
		</div>
		<div>
			<label for="password">Senha</label> 
			<form:password path="password"/>
			<form:errors path="password" />
		</div>
		<div>
			<input type="submit" value="Enviar">
		</div>
	</form:form> 
</body>
</html>