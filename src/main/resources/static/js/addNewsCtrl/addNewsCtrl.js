newsApp.controller('addNewsCtrl', ['$scope','$http','$stateParams','wizMarkdownSvc', function($scope,$http,$stateParams,wizMarkdownSvc){
		$scope.header = "Заголовок статьи";
		$scope.text = "Краткая информация о ней";
		$scope.url = "";

		$scope.sendBtnListener = function(){
			console.log($scope.mdDirective);
			console.log(wizMarkdownSvc.Transform($scope.mdDirective));
			$http.post('/api/articles', {'header':$scope.header,'text':wizMarkdownSvc.Transform($scope.mdDirective),
				'lastEditedOn': new Date().getTime()/1000,'textPreview':$scope.text,'previewImageURL':$scope.url});
		}



		/* Drag'n drop stuff */
		window.ondragover = function(e) {e.preventDefault()}
		document.getElementsByClassName("image-left")[0].ondrop = function(e) {e.preventDefault(); $scope.dropListener(e.dataTransfer.files[0]); }
		$scope.dropListener = function(file) {

		    /* Is the file an image? */
		    if (!file || !file.type.match(/image.*/)) return;

		    /* It is! */
		    document.body.className = "uploading";

		    /* Lets build a FormData object*/
		    var fd = new FormData(); // I wrote about it: https://hacks.mozilla.org/2011/01/how-to-develop-a-html5-image-uploader/
		    fd.append("image", file); // Append the file
		    var xhr = new XMLHttpRequest(); // Create the XHR (Cross-Domain XHR FTW!!!) Thank you sooooo much imgur.com
		    xhr.open("POST", "https://api.imgur.com/3/image.json"); // Boooom!
		    xhr.onload = function() {
		        // Big win!
		        document.querySelector("#link").src = JSON.parse(xhr.responseText).data.link;
		        $scope.url = JSON.parse(xhr.responseText).data.link;

		    }
		    
		    xhr.setRequestHeader('Authorization', 'Client-ID 28aaa2e823b03b1'); // Get your own key http://api.imgur.com/
		    
		    // Ok, I don't handle the errors. An exercise for the reader.

		    /* And now, we send the formdata */
		    xhr.send(fd);
		}

	}]);