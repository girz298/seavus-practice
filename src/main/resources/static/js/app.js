var newsApp = angular.module('newsApp', ['ui.router','wiz.markdown','ngSanitize']);
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
			$scope.actualNews = [];
			$http.get("/api/articles").success(function (data, status, headers, config) {
			    $scope.news = data._embedded.articles.reverse();
			    $scope.actualNews = $scope.news.slice(0,6);
		    });

			$scope.toNormalDate = function(long){
				return long+"";
			}

		}
	})
	.state('anycategory',{
		url: '/category/:categoryId',
		templateUrl: 'templates/main.html',
		controller: function($scope,$http,$stateParams){
			$scope.news = [];
			$scope.getingStatus = false;
			$http.get("/api/tags/"+$stateParams.categoryId+"/belongsToArticles").success(function (data, status, headers, config) {
			    $scope.news = data._embedded.articles;
			    $scope.getingStatus = true;
		    }).error(function () {
	 	    	$scope.getingStatus = false;
		    });


		}
	})
	.state('addnews',{
		url: '/addnews',
		templateUrl: 'templates/add-news.html',
		controller: function($scope,$http,$stateParams,wizMarkdownSvc){
			$scope.sendBtnListener = function(){
				console.log($scope.mdDirective);
				console.log(wizMarkdownSvc.Transform($scope.mdDirective));
				$http.post('/api/articles', {'header':$scope.mdDirective.slice(1,45),'text':wizMarkdownSvc.Transform($scope.mdDirective),'lastEditedOn': new Date().getTime()/1000});
			}
		}
	})
	.state('full-article',{
		url: '/articles/:articleId',
		templateUrl: 'templates/full-article.html',
		controller: function($scope,$http,$sce,$stateParams){
			$scope.article = {};
			$scope.getingStatus = false;
			$http.get("/api/articles").success(function (data, status, headers, config) {
				$scope.news = data._embedded.articles.reverse();
				$scope.actualNews = $scope.news.slice(0,6);
			});
			$http.get("/api/articles/"+$stateParams.articleId).success(function (data, status, headers, config) {
			    $scope.article = data;
			    $scope.getingStatus = true;
		    }).error(function () {
	 	    	$scope.getingStatus = false;
		    });

		    $scope.deliberatelyTrustDangerousSnippet = function() {
		      return $sce.trustAsHtml($scope.article.text);
		    };
		}
	});

});