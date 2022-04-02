app.controller("addAnimalsController", function($scope, $http){

    alert("test");
    $http.get("/api/specie")
    .then(function(response) {
        $scope.species = response.data;
    });

    $http.get("/api/animal-enclosure")
    .then(function(response) {
        $scope.enclosures = response.data;
        alert($scope.enclosures);
    });
});