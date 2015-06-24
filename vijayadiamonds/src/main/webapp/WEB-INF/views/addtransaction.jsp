<div class="container  col-md-4 col-md-offset-4" ng-show="divshow">
    <legend>Bill Generation</legend>
    <div class="form-group ">
        Customer : <input type="text" ng-model="customer"
                          typeahead="customer as customer.name+'('+customer.phoneNumber+')' for customer  in customers | filter:$viewValue "
                          class="form-control" placeholder="Customer"
                          class="form-control  input-sm">
    </div>

    <div class="form-group ">
        Name : <input type="text" ng-model="selectedItem.name"
                      typeahead="name for name  in itemnames | filter:$viewValue "
                      class="form-control" placeholder="item name"
                      class="form-control  input-sm"
                      typeahead-on-select='getShapesByName()'>
    </div>
    <div class="form-group ">
        Shape : <input type="text" ng-model="selectedItem.shape"
                       typeahead="shape for shape  in shapes | filter:$viewValue "
                       class="form-control  input-sm" placeholder="Shape"
                       class="form-control  input-sm"
                       typeahead-on-select='getItemByNameandShape()'>
    </div>

    <div class="form-group ">
        UnitPrice: <input type="number" class="form-control  input-sm"
                          ng-model="selectedItem.actualPrice">/{{item.unit}}
    </div>
    <!-- <div class="form-group ">
      Price after discount: <input type="number" ng-model="actualPrice" class="form-control  input-sm">
    </div> -->

    <div class="form-group ">
        Quantity:<input type="number" ng-model="selectedItem.quantity"
                        class="form-control  input-sm">
    </div>

    <div class="form-group ">
        Price(UnitPrice*Quantity): <input type="number"
                                          value='{{selectedItem.actualPrice * selectedItem.quantity}}'
                                          class="form-control  input-sm">
    </div>

    <div class="form-group">
        <button ng-click="addtolist()">Add to cart</button>
        <button ng-show="actualItems.length>0 " ng-click="showcart()">Show
            Items in cart
        </button>
    </div>
</div>


<div ng-show="actualItems.length>0 && !divshow ">


    <legend>Selected List</legend>
    <table class="table">
        <tr>
            <th>Name</th>
            <th>Shape</th>
            <th>Selling price</th>
            <th>Quantity</th>
            <th>Amount</th>
        </tr>
        <tr ng-repeat="actualItem in actualItems">
            <td>{{actualItem.name}}</td>
            <td>{{actualItem.shape}}</td>
            <td>{{actualItem.sellingPrice}}</td>
            <td>{{actualItem.quantity}}</td>
            <td>{{(actualItem.sellingPrice)*(actualItem.quantity)}}</td>
        </tr>
        <tr>
            <td colspan="5">Total amount :{{bill.totalAmount}}</td>
        </tr>
        <tr>
            <td colspan="5">Paid amount :<input type="text"
                                                ng-model="bill.paidAmount"></td>
        </tr>
    </table>
    <p></p>

    <div class="form-group">
        <button ng-click="saveTransaction()">Save</button>
        <button ng-click="goBack()">Back</button>
    </div>
</div>

<div class="form-group">{{message}}</div>