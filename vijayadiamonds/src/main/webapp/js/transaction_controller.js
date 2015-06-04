//Controller for transaction related operations
angular.module('routerApp').controller(
		"transactionController",
		function($scope, $http, $stateParams) {

			$http.get(
					"/billgeneration/customer/" + $stateParams.customerId
							+ "/transactions").success(function(response) {
				$scope.transactions = response;
			});
		});