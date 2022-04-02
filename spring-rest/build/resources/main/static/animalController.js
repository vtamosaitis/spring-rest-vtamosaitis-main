app.controller("animalController", function($scope, $http, $interval){
    getData();
    $interval(getData, 5000);

    $scope.orderBy = function(att) {
        ($scope.att === att) ? $scope.att = '-' + att : $scope.att = att;
    };

    function getData() {
        $http.get("/api/animal/joined")
        .then(function(response) {
            $scope.animals = response.data;
        });
    }
});