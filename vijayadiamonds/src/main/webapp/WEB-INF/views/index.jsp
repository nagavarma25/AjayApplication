<!-- index.html -->

<!DOCTYPE html>
<html>
<head>

    <!-- CSS (load bootstrap) -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/nav-bar.css">

    <!-- JS (load angular,jquery,bootstrap, ui-router) -->
    <script type="text/javascript" src="js/angular/angular.js"></script>
    <script src="js/angular/jquery.min.js"></script>
    <script
            src="js/angular/ui-bootstrap-tpls.js"></script>
    <script src="js/angular/bootstrap.min.js"></script>
</head>
<script src="js/angular/angular-ui-router.min.js"></script>

<!-- JS(our custom js files for the app) -->
<script src="js/app.js"></script>
<script src="js/controllers/search_controller.js"></script>
<script src="js/controllers/item_controller.js"></script>
<script src="js/controllers/customer_controller.js"></script>
<script src="js/controllers/transaction_controller.js"></script>
<script src="js/controllers/custtrans_controller.js"></script>
<script src="js/controllers/bill_controller.js"></script>
<script src="js/controllers/edititem_controller.js"></script>
<!-- <script src="js/controllers/billgen_controller.js"></script> -->
<script src="js/filters/camelcase_filter.js"></script>
<script src="js/appconfig.js"></script>

<body ng-app="routerApp">
<!-- header navigation bar -->
<nav class="navbar navbar-default navbar-custom" role="navigation">
    <div class="navbar-header"><a class="navbar-brand" ui-sref="home">Brand</a>

        <div class="navbar-form navbar-left" role="search" ng-controller="searchController"><input
                type="text" class="form-control" placeholder="Search customer"
                ng-model="searchcustomer"
                typeahead="customer as customer.name+'('+customer.phoneNumber+')' for customer  in scustomers | filter:$viewValue "
                class="form-control" input-sm" typeahead-on-select='getTransactions()'>
        </div>
    </div>
</nav>
<div class="sidebar-nav">
    <!-- Side navigation bar -->
    <ul class="nav nav-list col-md-2">
        <li><a ui-sref="home">Home</a></li>
        <li><a ui-sref="additem">Add item</a></li>
        <li><a ui-sref="allitems">All items</a></li>
        <li><a ui-sref="edititem">Edit item</a></li>
        <li><a ui-sref="addcustomer">Add customer</a></li>
        <li><a ui-sref="editcustomer">All customers</a></li>
        <li><a ui-sref="editcustomer">Edit customer</a></li>
        <li><a ui-sref="addtransaction">Add Transaction</a></li>
        <li><a ui-sref="edittransaction">Edit Transaction</a></li>
    </ul>
    <!-- Main content to display -->
    <div class="container col-md-9">
        <div ui-view></div>
    </div>
</div>
</body>
</html>