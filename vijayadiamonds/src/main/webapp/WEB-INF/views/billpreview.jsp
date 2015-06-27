<div class="col-md-10 col-md-offset-0">
    <div align="center">Cell :9290896562,9550024166<br />
        <h2>VIJAYA DIAMONDS</h2></div> <br /> <br /> <br />
    <div class="bg-success">
        <div class="row col-md-offset-3 col-md-8"><span class="pull-left span-5"><strong>M/S
                    : </strong><u>{{transaction.customer.name}}</u></span></div>
        <div class="row col-md-offset-3 col-md-8"><span class="pull-left"><strong>Date
                    : </strong><u>{{transaction.totalAmount}}</u></span></div>
        <div class="row col-md-offset-3 col-md-8">
            <table class="table table-hover">
                <th>
                <td>Particulars</td>
                <td>Quantity</td>
                <td>Rate</td>
                <td>Amount</td>
                </th>
                <tr ng-repeat="item in transaction.items">
                    <td>{{item.name}}</td>
                    <td>{{item.quantity}}</td>
                    <td>{{item.sellingPrice}}</td>
                    <td>{{item.quantity*item.sellingPrice}}</td>
                </tr>
            </table>
    </div>

        <div class="row col-md-offset-3 col-md-8"><span class="pull-left span-5"><strong>Total
                    Amount : </strong>{{transaction.totalAmount}}</span></div>
        <div class="row col-md-offset-3 col-md-8"><span class="pull-left span-5"><strong>Paid
                    Amount : </strong>{{transaction.paidAmount}}</span></div>
        <div class="row col-md-offset-3 col-md-8"><span class="pull-left span-5"><strong>Signature
                    : </strong></span><span class = "span-5 pull-right"><a href="/files/{{transaction.id}}"><input type="button" value="Bill Generate" /></a></span></div>
</div>
</div>