angular.module('wiz.markdown')

.directive('wizToolbarButton', function () {
	return {
		require: '^wizMarkdownEditor',
		restrict: 'E',
		replace: true,
		transclude: true,
		scope: {
			'buttonclass':'@?'
		},
		template: '<button class="{{buttonclass}}" type="button" ng-click="format()" ng-transclude></button>',
		link: function (scope, elem, attrs, wizMarkdownEditorCtrl) {
			if (attrs.command) {
				scope.format = function () {
					wizMarkdownEditorCtrl.editor.InvokeCommand(attrs.command);
				};
			} else {
				console.error('wiz-toolbar-button requires a "command" attribute e.g: command="bold" ')
			}
		}
	};
});
