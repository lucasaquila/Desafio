angular.module("desafioApp").factory("lancamentoService", ['$http', function($http) {
	
	var _getLancamentos = function(){
		return $http.get('/desafio/lancamento/getLancamentos');
	};
	
	var _efetuarDeposito = function(lancamento){
		return $http.post('/desafio/lancamento/efetuarDeposito', lancamento);
	};
	
	var _efetuarSaque = function(lancamento){
		return $http.post('/desafio/lancamento/efetuarSaque', lancamento);
	};
	
	return {
		getLancamentos: _getLancamentos,
		efetuarDeposito: _efetuarDeposito,
		efetuarSaque: _efetuarSaque
	};
}]);