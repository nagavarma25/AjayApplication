<div class="col-md-10 col-md-offset-0">
    <div class="bg-success">
        <div class="row col-md-offset-3 col-md-8">
            <span class="pull-left"><address><strong>Customer name :</strong>{{customer.name}}</address></span>
            <span class="pull-right  text-left"><address><strong>Phone number :</strong>{{customer.phoneNumber}}
            </address></span>
        </div>
        <div class="row col-md-offset-3 col-md-8">
            <span class="pull-left"><address><strong>Total debt: </strong>{{totalDebt}}</address></span>
            <span class="pull-right text-left "><address><strong>Address :</strong>{{customer.address}}</address></span>
        </div>
    </div>
    <div class="col-md-11 col-md-offset-2 ">
        <table class="table table-hover">
            <tr>
                <th>Transaction date</th>
                <th>Total amount</th>
                <th>Paid amount</th>
                <th>Balance</th>
            </tr>
            <tr
                    ng-repeat-start="transaction in customer.transactions track by $index"
                    data-toggle="collapse" data-target="#demo1{{$index}}"
                    class="accordion-toggle">
                <td>{{transaction.transactionDate| date}}</td>
                <td>{{transaction.totalAmount}}</td>
                <td>{{transaction.paidAmount}}</td>
                <td>{{transactionBalances[$index]}}</td>
                <td>
                    <button class="btn btn-info  btn-sm" ng-show="transactionBalances[$index] >0"
                            ng-click="settleTransaction(transaction.id,$index)">
                        Settle
                    </button>
                </td>
            </tr>
            <tr ng-repeat-end class="hiddenRow">
                <td colspan="4">
                    <div class="accordian-body collapse"
                         id="demo1{{$index}}">

                        <table class="table table-striped">
                            <tbody>
                            <tr ng-repeat="sale in transaction.sales">
                                <td>{{sale.item.name}}</td>
                                <td>{{sale.item.unitPrice}}/{{sale.item.unit}}</td>
                                <td>{{sale.item.shape}}</td>
                                <td>{{sale.item.sellingPrice}}</td>
                                <td>{{sale.item.quantity}}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</div>