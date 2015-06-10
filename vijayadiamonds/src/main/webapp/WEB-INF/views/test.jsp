<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Example of Bootstrap 3 Accordion</title>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script> -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<script type="text/javascript" src="js/angular/angular.js"></script>
<script src="js/angular/bootstrap.min.js"></script>
<style type="text/css">
    .bs-example{
        margin: 20px;
    }
</style>
</head>
<body>
<table class="table table-hover">
    <thead>
        <th></th><th></th><th></th>
    </thead>
    
    <tbody>
        <tr data-toggle="collapse" data-target="#accordion" class="clickable">
            <td>Some Stuff</td>
            <td>Some more stuff</td>
            <td>And some more</td>
        </tr>
        <tr>
            <td colspan="3">
                <div id="accordion" class="collapse">Hidden by default</div>
            </td>
        </tr>
    </tbody>
</table>
</body>
</html>                                                                             