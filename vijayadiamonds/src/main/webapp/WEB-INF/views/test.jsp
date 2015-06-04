<!doctype html>
<html>
<head>
<script src="js/angular.js"></script>
</head>
<body ng-app="test">

   
    
    <div ng-init ="name ='janardhan ravada'">
    {{name|camelCase}}
    
    {{name}}
    </div>
</body>

<script type="text/javascript">
var routerApp = angular.module('test', [ ]);


angular.module('test')
.filter('camelCase', function() {
    return function(str) {
        return (str == undefined || str === null) ? '' : str.replace(/_|-/, ' ').replace(/\w\S*/g, function(txt){
            return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();
        });
    }
});
</script>
</html>