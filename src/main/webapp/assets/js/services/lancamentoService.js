angular.module("desafioApp").factory("lancamentoService", ['$http', function($http) {
	
	var _getLancamentos = function(){
		return $http.get('/desafio/lancamento/getLancamentos');
	};
	return {
		getLancamentos: _getLancamentos
	};
}]);