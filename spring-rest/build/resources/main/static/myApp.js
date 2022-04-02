var app = angular.module("myApp", ["ngRoute"]);

app.config(function($routeProvider){
    $routeProvider
    .when("/", {
        template : "<a href='#!add-animal'><button>Add Animal</button></a>"
    })
    .when("/add-animal", {
        templateUrl : "add-animal.html",
        controller : "addAnimalsController"
    })
    .otherwise({
        redirectTo : "/"
    });
});
