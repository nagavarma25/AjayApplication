angular.module('routerApp').controller(
    "billController",
    function ($scope, $http, $stateParams) {
    	$scope.transactionId = $stateParams.transactionId;
    });