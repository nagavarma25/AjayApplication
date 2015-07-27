<div class="col-md-10">
    <div class="bg-success">
        <div class="row col-md-offset-3 col-md-8">
            <span class="pull-left"><address>
                    <strong>Customer name :</strong>{{customer.name}}
                </address></span> <span class="pull-right  text-left"><address>
                    <strong>Phone number :</strong>{{customer.phoneNumber}}
                </address></span>
        </div>
        <div class="row col-md-offset-3 col-md-8">
            <span class="pull-left"><address>
                    <strong>Total debt: </strong>{{totalDebt}}
                </address></span> <span class="pull-right text-left "><address>
                    <strong>Address :</strong>{{customer.address}}
                </address></span>
        </div>
    </div>
    <div class="row col-md-offset-2 col-md-10">
        <table class="table table-striped">
            <tr>
                <th>Transaction date</th>
                <th>Total amount</th>
                <th>Paid amount</th>
                <th>Balance</th>
                <th></th>
                <th></th>
            </tr>
            <tr ng-repeat="transaction in customer.transactions">
                <td>{{transaction.transactionDate| date}}</td>
                <td>{{transaction.totalAmount}}</td>
                <td>{{transaction.paidAmount}}</td>
                <td>{{transactionBalances[$index]}}</td>
                <td>
                    <button class="btn btn-info  btn-sm"
                        ng-show="transactionBalances[$index] >0"
                        ng-click="settleTransaction(transaction.id,$index)">
                        Settle</button>
                </td>
                <td>
                    <button class="btn btn-primary btn-sm"
                        data-toggle="modal"
                        data-target="#demo{{$index}}">Details</button>
                    <div class="modal fade" id="demo{{$index}}"
                        tabindex="-1" role="dialog"
                        aria-labelledby="myModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <span>Purchase details</span>
                                    <button type="button" class="close"
                                        data-dismiss="modal"
                                        aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <table class="table table-striped">
                                        <tbody>
                                            <tr>
                                                <th>Item name</th>
                                                <th>Actual price</th>
                                                <th>Shape</th>
                                                <th>Selling price</th>
                                                <th>Quantity</th>
                                            </tr>
                                            <tr
                                                ng-repeat="sale in transaction.sales">
                                                <td>{{sale.item.name}}</td>
                                                <td>{{sale.item.unitPrice}}/{{sale.item.unit}}</td>
                                                <td>{{sale.item.shape}}</td>
                                                <td>{{sale.sellingPrice}}/{{sale.item.unit}}</td>
                                                <td>{{sale.quantity}}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</div>