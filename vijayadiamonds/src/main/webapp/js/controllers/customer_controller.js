//Controller for item related operations
angular.module('routerApp').controller(
    'customerController',
    function ($scope, $http) {
        $scope.customer = {};
        $scope.addcustomer = function () {
            $http.post("/customer/add", $scope.customer)
                .success(function (response) {
                    $scope.message = "Customer added.";
                    $scope.customer = {};
                }).error(function (error) {
                    $scope.message = "Customer could be added.";
                })
        }
    });