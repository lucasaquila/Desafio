<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br" ng-app="demoApp">
<head>
	<link rel="stylesheet" href="../webjars/angular-material/1.0.6/angular-material.css">
	<!-- <link rel="stylesheet" href="webjars/angular-material-icons/0.6.0/angular-material-icons.css"> -->
	 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	 <link rel="stylesheet" href="http://rawgit.com/daniel-nagy/md-data-table/master/dist/md-data-table.css">
</head>
<body>
<div>
  <div class="md-red"  layout="column">
    <md-toolbar>
      <div class="md-toolbar-tools">
        <h2>
        <img src="<c:url value="/assets/img/logo.png" />" alt="logo"/>
        </h2>
        <span flex></span>
	 <md-button md-no-ink class="md-primary"><strong>LOGOUT</strong></md-button>
      </div>
    </md-toolbar>
    <md-tabs style="background-color:#EAEAEA">
    	<md-tab label="Usuários"></md-tab>
    	<md-tab label="Contas Bancárias"></md-tab>
    	<md-tab label="Movimentações"></md-tab>
    </md-tabs>
  
    <md-content  layout-gt-sm="column" ng-controller="usuarioController">
    	
		<div layout="row">
			  <div flex="20">
			  </div>
			  <div flex=60>
		  <h2>Cadastro de Usuários</h2>
		  <p>Tipo de Usuário</p>
    	   <md-radio-group ng-model="usuario.tipoUsuario" ng-model="ROLE_USUARIO">
		      <md-radio-button value="ROLE_USUARIO" aria-checked="true" class="md-checked">Usuário</md-radio-button>
		      <md-radio-button value="ROLE_ADMINISTRADOR">Administrador</md-radio-button>
           </md-radio-group>
		   </md-input-container>		  
          <md-input-container class="md-block" flex-gt-sm>
	      	<label>Nome</label>
	      		<input ng-model="usuario.nome">
	      </md-input-container>
          <md-input-container class="md-block" flex-gt-sm>
          	<label>E-mail</label>
            	<input ng-model="usuario.email">
          </md-input-container>
          <md-input-container class="md-block" flex-gt-sm>
          	<label>Senha</label>
            	<input ng-model="usuario.password" type="password">
          </md-input-container>
          <div layout="row">
          
          <md-button class="md-raised">Voltar</md-button>
          <div flex></div>
          <md-button class="md-raised md-primary" ng-click="adicionarUsuario(usuario)">Salvar</md-button>
		  </div>
			  <div flex>
			  </div>
		</div>




        </div>
	</md-content>
	
		
  </div>
</div>
	<script src="../webjars/angularjs/1.5.0/angular.min.js"></script>
	<script src="../webjars/angular-animate/1.5.0/angular-animate.min.js"></script>
	<script src="../webjars/angular-aria/1.5.0/angular-aria.min.js"></script>
	<script src="../webjars/angular-messages/1.5.0/angular-messages.min.js"></script>
	<script src="../webjars/angular-material/1.0.6/angular-material.min.js"></script>
	<script src="http://rawgit.com/daniel-nagy/md-data-table/master/dist/md-data-table.js"></script>
	<script src="../assets/js/index.js"></script>
	
</body>
</html>














<%-- 

<%@page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" context="text/html" charset="UTF-8">
<title>Cadastro de produtos</title>
</head>
<body>
   	<c:url var="save" value="/usuario/save" />
	<form:form modelAttribute="usuario" action="${save}" method="post" commandName="usuario">   
	<form:form action="${spring:mvcUrl('salvarUsuario').build()}" method="post" commandName="usuario">
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
</html> --%>