angular.module("desafioApp").controller('contaBancariaController', function ($scope, $routeParams,$location, contaBancariaService, usuarioService){
	
/*	console.log($location.path())
	$scope.parametro = null;*/
	
	if($routeParams.id != null){
	contaBancariaService.getContaBancaria($routeParams.id).
		success(function(conta){
			$scope.contaBancaria = conta;
		});
	}
	
	$scope.bancos = [];
	$scope.usuarios = [];
	$scope.contaBancaria = {
			banco : "CAIXA",
			saldo : "0.00"
	};
	
	$scope.listaBancos = function(){
		contaBancariaService.getBancos().
		success(function(data){
			$scope.bancos = data;
	})
		
	}
	
	var listaUsuarios = function(){
		usuarioService.getUsuarios().
		success(function(data){
			$scope.usuarios = data;
	})
		
	}
	
	listaUsuarios();
	/*buscaBancos();*/
	
	$scope.contasBancarias = [];
	
	$scope.listContasBancarias = function () {
		contaBancariaService.getContasBancarias().
		success ( function ( data )  {
			$scope.contasBancarias = data;
			console.log("listou!")
		 })
	};
	
/*	  $scope.adicionarContaBancaria = function(conta) {
		  	console.log($scope.contaBancaria);
	  }*/
	  
	  $scope.adicionarContaBancaria = function() {
		  	console.log($scope.contaBancaria);
			contaBancariaService.saveContaBancaria($scope.contaBancaria).
			success(function(){
				console.log("Conta Bancária salva com sucesso")
				$location.path("/contaBancaria");
			})
			.error(function(data,status,headers,config) {
				console.log("erro");
			})
	  	};
	  
	
});