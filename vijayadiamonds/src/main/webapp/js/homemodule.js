var homeMod = angular.module("homeMod", [ 'ui.bootstrap', 'searchModule' ]);

angular.module("homeMod").controller(
    "homeController",
    function ($scope, $http) {
        $scope.item = {};

        $http.get("/billgeneration/item/allshapes").success(
            function (response) {
                $scope.shapes = response;
            }).error(function (error) {
                $scope.message = "Error in fetching";
            });

        $scope.units = [ 'Carrat', 'Gram', 'Quantity' ];

        $scope.onSelect = function () {
            alert("hi");
        };

        $scope.additem = function () {

            $http.post("/billgeneration/item/add", $scope.item).success(
                function (response) {
                    $scope.message = "done";
                }).error(function (error) {
                    $scope.message = "error";
                })
        };
    });