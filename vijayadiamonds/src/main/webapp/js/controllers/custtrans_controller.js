angular.module('routerApp').controller(
    "custtransactionController",
    function ($scope, $http, $stateParams) {
        $scope.oneAtATime = true;

        $scope.customerId = $stateParams.customerId;
        $scope.individulaBalances=[];
        //alert($scope.customer.id);
        $http.get("/customer/" + $stateParams.customerId)
            .success(function (response) {
                $scope.customer = response;
                $scope.balanceAmount = calculateBalanceAmount($scope.customer.transactions);
            });

        calculateBalanceAmount = function (transactions) {
            var paidAmount = 0;
            var totalAmount = 0;

            for (i = 0; i < transactions.length; i++) {
                $scope.individulaBalances[i]=transactions[i].totalAmount - transactions[i].paidAmount;
                //alert($scope.individulaBalances[i]);
                paidAmount = paidAmount + transactions[i].paidAmount;
                totalAmount = totalAmount + transactions[i].totalAmount;
            }
            return totalAmount-paidAmount;
        };

        $scope.settleTransaction =function(transId,paidAmount,index){
            $scope.balanceAmount = $scope.balanceAmount - paidAmount;
            $scope.individulaBalances[index] = 0;
        }

    });