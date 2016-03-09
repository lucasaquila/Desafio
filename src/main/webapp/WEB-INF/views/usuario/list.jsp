<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Listar Usuários</title>
</head>
<body>
 	<div>
		${sucesso}
	</div>
	<table>
		<tr>
			<td>Nome</td>
			<td>E-mail</td>
		</tr>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>${usuario.nome}</td>
				<td>${usuario.email}</td>
			</tr>
		</c:forEach>
	</table> 

</body>

</html>