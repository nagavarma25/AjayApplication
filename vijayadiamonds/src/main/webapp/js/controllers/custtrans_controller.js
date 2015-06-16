angular.module('routerApp').controller(
    "custtransactionController",
    function ($scope, $http, $stateParams) {
        $scope.oneAtATime = true;

        $scope.customerId = $stateParams.customerId;
        $scope.transactionBalances = [];
        //alert($scope.customer.id);
        $http.get("/customer/" + $stateParams.customerId)
            .success(function (response) {
                $scope.customer = response;
                $scope.totalDebt = calculateTotalDebt($scope.customer.transactions);
            });

        calculateTotalDebt = function (transactions) {
            var paidAmount = 0;
            var totalAmount = 0;

            for (i = 0; i < transactions.length; i++) {
                $scope.transactionBalances[i] = transactions[i].totalAmount - transactions[i].paidAmount;
                paidAmount = paidAmount + transactions[i].paidAmount;
                totalAmount = totalAmount + transactions[i].totalAmount;
            }
            return totalAmount - paidAmount;
        };

        $scope.settleTransaction = function (transId, index) {
            $http.put('/transaction/' + transId + '/settle').success(function () {
                $scope.totalDebt = $scope.totalDebt - $scope.transactionBalances[index];
                $scope.transactionBalances[index] = 0;
            });
        }
    });