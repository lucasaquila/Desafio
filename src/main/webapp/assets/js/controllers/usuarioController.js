angular.module("desafioApp").controller('usuarioController', ['$mdEditDialog', '$q', '$scope', '$timeout', '$http', 'usuarioService','$location', '$routeParams',  function ($mdEditDialog, $q, $scope, $timeout, $http, usuarioService, $location, $routeParams) {
  'use strict';
  
  $scope.usuarios = [];
  $scope.usuario = {
		  nome : "",
		  tipoUsuario : "ROLE_USUARIO",
		  situacao: true
		  	  
  };
  
	if($routeParams.id != null){
		usuarioService.getUsuario($routeParams.id).
			success(function(usuario){
				$scope.usuario = usuario;
			});
	}  
  
  $scope.excluirUsuario = function(id){
	  console.log("id: " + id)
	  usuarioService.excluirUsuario(id)
	  .success(function(){
		  console.log("Excluido com sucesso...")
		  usuarioService.getUsuarios().
		  success ( function ( data )  {
			  $scope.usuarios = data;
				  console.log("listou!")
		  })
		  
	  })
	  .error(function() {
			console.log("erro ao excluir usuário!");
	  })
  };
  
  $scope.alterarSituacao = function(selecionado){
	  console.log("ID: " + selecionado.id + "Situação:" + selecionado.situacao);
	  usuarioService.alterarSituacao(selecionado.id, selecionado).
	  	success ( function ()  {
	  		console.log("alterado com sucesso")
	  })
	  .error(function(data,status,headers,config) {
			console.log("erro ao alterar");
	  })
  };
  
  $scope.listUsers = function () {
	  usuarioService.getUsuarios().
	  	success ( function ( data )  {
		  $scope.usuarios = data;
		  console.log("listou!")
	  })
  };
  
  $scope.adicionarUsuario = function(usuario) {
	  	console.log($scope.usuario);
		usuarioService.saveUsuario($scope.usuario).
		success(function(){
			console.log("cadastrado com sucesso")
			$location.path("/usuario");
		})
		.error(function(data,status,headers,config) {
			console.log("erro");
		})
  	};
  	
  	
  	
	$scope.editarUsuario  = function(){
		usuarioService.editarUsuario($scope.usuario.id, $scope.usuario).
		success(function(){
			console.log("Editado com sucesso")
			delete $scope.usuario;
			$location.path("/usuario");
		})
		.error(function() {
			console.log("erro");
		})
	};
 
  $scope.selected = [];
  

  
  

  

}]);


