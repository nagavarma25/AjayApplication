//Configuring router for different states
angular.module('routerApp').config(
		function($stateProvider, $urlRouterProvider) {
			//When no route was provided
			$urlRouterProvider.otherwise('/home');

			$stateProvider
			// Home
			.state('home', {
				url : '/home',
				templateUrl : 'partial-home',
			})

			// Add an item
			.state('additem', {
				url : '/additem',
				templateUrl : 'item/add',
				controller : 'itemController'
			})

			// Edit an item
			.state('edititem', {
				url : '/edititem/:itemId',
				templateUrl : 'item/edit',
				controller : 'edititemController'
			})

			// Add a customer
			.state('addcustomer', {
				url : '/addcustomer',
				templateUrl : 'customer/add',
				controller : 'customerController'
			})

			// Edit a customer
			.state('editcustomer', {
				url : '/editcustomer',
				templateUrl : 'customer/edit',
				controller : 'itemController'
			})
			// Add a transaction
			.state('addtransaction', {
				url : '/addtransaction',
				templateUrl : 'transaction/add',
				controller : 'transactionController'
			})

			// Edit a transaction
			.state('edittransaction', {
				url : '/edittransaction',
				templateUrl : 'transaction/edit',
				controller : 'itemController'
			})

			// customer transactions
			.state('customertransactions', {
				url : '/customertransactions/:customerId',
				templateUrl : 'customer/transactions',
				controller : 'custtransactionController'
			})
			//Preview bill
			.state('billpreview', {
				url : '/billpreview/:transactionId',
				templateUrl : 'bill/preview',
				controller : 'billController'
			})
			.state('allitems',{
				url :'/allitems',
				templateUrl : '/item/list',
				controller : 'itemController'
			})
			;

		});