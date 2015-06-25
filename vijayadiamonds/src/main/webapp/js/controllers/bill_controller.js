angular.module('routerApp').controller(
    "billController",
    function ($scope, $http, $stateParams) {
    	$scope.transactionId = $stateParams.transactionId;
    	$http.get("/transaction/" + $scope.transactionId)
        .success(function (response) {
        	$scope.transaction = response;
        });
    });