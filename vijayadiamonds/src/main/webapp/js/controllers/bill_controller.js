angular.module('routerApp').controller(
    "billController",
    function ($scope, $http, $stateParams) {
    	$scope.transactionId = $stateParams.transactionId;
    	$http.get("/transaction/" + $scope.transactionId)
        .success(function (response) {
        	$scope.transaction = response;
        });
    	
    $scope.previewBill = function(){
    	$http.get("/files").success(
                function (response) {
                    //$scope.shapes = response;
                }).error(function (error) {
                    $scope.message = "Error in fetching";
                });
    }
    });