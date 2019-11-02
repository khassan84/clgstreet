var app = angular.module("ContactApp",['ui.bootstrap']);
	app.controller("ContactCtrl",function($scope, $http){
		$scope.sugession = "finaly";
		$scope.onloadFun = function(data) {
			$scope.sugession = data;
			var config = {
				    params: $scope.searchparam
				}
			 $http.get('search2', config).
			 then(function(response) {
		            var sug = response.data;
		            $scope.racks = sug.racks;
		            });
			
			
			
		};
		$scope.searchparam = {};
		$scope.search = function () {
			$scope.sugession = "finaly resolved";
			alert($scope.searchparam.text);
			var config = {
				    params: $scope.searchparam
				}
			 $http.get('sugession', config).
			 then(function(response) {
		            var text = response.data;
		            $scope.contacts = contacts;
		            $scope.totalItems = contacts.length;
		            $scope.currentPage = 1;
		            $scope.itemsPerPage = 2;
		            $scope.$watch("currentPage", function() {
		                setPagingData($scope.currentPage);
		            	});
		            function setPagingData(page) {
		                var pagedData = contacts.slice(
		                  (page - 1) * $scope.itemsPerPage,
		                  page * $scope.itemsPerPage
		                );
		                $scope.sliceContacts = pagedData;
		              }
		            });
		}
		
		
	
	        });
	
	

	
	app.controller("QuestionCtrl",function($scope, $http){
		$scope.searchparam = {};
		$scope.addQuestion = function () {
			
			alert('hi...you are going to add question');
			
			
		}
		
		
	
	        });
