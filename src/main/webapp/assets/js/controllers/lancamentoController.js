angular.module("desafioApp").controller('lancamentoController', function ($scope, $routeParams,$location,usuarioService, lancamentoService, contaBancariaService, $mdDialog, $mdMedia, $q){
	
/*	console.log($location.path())
	$scope.parametro = null;*/
	
	
	 $scope.selected = [];
	
	 $scope.lancamento = {
		data : new Date(),
	 	tipoLancamento : "ENTRADA"
	 }
	$scope.lancamentos = [];
	
	 
	$scope.buscar = function(){
		console.log($scope.data)
		lancamentoService.getLancamentosData($scope.dataDe, $scope.dataAte).
		success ( function (data)  {
			$scope.lancamentos = data;
		 })

	};
	 
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
			$scope.lancamento.tipoLancamento = "ENTRADA"
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
			$scope.lancamento.tipoLancamento = "SAIDA"
			lancamentoService.efetuarSaque($scope.lancamento).
			success(function(data, status, headers, config){

				console.log("Depósito realizado com sucesso")
				$location.path("/lancamento");
			})
			.error(function(data, status, headers, config, errorMessage) {
				console.log(errorMessage);
			})
	};
	
/*	$scope.transferencia = function ( model )
	{
		var entrada = {};
		var saida = {};
		lancamentoService.efetuarTransferencia ( entrada, saida )
	}*/
	
	
	
});