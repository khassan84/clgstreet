	var app = angular.module("ContactApp",['ui.bootstrap']);
	app.controller("ContactCtrl",function($scope, $http){
		$scope.searchparam = {};
		$scope.search = function () {
			alert('hi...');
			var config = {
				    params: $scope.searchparam
				}
			 $http.get('search', config).
			 then(function(response) {
		            var contacts = response.data;
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
		$scope.search = function () {
			alert('hi...');
			var config = {
				    params: $scope.searchparam
				}
		};
		
		
		$scope.addOption = function (data) {
			alert('hello...');
			var option = data;
			alert(option);
			alert($scope.tempquestion);
			alert($scope.tempquestion.options);
			$scope.tempquestion.options.push(option);
			alert(data);
		};
		
		$scope.init = function(){
			alert('hi');
			
			$scope.tempquestion = {};
			alert('temp question created');
			$scope.tempquestion.options = [];
			alert('object created ');
		}
		
		
	        });
	