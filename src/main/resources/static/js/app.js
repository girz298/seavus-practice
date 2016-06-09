/**
 * Created by MK on 09.06.2016.
 */
angular.module('employees', []).controller('EmployeesController', ['$scope', '$http', EmployeesController]);
function EmployeesController($scope, $http) {
    $http.get('http://localhost:8080/api/employees').success(function (data) {
        $scope.employees = data._embedded.employees;
    });
}