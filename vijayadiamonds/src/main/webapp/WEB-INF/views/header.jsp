<!-- Latest compiled and minified CSS -->
<script type="text/javascript" src="js/angular.js"></script>
<link rel="stylesheet"
      href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- jQuery library -->
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.12.1/ui-bootstrap-tpls.js"></script>
<!-- Latest compiled JavaScript -->
<script
        src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="js/searchmodule.js">
</script>
<script src="js/homemodule.js"></script>
<script src="js/customermodule.js"></script>
<script src="js/billgenmodule.js"></script>

<nav class="navbar navbar-inverse">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#navbar-collapse-3">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Brand</a>
        </div>
        <div>
            <form class="navbar-form navbar-right" role="search">
                <div class="form-group" ng-controller="searchController">

                    <input type="text" ng-model="searchcustomer"
                           typeahead="customer as customer.name+'('+customer.phoneNumber+')' for customer  in scustomers | filter:$viewValue "
                           class="form-control" placeholder="Customer"
                           class="form-control  input-sm" typeahead-on-select='getTransactions()'>
                </div>
                <button type="submit" class="btn btn-danger">
                    <span class="glyphicon glyphicon-search"
                          aria-hidden="true"></span>
                </button>
            </form>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-3">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="home">Home</a></li>
                <li><a href="billgeneration">Generate bill</a></li>
                <li><a href="addcustomer">Add a customer</a></li>
                <!-- <li><a
                    class="btn btn-default btn-outline btn-circle collapsed"
                    data-toggle="collapse" href="#nav-collapse3"
                    aria-expanded="false" aria-controls="nav-collapse3">Search</a>
                </li> -->
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
<!-- /.navbar -->

