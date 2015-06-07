//Controller for item related operations
angular.module('routerApp').controller(
		'itemController',
		function($scope, $http) {
			$scope.item = {};

			$http.get("/billgeneration/item/allshapes").success(
					function(response) {
						$scope.shapes = response;
					}).error(function(error) {
				$scope.message = "Error in fetching";
			});

			$scope.units = [ 'Carrat', 'Gram', 'Quantity' ];

			$scope.additem = function() {
				$http.post("/billgeneration/item/add", $scope.item).success(
						function(response) {
							$scope.message = "Item added";
							$scope.item = {};
							$scope.addItem_form.reset= true;
						}).error(function(error) {
					$scope.message = "Item could not be added";
				})
			};
		});