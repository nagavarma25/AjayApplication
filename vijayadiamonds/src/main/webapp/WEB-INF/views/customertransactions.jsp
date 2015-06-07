
     <div class="panel-group" id="accordion" ng-repeat="transaction in transactions">
        <div class="panel panel-default" ng-init='collapseone = false'>
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" ng-click="expand()">{{transaction.id}}</a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in" ng-show="collapseone">
                <div class="panel-body">
                    <p>{{transaction.totalAmount}}</p>
                </div>
            </div>
        </div>
        </div>
        <!-- <table>
            <tr>
                <td>Total amount</td>
                <td>Paid amount</td>
                <td>Transaction date</td>
                <td>Last updated date</td>
            </tr>
            <tr >
                <td>{{transaction.id}}</td>
                <td>{{transaction.totalAmount}}</td>
                <td>{{transaction.paidAmount}}</td>
                <td>{{transaction.transactionDate}}</td>
                <td>{{transaction.lastUpdatedDate}}</td>
            </tr>
        </table> -->
        
        <!-- <div class="bs-example">
    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">1. What is HTML?</a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in" ng-show = 'expand+'>
                <div class="panel-body">
                    <p>HTML stands for HyperText Markup Language. HTML is the main markup language for describing the structure of Web pages. <a href="http://www.tutorialrepublic.com/html-tutorial/" target="_blank">Learn more.</a></p>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">2. What is Bootstrap?</a>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse">
                <div class="panel-body">
                    <p>Bootstrap is a powerful front-end framework for faster and easier web development. It is a collection of CSS and HTML conventions. <a href="http://www.tutorialrepublic.com/twitter-bootstrap-tutorial/" target="_blank">Learn more.</a></p>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">3. What is CSS?</a>
                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse">
                <div class="panel-body">
                    <p>CSS stands for Cascading Style Sheet. CSS allows you to specify various style properties for a given HTML element such as colors, backgrounds, fonts etc. <a href="http://www.tutorialrepublic.com/css-tutorial/" target="_blank">Learn more.</a></p>
                </div>
            </div>
        </div>
    </div>
</div> -->
    
