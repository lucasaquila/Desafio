angular.module("desafioApp").factory("contaBancariaService", ['$http', function($http) {
	
	var _getContasBancarias = function(){
		return $http.get('/desafio/contaBancaria/getContasBancarias');
	};
	
	var _getContaBancaria = function(id){
		return $http.get('/desafio/contaBancaria/' + id);
	};
	
	var _getBancos = function(){
		return $http.get('/desafio/contaBancaria/getBancos');
	};
	
	var _saveContaBancaria = function(contaBancaria){
		return $http.post('/desafio/contaBancaria/save', contaBancaria);
	};
	
	return {
		getContasBancarias: _getContasBancarias,
		getContaBancaria: _getContaBancaria,
		getBancos: _getBancos,
		saveContaBancaria: _saveContaBancaria,
	};
}]);