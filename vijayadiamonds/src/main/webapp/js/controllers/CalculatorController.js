angular.module('test').controller('CalculatorController', function (MathService , CalculatorService, $scope){
	$scope.doSquare = function (){
		$scope.answer = CalculatorService.square($scope.number);
	};
	
	$scope.doCube = function (){
		$scope.answer = CalculatorService.cube($scope.number);
	}
});