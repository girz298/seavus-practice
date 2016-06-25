angular.module('wiz.markdown')

.filter('wizMarkdownFltr', ['wizMarkdownSvc', function (wizMarkdownSvc) {
	return function (input) {
		if (input) return wizMarkdownSvc.Transform(input);
	};
}]);