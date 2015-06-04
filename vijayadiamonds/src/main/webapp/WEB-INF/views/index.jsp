<!-- index.html -->

<!DOCTYPE html>
<html>
<head>

<!-- CSS (load bootstrap) -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="css/nav-bar.css">

<!-- JS (load angular,jquery,bootstrap, ui-router) -->
<script type="text/javascript" src="js/angular.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
    src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.12.1/ui-bootstrap-tpls.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<script src=https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.15/angular-ui-router.min.js></script>

<!-- JS(our custom js files for the app) -->
<script src="js/app.js"></script>
<script src="js/search_controller.js"></script>
<script src="js/item_controller.js"></script>
<script src="js/transaction_controller.js"></script>
<script src="js/billgen_controller.js"></script>
<script src="js/camelcase_filter.js"></script>
<script src="js/appconfig.js"></script>

<body ng-app="routerApp">
    <!-- header navigation bar -->
    <nav class="navbar navbar-default navbar-custom" role="navigation">
        <div class="navbar-header"><a class="navbar-brand" ui-sref="home">Brand</a>

            <div class="navbar-form navbar-left" role="search" ng-controller="searchController"><input
                type="text" class="form-control" placeholder="Search customer"
                ng-model="searchcustomer"
                typeahead="customer as customer.name+'('+customer.phoneNumber+')' for customer  in scustomers | filter:$viewValue "
                class="form-control" input-sm" typeahead-on-select='getTransactions()'></div></div>
    </nav>
    <div class="sidebar-nav">
        <!-- Side navigation bar -->
        <ul class="nav nav-list col-md-2">
            <li><a ui-sref="home">Home</a></li>
            <li><a ui-sref="additem">Add item</a></li>
            <li><a ui-sref="edititem">Edit item</a></li>
            <li><a ui-sref="addcustomer">Add customer</a></li>
            <li><a ui-sref="editcustomer">Edit customer</a></li>
            <li><a ui-sref="addtransaction">Add Transaction</a></li>
            <li><a ui-sref="edittransaction">Edit Transaction</a></li>
        </ul> <!-- Main content to display -->
        <div class="col-md-9 jumbotron">
            <div ui-view></div>
    </div>
    </div>
</body>
</html>