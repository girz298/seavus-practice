newsApp.controller('MainPageNewsCtrl', ['$scope','$http', function($scope,$http){
	$scope.news = [];
	$http.get("http://localhost:8080/api/articles").success(function (data, status, headers, config) {
          $scope.news = data._embedded.articles;
    });
}]);

