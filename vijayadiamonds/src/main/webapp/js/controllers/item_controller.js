//Controller for item related operations
angular.module('routerApp').controller(
		'itemController',
		function($scope, $http, $location) {
			$scope.item = {};

			$http.get("/item/allshapes").success(function(response) {
				$scope.shapes = response;
			}).error(function(error) {
				$scope.message = "Error in fetching";
			});

			$http.get("/item/all").success(function(response) {
				$scope.items = response;
				//alert(items);
			}).error(function(error) {
				$scope.message = "Error in fetching";
			});

			$scope.units = [ 'Carrat', 'Gram', 'Piece' ];

			$scope.additem = function() {
				$http.post("/item/add", $scope.item).success(
						function(response) {
							$scope.message = "Item added";
							$scope.item = {};
							$scope.addItem_form.reset = true;
						}).error(function(error) {
					$scope.message = "Item could not be added";
				})
			};
			
			$scope.edititem= function(itemId){
	            $location.path('edititem/' + itemId);
			}
		});