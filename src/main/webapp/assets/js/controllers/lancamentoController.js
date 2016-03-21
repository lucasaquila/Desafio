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
			console.log("listou!")
		 })
	};
	
	
	
	
	$scope.listContasBancarias = function () {
		contaBancariaService.getContasBancarias().
		success ( function ( data )  {
			$scope.contasBancarias = data;
		 })
	};
	
	
	
	
	
});