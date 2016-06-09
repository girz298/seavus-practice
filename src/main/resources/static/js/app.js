/**
 * Created by MK on 09.06.2016.
 */
var demoApp = angular.module('demoApp', ['ui.router']);
demoApp.config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/');

    $stateProvider

        .state('employees', {
            url: '/employees',
            templateUrl: 'partial-employees.html',
            controller: 'EmployeesController',
        })

        .state('projects', {
            url: '/projects',
            templateUrl: 'partial-projects.html',
            controller: 'ProjectsController',
        });

})  .controller('EmployeesController', ['$scope', '$http', EmployeesController])
    .controller('ProjectsController', ['$scope', '$http', ProjectsController]);
function EmployeesController($scope, $http) {
    $http.get('http://localhost:8080/api/employees').success(function (data) {
        $scope.employees = data._embedded.employees;
    });
}
function ProjectsController($scope, $http) {
    $http.get('http://localhost:8080/api/projects').success(function (data) {
        $scope.projects = data._embedded.projects;
    });
}