//Controller for transaction related operations
angular.module('routerApp').controller(
		"transactionController",
		function($scope, $http) {
			
			$scope.divshow = true;
			$scope.selectedItem = "";
			$scope.actualPrice = 0;
			$scope.selectedQuantity = 0;
			$http.get("/billgeneration/item/itemnames").success(function(response) {
				$scope.itemnames = response;
			}).error(function(error) {
				$scope.message = "Error in fetching";
			});
			$http.get("/billgeneration/item/allshapes").success(function(response) {
				$scope.shapes = response;
			}).error(function(error) {
				$scope.message = "Error in fetching";
			});
			$http.get("/billgeneration/item/all").success(function(response) {
				$scope.items = response;
			}).error(function(error) {
				$scope.message = "Error in fetching";
			});
			$http.get("/billgeneration/customer/all").success(function(response) {
				$scope.customers = response;
			}).error(function(error) {
				$scope.message = "Error in fetching";
			});

			$scope.bill={};
			$scope.actualItems = [];

			$scope.addtolist = function() {
				var selected = {
					name : $scope.selectedItem.name,
					shape: $scope.selectedItem.shape,
					sellingPrice:$scope.selectedItem.actualPrice,
					quantity : $scope.selectedItem.quantity,
				}
				$scope.actualItems = $scope.actualItems.concat(selected);
				$scope.item = "";
				$scope.selectedItem.name = "";
				$scope.selectedItem.shape = "";
				$scope.selectedItem.actualPrice = 0;
				$scope.selectedItem.quantity = 0;
				$scope.bill.totalAmount =calculateTotalAmount( $scope.actualItems);
			};

			$scope.getItemByNameandShape = function() {
				$http.get(
						"/billgeneration/item/getbynameandshape?name="
								+ $scope.selectedItem.name + "&shape="
								+ $scope.selectedItem.shape).success(function(response) {
					$scope.item = response;
					$scope.selectedItem.actualPrice = $scope.item.unitPrice;
				}).error(function(error) {
					$scope.message = "Error in fetching";
				});

			};
			
			$scope.saveTransaction = function(){
				$scope.bill.itemResources = $scope.actualItems;
				$scope.bill.customer = $scope.customer;
				alert($scope.customer.id);
				$http.post("/billgeneration/transaction/add", $scope.bill).success(
						function(response) {
							$scope.actualItems = [];
							$scope.divshow = true;
							$scope.message = "Transaction Added";
						}).error(function(error) {
					$scope.message = "error";
				})
			};
			
			calculateTotalAmount = function(items){
				var totalAmount = 0;
				for(i= 0;i<items.length;i++){
					totalAmount = totalAmount+(items[i].sellingPrice*items[i].quantity);
				}
				return totalAmount;
			}

			$scope.showcart = function(){
				$scope.divshow = false;
			};
			$scope.goBack=function(){
				$scope.divshow = true;
			};
			
		});