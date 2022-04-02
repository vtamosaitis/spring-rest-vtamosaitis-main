app.controller("addAnimalsController", function($scope, $http){

    $http.get("/api/specie")
    .then(function(response) {
        $scope.species = response.data;
    });

    $http.get("/api/animal-enclosure")
    .then(function(response) {
        $scope.enclosures = response.data;
    });

    $scope.add = function(){

        let data = {};
        data.name = $scope.name;
        if ($scope.specie) data.specie_id = $scope.specie.id;
        if ($scope.enclosure) data.enc_id = $scope.enclosure.id;

        $http.post("/api/animal", angular.toJson(data))
        .then(function(response) {
            if (response.data) $scope.res = "Data successfully posted."
            $scope.name = '';
            $scope.specie = null;
            $scope.enclosure = null;
        }, function(err) {
            alert("Failed to post with status " + err.statusText);
        });
    };
});