angular.module('desafioApp').config(function($routeProvider) {
	
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
/*		resolve: {
			bancos: function(contaBancariaService){
				return contaBancariaService.getBancos();
			}
		}*/
	});
	
	$routeProvider.when("/contaBancaria/saldoInicial/:id", {
		templateUrl: "contaBancaria/form",
		controller: "contaBancariaController",
	});
	
	/*$routeProvider.otherwise({redirectTo: "/usuario"})*/
});