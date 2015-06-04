

    <div class="container  col-md-4 col-md-offset-4">
        <legend>Add Customer</legend>
        <div class="form-group ">
            <input type="text" ng-model="customer.name"
                class="form-control  input-sm"
                placeholder="Customer name">
        </div>
        <div class="form-group">
            <input type="number" ng-model="customer.phoneNumber"
                class="form-control  input-sm"
                placeholder="Phone number">
        </div>
        <div class="form-group">
            <textarea ng-model="customer.address"
                class="form-control  input-sm" placeholder="Address"></textarea>
        </div>
        <div class="form-group">
            <button class="btn btn-primary btn-lg btn-block"
                ng-click="addcustomer()">Add Customer</button>
        </div>
    </div>
