angular.module('desafioApp').config(function($routeProvider) {
	
	
	/*USUÁRIOS*/
	$routeProvider.when("/logout", {
		templateUrl: "login",
		controller: "usuarioController"
	});
	
	$routeProvider.when("/login", {
		templateUrl: "login",
		controller: "usuarioController"
	});
	
	/*USUÁRIOS*/
	$routeProvider.when("/usuario", {
		templateUrl: "usuario",
		controller: "usuarioController"
	});
	
	$routeProvider.when("/usuario/form", {
		templateUrl: "usuario/form",
		controller: "usuarioController"
	});
	
	$routeProvider.when("/usuario/editar/:id", {
		templateUrl: "usuario/editar",
		controller: "usuarioDetalhesController",
		resolve: {
			usuario: function(usuarioService, $route){
				return usuarioService.getUsuario($route.current.params.id);
			}
		}
	});
	
	/*CONTAS BANCÁRIAS*/
	$routeProvider.when("/contaBancaria", {
		templateUrl: "contaBancaria",
		controller: "contaBancariaController"
	});
	
	$routeProvider.when("/contaBancaria/form", {
		templateUrl: "contaBancaria/form",
		controller: "contaBancariaController",
	});
	
	$routeProvider.when("/contaBancaria/editar/:id", {
		templateUrl: "contaBancaria/form",
		controller: "contaBancariaController",
	});
	
	$routeProvider.when("/contaBancaria/saldoInicial/:id", {
		templateUrl: "contaBancaria/saldoInicial",
		controller: "contaBancariaController",
	});
	
	$routeProvider.when("/contaBancaria/detalhes/:id", {
		templateUrl: "contaBancaria/detalhes",
		controller: "contaBancariaController",
	});
	
	/*$routeProvider.otherwise({redirectTo: "/usuario"})*/
});