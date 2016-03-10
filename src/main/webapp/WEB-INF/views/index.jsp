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
	 <md-button md-no-ink class="md-primary">Logout</md-button>
      </div>
    </md-toolbar>
    <md-tabs>
    	<md-tab label="Usuários" ng-click="func()">
    	</md-tab>
    	<md-tab label="Contas Bancárias"></md-tab>
    	<md-tab label="Movimentações"></md-tab>
    </md-tabs>
  
    <md-content layout="column">
  	<h2>Bem-vindo</h2>   
    </md-content>

		
  </div>
</div>

	
	<script src="webjars/angularjs/1.5.0/angular.min.js"></script>
	<script src="webjars/angular-animate/1.5.0/angular-animate.min.js"></script>
	<script src="webjars/angular-aria/1.5.0/angular-aria.min.js"></script>
	<script src="webjars/angular-messages/1.5.0/angular-messages.min.js"></script>
	<script src="webjars/angular-material/1.0.6/angular-material.min.js"></script>
	<script src="http://rawgit.com/daniel-nagy/md-data-table/master/dist/md-data-table.js"></script>
	<script src="assets/js/index.js"></script>
	
</body>
</html>