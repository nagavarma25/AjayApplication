<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Service Example</title>
    <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script> -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <script type="text/javascript" src="js/angular/angular.js"></script>
    <script src="js/angular/bootstrap.min.js"></script>
    <script src = "js/services/MathService.js"></script>
    <script src = "js/services/CalculatorService.js"></script>
    <script src = "js/controllers/CalculatorController.js"></script>
    <style type="text/css">
        .bs-example {
            margin: 20px;
        }
    </style>
</head>
<body>
<div ng-app="test">
    <div ng-controller="CalculatorController">
        Enter a number:
        <input type="number" ng-model="number" />
        <button ng-click="doSquare()">X<sup>2</sup></button>
        <button ng-click="doCube()">X<sup>3</sup></button>
         
        <div>Answer: {{answer}}</div>
    </div>
</div>
</body>
</html>                                                                             