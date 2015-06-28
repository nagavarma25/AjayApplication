<div class="container  col-md-4 col-md-offset-4">
<h2 class="text-center">Edit item</h2>
    <div class="form-group ">
        <small>Name :</small><input ng-model="item.name" type="text"
            class="form-control  input-sm" name="name"
            disabled="disabled">


    </div>

    <div class="form-group ">
        <small>Shape :</small><input type="text" ng-model="item.shape"
            class="form-control  input-sm" required name="shape"
            disabled="disabled">


    </div>
    <div class="form-group ">
        <small>Unit :</small><input type="text" ng-model="item.unit"
            typeahead="unit for unit in units | filter:$viewValue "
            class="form-control  input-sm" placeholder="Unit" required
            name="unit">

    </div>
    <div class="form-group ">
       <small>Unit price :</small> <input type="number" ng-model="item.unitPrice"
            class="form-control  input-sm" placeholder="Unit price"
            required name="unitPrice">
    </div>
</div>