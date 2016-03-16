angular.module("desafioApp").factory("contaBancariaService", ['$http', function($http) {
	
	var _getContasBancarias = function(){
		return $http.get('/desafio/contaBancaria/getContasBancarias');
	};
	

	return {
		getContasBancarias: _getContasBancarias,

	};
}]);