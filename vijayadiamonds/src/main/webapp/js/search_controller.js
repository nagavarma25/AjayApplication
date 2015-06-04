//Controller for searching a customer
angular.module('routerApp').controller(
		"searchController",
		function($scope, $http, $location) {
			alert("search controller");
			$http.get("/billgeneration/customer/all").success(
					function(response) {
						$scope.scustomers = response;
					}).error(function(error) {
				$scope.message = "Error in fetching";
			});

			$scope.getTransactions = function() {
				var customerId = $scope.searchcustomer.id;
				// alert($scope.searchcustomer.id);
				$location.path('customertransactions/' + customerId);
			}
		});
