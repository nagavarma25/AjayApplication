//Controller for bill generation functionality
angular.module("routerApp").controller("billGenController", function ($scope, $http) {
    $scope.selectedItem = "";
    $scope.actualPrice = 0;
    $scope.selectedQuantity = 0;
    $http.get("/item/itemnames").success(function (response) {
        $scope.itemnames = response;
    }).error(function (error) {
        $scope.message = "Error in fetching";
    });
    $http.get("/item/allshapes").success(function (response) {
        $scope.shapes = response;
    }).error(function (error) {
        $scope.message = "Error in fetching";
    });
    $http.get("/item/all").success(function (response) {
        $scope.items = response;
    }).error(function (error) {
        $scope.message = "Error in fetching";
    });
    $http.get("/customer/all").success(function (response) {
        $scope.customers = response;
    }).error(function (error) {
        $scope.message = "Error in fetching";
    });

    $scope.bill = {};
    $scope.actualItems = [];

    $scope.addtolist = function () {
        var selected = {
            name: $scope.selectedItem.name,
            shape: $scope.selectedItem.shape,
            sellingPrice: $scope.selectedItem.actualPrice,
            quantity: $scope.selectedItem.quantity,
        }
        $scope.actualItems = $scope.actualItems.concat(selected);
        $scope.item = "";
        $scope.selectedItem.name = "";
        $scope.selectedItem.shape = "";
        $scope.selectedItem.actualPrice = 0;
        $scope.selectedItem.quantity = 0;
        $scope.bill.totalAmount = calculateTotalAmount($scope.actualItems);
    };

    $scope.getItemByNameandShape = function () {
        $http.get(
                "/item/getbynameandshape?name="
                + $scope.selectedItem.name + "&shape="
                + $scope.selectedItem.shape).success(function (response) {
                $scope.item = response;
                $scope.selectedItem.actualPrice = $scope.item.unitPrice;
            }).error(function (error) {
                $scope.message = "Error in fetching";
            });

    };

    $scope.saveTransaction = function () {
        $scope.bill.itemResources = $scope.actualItems;
        $scope.bill.customer = $scope.customer;
        alert($scope.customer.id);
        $http.post("/item/addTransaction", $scope.bill).success(
            function (response) {
                $scope.message = "done";
            }).error(function (error) {
                $scope.message = "error";
            })
    };

    calculateTotalAmount = function (items) {
        var totalAmount = 0;
        for (i = 0; i < items.length; i++) {
            totalAmount = totalAmount + (items[i].sellingPrice * items[i].quantity);
        }
        return totalAmount;
    }
});
