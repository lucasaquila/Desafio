angular.module('desafioApp').config(function($routeProvider) {
	$routeProvider.when("/usuario", {
		templateUrl: "usuario",
		controller: "usuarioController"
	});
	
	$routeProvider.when("/usuario/form", {
		templateUrl: "usuario/form",
		controller: "usuarioController"
	});
	
	$routeProvider.when("/usuario/editar/:id", {
		templateUrl: "usuario/editar ",
		controller: "usuarioDetalhesController",
		resolve: {
			usuario: function(usuarioService, $route){
				return usuarioService.getUsuario($route.current.params.id);
			}
		}
	});
	
	/*$routeProvider.otherwise({redirectTo: "/usuario"})*/
});