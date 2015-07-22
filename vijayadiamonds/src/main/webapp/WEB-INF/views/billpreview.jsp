<div class="col-md-10 col-md-offset-0">
    <div class="col-md-offset-2">Cell : 9290896562,9550024166</div>
    <div class="col-md-offset-4">
        <h2>
            VIJAYA DIAMONDS<sub><small>Secunderabad</small></sub>
        </h2>
    </div>

    <div class="row col-md-offset-2">
        <span class="pull-left span-5"><strong>M/S : </strong><u>{{transaction.customer.name}}</u></span>
    </div>
    <div class="row col-md-offset-2">
        <span class="pull-left"><strong>Date : </strong><u>{{transaction.transactionDate
                |date : 'dd-MM-yyyy'}}</u></span>
    </div>
    <br />
    <div class="col-md-offset-2">
        <table class="table table-striped">
            <tr>
                <th>Particulars</th>
                <th>Quantity</th>
                <th>Rate</th>
                <th>Amount</th>
            </tr>
            <tr ng-repeat="item in transaction.items">
                <td>{{item.name}}</td>
                <td>{{item.quantity}} {{item.unit}}s</td>
                <td>{{item.sellingPrice}} / {{item.unit}}</td>
                <td>{{item.quantity*item.sellingPrice}}</td>
            </tr>
        </table>

    </div>
    <div class="row col-md-offset-2">
        <span class="pull-left span-5"><strong>Total
                Amount : </strong>{{transaction.totalAmount}}</span>
    </div>
    <div class="row col-md-offset-2">
        <span class="pull-left span-5"><strong>Paid
                Amount : </strong>{{transaction.paidAmount}}</span>
    </div>
    <div class="row col-md-offset-2 ">
        <strong>Signature : </strong>
    </div>
    <br /> <br />
    <div class="row col-md-offset-6 ">
        <a href="/files/{{transaction.id}}"><input type="button"
            value="Generate Bill" class="btn btn-primary" /></a>
    </div>
</div>