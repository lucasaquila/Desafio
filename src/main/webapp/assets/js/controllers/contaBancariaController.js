angular.module("desafioApp").controller('contaBancariaController', function ($scope, $routeParams,$location, contaBancariaService){
	
	$scope.contasBancarias = [];
	
	$scope.listContasBancarias = function () {
		contaBancariaService.getContasBancarias().
		success ( function ( data )  {
			$scope.contasBancarias = data;
			console.log("listou!")
		 })
	};
	
});