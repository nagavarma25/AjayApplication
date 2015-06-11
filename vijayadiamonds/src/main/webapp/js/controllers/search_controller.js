//Controller for searching a customer
angular.module('routerApp').controller(
    "searchController",
    function ($scope, $http, $location) {
        $http.get("/customer/all").success(
            function (response) {
                $scope.scustomers = response;
            }).error(function (error) {
                $scope.message = "Error in fetching";
            });

        $scope.getTransactions = function () {
            var customerId = $scope.searchcustomer.id;
            //var customer = $scope.searchcustomer;
            //alert(customer.name);				 alert(customer.phoneNumber);
            //alert(customer.address);
            $location.path('customertransactions/' + customerId);
        }
    });
