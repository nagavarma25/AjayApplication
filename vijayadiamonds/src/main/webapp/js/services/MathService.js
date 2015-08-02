var app = angular.module('test',[]);

app.service('MathService',function(){
	this.add = function(a , b){
		return a+b;
	};
	
	this.subtract = function(a , b){
		return a-b;
	}
	
	this.multiply = function(a , b){
		return a*b;
	}
	
	this.divide = function(a , b){
		return a/b;
	}
});