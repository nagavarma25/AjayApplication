angular.module('routerApp').controller(
		"custtransactionController",
		function($scope, $http, $stateParams) {
			$scope.oneAtATime = true;

			$scope.customerId = $stateParams.customerId;
			//alert($scope.customer.id);
			$http.get("/customer/" + $stateParams.customerId)
					.success(function(response) {
						$scope.customer = response;
					});
			$http.get(
					"/customer/" + $stateParams.customerId
							+ "/transactions").success(function(response) {
				$scope.transactions = response;
			});

			$scope.expand = function() {
				var exp = $scope.collapseone;
				//alert(exp);
				$scope.collapseone = !exp;
			}
		});