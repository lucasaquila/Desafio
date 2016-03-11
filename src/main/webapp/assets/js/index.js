
angular.module('demoApp', ['ngMaterial','md.data.table'])
    .config(function($mdThemingProvider) {
        $mdThemingProvider
            .theme('default')
            .primaryPalette('blue')
            .accentPalette('blue');
    })
    
.controller('usuarioController', ['$mdEditDialog', '$q', '$scope', '$timeout', '$http', function ($mdEditDialog, $q, $scope, $timeout, $http) {
  'use strict';
  
  $scope.usuarios = [];
  
  
  
  $scope.listUsers = function () {
	  $http.get('/desafio/usuario/listagem').
	  	success ( function ( data )  {
		  $scope.usuarios = data;
		  console.log("listou!")
	  })
  };
  
	$scope.adicionarUsuario = function(usuario) {
		$http.post('/desafio/usuario/save', usuario).
		success(function(){
			console.log("cadastrado com sucesso")
		})
  	};
 
  
  $scope.selected = [];
  
  $scope.options = {
    autoSelect: false,
    boundaryLinks: false,
    largeEditDialog: false,
    pageSelector: false,
    rowSelection: false
  };
  
  $scope.query = {
    order: 'name',
    limit: 5,
    page: 1
  };
  
  
  $scope.editComment = function (event, dessert) {
    event.stopPropagation(); // in case autoselect is enabled
    
    var editDialog = {
      modelValue: dessert.comment,
      placeholder: 'Add a comment',
      save: function (input) {
        if(input.$modelValue === 'Donald Trump') {
          return $q.reject();
        }
        if(input.$modelValue === 'Bernie Sanders') {
          return dessert.comment = 'FEEL THE BERN!'
        }
        dessert.comment = input.$modelValue;
      },
      targetEvent: event,
      title: 'Add a comment',
      validators: {
        'md-maxlength': 30
      }
    };
    
    var promise;
    
    if($scope.options.largeEditDialog) {
      promise = $mdEditDialog.large(editDialog);
    } else {
      promise = $mdEditDialog.small(editDialog);
    }
    
    promise.then(function (ctrl) {
      var input = ctrl.getInput();
      
      input.$viewChangeListeners.push(function () {
        input.$setValidity('test', input.$modelValue !== 'test');
      });
    });
  };
  
  $scope.getTypes = function () {
    return ['Candy', 'Ice cream', 'Other', 'Pastry'];
  };
  
  $scope.loadStuff = function () {
    $scope.promise = $timeout(function () {
      // loading
    }, 2000);
  }
  
  $scope.logItem = function (item) {
    console.log(item.name, 'was selected');
  };
  
  $scope.logOrder = function (order) {
    console.log('order: ', order);
  };
  
  $scope.logPagination = function (page, limit) {
    console.log('page: ', page);
    console.log('limit: ', limit);
  }
}]);


