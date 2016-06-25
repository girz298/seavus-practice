angular.module('wiz.markdown')

.factory('wizMarkdownSvc', [function () {
	var markdownSvc = new MarkdownDeep.Markdown();
	markdownSvc.ExtraMode = true;
	markdownSvc.SafeMode = false;
	markdownSvc.NewWindowForExternalLinks = true;
	markdownSvc.AutoHeadingIDs = true;
    markdownSvc.MarkdownDeepEditor = MarkdownDeepEditor;

	return markdownSvc;
}]);