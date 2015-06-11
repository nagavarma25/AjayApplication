var customerModule = angular.module("customerModule", ['searchModule']);
customerModule.controller("customerController", function ($scope, $http) {
    $scope.customer = {};
    $scope.addcustomer = function () {
        alert("add customer");
        $http.post("/billgeneration/customer/add", $scope.customer).success(
            function (response) {
                $scope.message = "done";
            }).error(function (error) {
                $scope.message = "error";
            })
    }
})