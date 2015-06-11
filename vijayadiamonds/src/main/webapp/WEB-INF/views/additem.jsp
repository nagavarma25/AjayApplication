<div>
    <div class="container  col-md-4 col-md-offset-4">
        <form name="addItem_form" novalidate>
            <legend>Add Item</legend>
            <div class="form-group ">
                <input ng-model="item.name" type="text"
                       class="form-control  input-sm"
                       placeholder="Item name" name="name" required>

                <small class="error"
                       ng-show="addItem_form.name.$dirty && addItem_form.name.$invalid">
                    <small class="error"
                           ng-show="addItem_form.name.$error.required">
                        Item name is required
                    </small>
                </small>
            </div>

            <div class="form-group ">
                <input type="text" ng-model="item.shape"
                       typeahead="shape| camelCase for shape in shapes | filter:$viewValue "
                       class="form-control  input-sm" placeholder="shape" required name="shape">

                <small class="error"
                       ng-show="addItem_form.shape.$dirty && addItem_form.shape.$invalid">
                    <small class="error"
                           ng-show="addItem_form.shape.$error.required">
                        Item shape is required
                    </small>
                </small>
            </div>
            <div class="form-group ">
                <input type="text" ng-model="item.unit"
                       typeahead="unit for unit in units | filter:$viewValue "
                       class="form-control  input-sm" placeholder="Unit" required name="unit">
                <small class="error"
                       ng-show="addItem_form.unit.$dirty && addItem_form.unit.$invalid">
                    <small class="error"
                           ng-show="addItem_form.unit.$error.required">
                        Item unit is required
                    </small>
                </small>
            </div>
            <div class="form-group ">
                <input type="number" ng-model="item.unitPrice"
                       class="form-control  input-sm"
                       placeholder="Unit price" required name="unitPrice">
                <small
                        class="error"
                        ng-show="addItem_form.unitPrice.$dirty && addItem_form.unitPrice.$invalid">
                    <small class="error"
                           ng-show="addItem_form.unitPrice.$error.required">
                        Unit price is required
                    </small>
                </small>
            </div>
            <div class="form-group">
                <button class="btn btn-primary btn-lg btn-block"
                        ng-click="additem()"
                        ng-disabled="addItem_form.$invalid">Add
                </button>
            </div>
            <div class="form-group">{{message}}</div>
        </form>
    </div>
</div>
