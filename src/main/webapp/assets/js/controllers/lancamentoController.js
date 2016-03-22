angular.module("desafioApp").controller('lancamentoController', function ($scope, $routeParams,$location,usuarioService, lancamentoService, contaBancariaService, $mdDialog, $mdMedia){
	
/*	console.log($location.path())
	$scope.parametro = null;*/
	
	
	 $scope.selected = [];
	
	 $scope.lancamento = {
		data : new Date(),
	 	tipoLancamento : "ENTRADA"
	 }
	$scope.lancamentos = [];
	
	$scope.listLancamentos = function () {
		lancamentoService.getLancamentos().
		success ( function ( data )  {
			$scope.lancamentos = data;
			/*console.log(data);*/
		 })
	};
	
	$scope.listContasBancarias = function () {
		contaBancariaService.getContasBancarias().
		success ( function ( data )  {
			$scope.contasBancariasDestino = data;
		 })
	};
	
	$scope.listContasBancariasByRole = function () {
		contaBancariaService.getContasBancariasByRole().
		success ( function ( data )  {
			$scope.contasBancariasOrigem = data;
		 })
	};

	$scope.depositar = function() {

		  	console.log($scope.lancamento);
			lancamentoService.efetuarDeposito($scope.lancamento).
			success(function(){
				console.log("Depósito realizado com sucesso")
				$location.path("/lancamento");
			})
			.error(function(data,status,headers,config,response) {
				console.log("Error with status code", response);
			})
	};
	

	$scope.sacar = function() {

		  	console.log($scope.lancamento);
			lancamentoService.efetuarSaque($scope.lancamento).
			success(function(){
				console.log("Depósito realizado com sucesso")
				$location.path("/lancamento");
			})
			.error(function(data,status,headers,config,response) {
				console.log("Error with status code", response);
			})
	};
	
	
	
	
	
});