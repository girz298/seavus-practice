var newsApp = angular.module('newsApp', ['ui.router']);
newsApp.config(function($stateProvider, $urlRouterProvider, $locationProvider) {

	// need to fix '#' in URL's 
	// $locationProvider.html5Mode({
	// 	enabled: true,
	// 	requireBase: false
	// });

	$urlRouterProvider.otherwise('/');

	$stateProvider.state('home',{
		url: '/',
		templateUrl: 'templates/main.html',
		controller: function($scope,$http){
			$scope.news = [];
			$http.get("http://localhost:8080/api/articles").success(function (data, status, headers, config) {
			    $scope.news = data._embedded.articles;
		    });
		}
	})
	.state('anycategory',{
		url: '/category/:categoryId',
		templateUrl: 'templates/main.html',
		controller: function($scope,$http,$stateParams){
			$scope.news = [];
			$scope.getingStatus = false;
			$http.get("http://localhost:8080/api/tags/"+$stateParams.categoryId+"/belongsToArticles").success(function (data, status, headers, config) {
			    $scope.news = data._embedded.articles;
			    $scope.getingStatus = true;
		    }).error(function () {
	 	    	$scope.getingStatus = false;
		    });
		}
	})
	.state('addnews',{
		url: '/addnews',
		templateUrl: 'templates/main.html',
		controller: function($scope,$http,$stateParams){
			$scope.news = [];
			$scope.getingStatus = false;
			$http.get("http://localhost:8080/api/tags/"+$stateParams.categoryId+"/belongsToArticles").success(function (data, status, headers, config) {
			    $scope.news = data._embedded.articles;
			    $scope.getingStatus = true;
		    }).error(function () {
	 	    	$scope.getingStatus = false;
		    });
		}
	})
	.state('full-article',{
		url: '/articles/:articleId',
		templateUrl: 'templates/full-article.html',
		controller: function($scope,$http,$stateParams){
			$scope.article = {};
			$scope.getingStatus = false;
			$http.get("http://localhost:8080/api/articles/"+$stateParams.articleId).success(function (data, status, headers, config) {
			    $scope.article = data;
			    $scope.getingStatus = true;
		    }).error(function () {
	 	    	$scope.getingStatus = false;
		    });
		}
	});

});