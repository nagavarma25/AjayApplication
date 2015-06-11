<div class="container  col-md-4 col-md-offset-4">
    <legend>Add Customer</legend>
    <form name="customerAddForm" novalidate>
        <div class="form-group ">
            <input type="text" ng-model="customer.name"
                   class="form-control  input-sm"
                   placeholder="Customer name" ng-required="true">
        </div>
        <div class="form-group">
            <input type="number" ng-model="customer.phoneNumber"
                   class="form-control  input-sm"
                   placeholder="Phone number" ng-required="true" ng-minlength=10 ng-maxlength=10>
        </div>
        <div class="form-group">
            <textarea ng-model="customer.address"
                      class="form-control  input-sm" placeholder="Address" ng-required="true"></textarea>
        </div>
        <div class="form-group">
            <button class="btn btn-primary btn-lg btn-block"
                    ng-click="addcustomer()" ng-disabled="customerAddForm.$invalid">Add Customer
            </button>
        </div>
        <div class="form-group">{{message}}</div>
    </form>
</div>
