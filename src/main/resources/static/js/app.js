var newsApp = angular.module('newsApp', ['ui.router']);
newsApp.config(function($stateProvider, $urlRouterProvider, $locationProvider) {

	// need to fix # in URL's 
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
	});
	// Не забудь удалить простыню 
	// .state('sport',{
	// 	url: '/sport',
	// 	templateUrl: 'templates/main.html',
	// 	controller: function($scope,$http){
	// 		$scope.news = [];
	// 		$http.get("http://localhost:8080/api/tags/sport/belongsToArticles").success(function (data, status, headers, config) {
	// 		    $scope.news = data._embedded.articles;
	// 	    });
	// 	}
	// })
	// .state('culture',{
	// 	url: '/culture',
	// 	templateUrl: 'templates/main.html',
	// 	controller: function($scope,$http){
	// 		$scope.news = [];
	// 		$scope.getingStatus = false;
	// 		$http.get("http://localhost:8080/api/tags/memes/belongsToArticles").success(function (data, status, headers, config) {
	// 		    $scope.news = data._embedded.articles;
	// 		    $scope.getingStatus = true;
	// 	    }).error(function () {
	// 	    	$scope.getingStatus = false;
	// 	    });
	// 	}
	// })
	// .state('society',{
	// 	url: '/society',
	// 	templateUrl: 'templates/main.html',
	// 	controller: function($scope,$http){
	// 		$scope.news = [];
	// 		$http.get("http://localhost:8080/api/tags/society/belongsToArticles").success(function (data, status, headers, config) {
	// 		    $scope.news = data._embedded.articles;
	// 	    });
	// 	}
	// })
	// .state('policy',{
	// 	url: '/policy',
	// 	templateUrl: 'templates/main.html',
	// 	controller: function($scope,$http){
	// 		$scope.news = [];
	// 		$http.get("http://localhost:8080/api/tags/policy/belongsToArticles").success(function (data, status, headers, config) {
	// 		    $scope.news = data._embedded.articles;
	// 	    });
	// 	}
	// })
	// .state('economy',{
	// 	url: '/economy',
	// 	templateUrl: 'templates/main.html',
	// 	controller: function($scope,$http){
	// 		$scope.news = [];
	// 		$http.get("http://localhost:8080/api/tags/economy/belongsToArticles").success(function (data, status, headers, config) {
	// 		    $scope.news = data._embedded.articles;
	// 	    });
	// 	}
	// })
	// .state('other',{
	// 	url: '/other',
	// 	templateUrl: 'templates/main.html',
	// 	controller: function($scope,$http){
	// 		$scope.news = [];
	// 		$http.get("http://localhost:8080/api/tags/wow/belongsToArticles").success(function (data, status, headers, config) {
	// 		    $scope.news = data._embedded.articles;
	// 	    });
	// 	}
	// })
	// .state('addnews',{
	// 	url: '/addnews',
	// 	templateUrl: 'templates/main.html',
	// 	controller: function($scope,$http){
	// 		$scope.news = [];
	// 		$http.get("http://localhost:8080/api/tags/wow/belongsToArticles").success(function (data, status, headers, config) {
	// 		    $scope.news = data._embedded.articles;
	// 	    });
	// 	}
	// });


});