angular.module('wiz.markdown')

.directive('wizMarkdown', ['$filter', 'wizMarkdownSvc', function ($filter, wizMarkdownSvc) {
	return {
		restrict: 'E',
		scope: {
			'content': '='
		},
		replace: true,
		template: '<div class="markdown-output"></div>',
		link: function (scope, elem, attrs) {
			scope.$watch('content', function () {
				if (!scope.content) {
					elem.html('');
					return;
				}
				elem.html(wizMarkdownSvc.Transform(scope.content));
				// Apply highlighting when required
				angular.forEach(elem.find('pre'), function (value) {
					hljs.highlightBlock(value);
				});
			});
		}
	};
}]);