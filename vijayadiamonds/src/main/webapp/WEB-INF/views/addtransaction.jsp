<div class="container  col-md-4 col-md-offset-4" ng-show="divshow">
    <legend>Bill Generation</legend>
    <small>Customer</small> :
    <div class="form-group ">
        <input type="text" ng-model="customer"
            typeahead="customer as customer.name+'('+customer.phoneNumber+')' for customer  in customers | filter:$viewValue "
            placeholder="Customer" class="form-control  input-sm">
    </div>

    <div class="form-group ">
        <small>Item :</small> <input type="text"
            ng-model="selectedItem.name"
            typeahead="name for name  in itemnames | filter:$viewValue "
            placeholder="item name" class="form-control  input-sm"
            typeahead-on-select='getShapesByName()'>
    </div>
    <div class="form-group ">
        <small> Shape :</small> <input type="text"
            ng-model="selectedItem.shape"
            typeahead="shape for shape  in shapes | filter:$viewValue "
            class="form-control  input-sm" placeholder="Shape"
            typeahead-on-select='getItemByNameandShape()'>
    </div>

    <div class="form-group ">
        <small>Price/{{item.unit}}</small><input type="number"
            class="form-control  input-sm" placeholder="Unit price"
            ng-model="selectedItem.actualPrice">
    </div>
    <!-- <div class="form-group ">
      Price after discount: <input type="number" ng-model="actualPrice" class="form-control  input-sm">
    </div> -->

    <small>Quantity :</small>
    <div class="form-group ">
        <input type="number" ng-model="selectedItem.quantity"
            class="form-control  input-sm" placeholder="Quantity">
    </div>

    <small> Total Amount :</small>
    <div class="form-group ">
        <input type="number"
            value='{{selectedItem.actualPrice * selectedItem.quantity}}'
            class="form-control  input-sm" placeholder="Amount">
    </div>

    <div class="form-group">
        <button ng-click="addtolist() " class="btn btn-success">Add
            to cart</button>
        <button ng-show="actualItems.length>0 " ng-click="showcart()"
            class="btn btn-success">Show Items in cart</button>
    </div>
</div>


<div ng-show="actualItems.length>0 && !divshow "
    class="container  col-md-7 col-md-offset-2">


    <legend >Items in cart</legend>
    <table class="table .table-bordered">
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
            <td>{{actualItem.sellingPrice}} </td>
            <td>{{actualItem.quantity}}</td>
            <td>{{(actualItem.sellingPrice)*(actualItem.quantity)}}</td>
        </tr>

    </table>
    <p></p>
    <div class="form-group text-small  col-md-5 col-md-offset-7">Total amount
        :{{bill.totalAmount}}</div>
    <div class="form-group text-small  col-md-3 col-md-offset-7">
       <input type="number" ng-model="bill.paidAmount"  class="form-control  input-sm" placeholder="Paid amount">
    </div>
    <div class="form-group text-small  col-md-3 col-md-offset-7">
       <input type="text" ng-model="bill.worker"  class="form-control  input-sm" placeholder="Worker name">
    </div>
    <div class="form-group col-md-5 col-md-offset-4">
        <button ng-click="saveTransaction()"  class="btn btn-primary">Save</button>
        <button ng-click="goBack()"  class="btn btn-primary">Back</button>
    </div>
</div>

<div class="form-group">{{message}}</div>