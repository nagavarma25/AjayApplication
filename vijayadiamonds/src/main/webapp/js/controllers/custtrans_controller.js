angular.module('routerApp').controller(
		"custtransactionController",
		function($scope, $http, $stateParams) {
			//$scope.collapseone = false;
			$scope.customerId = $stateParams.customerId;
			$http.get(
					"/billgeneration/customer/" + $stateParams.customerId
							+ "/transactions").success(function(response) {
				$scope.transactions = response;
			});
			
			$scope.expand = function(){
				var exp = $scope.collapseone;
				alert(exp);
				$scope.collapseone = !exp;
			}
		});