<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br" ng-app="demoApp">
<head>
	<link rel="stylesheet" href="webjars/angular-material/1.0.6/angular-material.css">
	<!-- <link rel="stylesheet" href="webjars/angular-material-icons/0.6.0/angular-material-icons.css"> -->
	 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	 <link rel="stylesheet" href="http://rawgit.com/daniel-nagy/md-data-table/master/dist/md-data-table.css">
</head>
<body>

<div>
  <div class="md-red" layout="column" layout-fill>
    <md-toolbar>
      <div class="md-toolbar-tools">
        <h2>
        <img src="<c:url value="/assets/img/logo.png" />" alt="logo"/>
          <!-- <span>Desafio Eits</span> -->
        </h2>
        <span flex></span>
        <md-button class="md-icon-button" aria-label="Favorite">
          <!-- <md-icon md-svg-icon="webjars/angular-material-icons/img/icons/favorite.svg" style="color: greenyellow;"></md-icon> -->
        </md-button>
        <md-button class="md-icon-button" aria-label="More">
          <!-- <md-icon md-svg-icon="webjars/angular-material-icons/img/icons/more_vert.svg"></md-icon> -->
        </md-button>
	 <md-button md-no-ink class="md-primary"><strong>LOGOUT</strong></md-button>
      </div>
    </md-toolbar>
    <md-tabs style="background-color:#EAEAEA">
    	<md-tab label="Usuários" href="usuario"></md-tab>
    	<md-tab label="Contas Bancárias"></md-tab>
    	<md-tab label="Movimentações"></md-tab>
    </md-tabs>
  
    <md-content layout="column" flex ng-controller="usuarioController" ng-init="listUsers()">
      
        <div layout="row">
		    <div flex="40">
    	        <md-input-container class="md-block">
        	    <label>Insira o Nome ou E-mail</label>
            	<input ng-model="user.firstName">
          		</md-input-container>
	    	</div>
    		<div flex="50">
    			<md-button class="md-raised md-primary">Pesquisar</md-button>
    		</div>
    		<div flex>
    			<md-button class="md-raised md-primary" flex layout-align="end end" md-ink-ripp="green">Novo</md-button>
    		</div>

  		</div>
      

      <md-card>
        
        <md-toolbar class="md-table-toolbar md-default" ng-hide="options.rowSelection && selected.length">
          <div class="md-toolbar-tools">
            <span>Lista de Usuários</span>
            <div flex></div>
            <md-button ng-click="loadStuff()">Atualizar</md-button>
          </div>
        </md-toolbar>
        
        <md-table-container>
          <table md-table md-row-select="options.rowSelection" ng-model="selected" md-progress="promise">
            <thead md-head md-order="query.order" md-on-reorder="logOrder">
              <tr md-row>
                <th md-column md-order-by="nome"><span>Nome</span></th>
                <th md-column md-order-by="email"><span>E-mail</span></th>
                <th md-column md-order-by="tipo"><span>Tipo</span></th>
                <th md-column md-order-by="situacao"><span>Situação</span></th>
              </tr>
            </thead>
            <tbody md-body>
              <tr md-row md-select="usuario" md-on-select="logItem" md-auto-select="options.autoSelect" ng-repeat="usuario in usuarios | filter: filter.search | orderBy: query.order | limitTo: query.limit : (query.page -1) * query.limit">
                <td md-cell>{{usuario.nome}}</td>
                <td md-cell>{{usuario.email}}</td>
                <td md-cell>{{usuario.tipo == "ROLE_USUARIO" ? "Usuário" : "Administrador" }}</td>
                <td md-cell>
                    <md-switch ng-model="usuario.situacao" aria-label="Switch 2" class="md-primary">
    				{{ usuario.situacao == true ? "Ativado" : "Desativado" }} 
    				</md-switch>
                </td>
              </tr>
            </tbody>
          </table>
        </md-table-container>

        <md-table-pagination md-limit="query.limit" md-page="query.page" md-total="{{desserts.count}}" md-page-select="options.pageSelector" md-boundary-links="options.boundaryLinks" md-on-paginate="logPagination"></md-table-pagination>
      </md-card>
    </md-content>
	
		
  </div>
</div>


<!-- 	<h2>Todo</h2>
	<div ng-controller="TodoListController as todoList">
		<span>{{todoList.remaining()}} of {{todoList.todos.length}}
			remaining</span> [ <a href="" ng-click="todoList.archive()">archive</a> ]
		<ul class="unstyled">
			<li ng-repeat="todo in todoList.todos"><label class="checkbox">
					<input type="checkbox" ng-model="todo.done"> <span
					class="done-{{todo.done}}">{{todo.text}}</span>
			</label></li>
		</ul>
		<form ng-submit="todoList.addTodo()">
			<input type="text" ng-model="todoList.todoText" size="30"
				placeholder="add new todo here"> <input class="btn-primary"
				type="submit" value="add">
		</form>
	</div> -->
	
	<script src="webjars/angularjs/1.5.0/angular.min.js"></script>
	<script src="webjars/angular-animate/1.5.0/angular-animate.min.js"></script>
	<script src="webjars/angular-aria/1.5.0/angular-aria.min.js"></script>
	<script src="webjars/angular-messages/1.5.0/angular-messages.min.js"></script>
	<script src="webjars/angular-material/1.0.6/angular-material.min.js"></script>
	<script src="http://rawgit.com/daniel-nagy/md-data-table/master/dist/md-data-table.js"></script>
	<script src="assets/js/index.js"></script>
	
</body>
</html>


<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
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

</html> --%>