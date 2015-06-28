<div class="container  col-md-8 col-md-offset-2">
<h2  class="text-center">All items</h2>
    <table class="table table-striped">
        <tr>
            <th>Name</th>
            <th>Unit</th>
            <th>Price</th>
            <th>Shape</th>
            <th></th>
        </tr>
        <tr ng-repeat="item in items">
            <td>{{item.name}}</td>
            <td>{{item.unit}}</td>
            <td>{{item.unitPrice}}</td>
            <td>{{item.shape}}</td>
            <td><button ng-click = "edititem(item.id)" class = "btn btn-primary btn-small">Edit</button></td>
        </tr>
    </table>

</div>