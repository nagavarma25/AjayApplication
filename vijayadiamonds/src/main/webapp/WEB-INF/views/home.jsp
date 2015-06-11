<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<%@include file="header.jsp" %>
<body ng-app="homeMod">
<div class="container  col-md-4 col-md-offset-4" ng-controller="homeController">
    <legend>Add Item</legend>
    <div class="form-group ">
        Name: <input ng-model="item.name" type="text"
                     class="form-control  input-sm" placeholder="Item name">
    </div>
    <div class="form-group ">
        Shape:<br/> <input type="text" ng-model="item.shape"
                           typeahead="shape for shape in shapes | filter:$viewValue "
                           class="form-control  input-sm" placeholder="shape">
    </div>
    <div class="form-group ">
        Unit: <br/> <input type="text" ng-model="item.unit"
                           typeahead="unit for unit in units | filter:$viewValue "
                           class="form-control  input-sm" placeholder="Unit">
    </div>
    <div class="form-group ">
        Cost/Unit <input type="number" ng-model="item.unitPrice" class="form-control  input-sm"
                         placeholder="Unit price">
    </div>
    <div class="form-group">
        <button class="btn btn-primary btn-lg btn-block"
                ng-click="additem()">Add
        </button>
    </div>
</div>


</body>
</html>
