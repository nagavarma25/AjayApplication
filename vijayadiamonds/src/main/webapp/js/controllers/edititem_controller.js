angular.module('routerApp').controller(
		"edititemController",
		function($scope, $http, $stateParams) {
			$scope.units = [ 'Carrat', 'Gram', 'Quantity' ];
			$http.get("/item/" + $stateParams.itemId).success(
					function(response) {
						$scope.item = response;
					}).error(function(error) {
				$scope.message = "Error in fetching";
			});
		});