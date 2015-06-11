<div class="container  col-md-10 col-md-offset-1">

    <table class="table .table-condensed ">
        <tr>
            <td><label>Customer name :</label></td>
            <td>{{customer.name}}</td>
            <td><label>Address :</label></td>
            <td>{{customer.address}}</td>
        </tr>
        <tr>
            <td><label>Phone number :</label></td>
            <td>{{customer.phoneNumber}}</td>
            <td>Total debt</td>
            <td>{{balanceAmount}}</td>
        </tr>
    </table>

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
            <td>{{individulaBalances[$index]}}</td>
            <td>
                <button ng-show="individulaBalances[$index] >0"
                        ng-click="settleTransaction(transaction.id,individulaBalances[$index],$index)">
                    Settle
                </button>
            </td>
        </tr>
        <tr ng-repeat-end class="hiddenRow">
            <td colspan="3">
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