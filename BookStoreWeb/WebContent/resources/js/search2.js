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
		
		$scope.results = {};
		
		$scope.search = function (text) {
			$scope.searchParam = {};
			$scope.searchParam.text = text;
			alert('Search..........'+text);
			$http.post('search', $scope.searchParam).
			then(function(response) {
				alert('return from search');
				$scope.results =response.data; 
			})
		};
		
		
		$scope.getcontent = function getcontent(code){
			alert('hi....'+code); // getcontent
			
			
			/*$http.post('search', $scope.searchParam).
			then(function(response) {
				alert('return from search');
				$scope.rquestions =response.data; 
			})*/
			$http.post('getcontent', code).
			then(function(response){
				console.log(response);
				alert(response.data);
				$scope.rquestions =response.data; 
				/*$scope.readPaper =response.data;
				$scope.rquestions = [];
				$scope.tempstr  ='[{"name":"WBCS prilim test paper","preparedBy":"khassan","code":6,"info":null,"age":null}'; ////'[{options="opt1"}, {options="opt2"}]' ; // response.data.paper; //'{options=[{text=o1}, {text=o2}, {text=o3}, {text=o4}], answerType=radio, answer=[o2], choice=o2, text=q1}';
				alert($scope.tempstr);
				$scope.rquestions ='[{"name":"WBCS prilim test paper","preparedBy":"khassan","code":6,"info":null,"age":null}'//  JSON.parse(JSON.stringify($scope.tempstr)); 
				alert($scope.rquestions);*/
			})
		}
		
		
		$scope.addOption = function (data) {
			
			if(!data){
				alert('Enter answer option');
				return;
			}
			var anstype =  $scope.answerType;
			var option = {};
			option.text = data;
			$scope.tempquestion.options.push(option);
			$scope.tempquestion.answerType = $scope.answerType;
			$scope.ans = null;
		};
		
		$scope.init = function(){
			
			$scope.readPaper =  {};
			
			$scope.tempquestion = {};
			$scope.tempquestion.options = [];
			$scope.tempquestion.answerType = {};
			$scope.questions =  [];
			$scope.answerType = 'radio';
			$scope.tempquestion.answerType = $scope.answerType;
			$scope.tempquestion.answer = [];
			$scope.tempquestion.choice='';
			$scope.user = "Login";
			$scope.loginUser = {};
 
		};
		
		$scope.addToAssignment = function(q){
			var anstype =  $scope.answerType;
			var t = $scope.tempquestion;
			if(anstype == 'radio'){
				var creatorchoice =  t.choice;
				t.answer.push(creatorchoice);
			}
			
			if(anstype == 'checkbox'){
				t.options.forEach(function (o) {
					if(o.selected =="1"){
						t.answer.push(o.text);
					}
				});
			}
			$scope.questions.push(t);
			$scope.tempquestion = {};
			$scope.tempquestion.answer = [];
			$scope.tempquestion.options = [];
		};
		
		$scope.submitPaper = function(){
			alert('submitPaper');
			var customQuestion = {};
			customQuestion.user = $scope.user;
			customQuestion.assignmentName = $scope.assignment;
			customQuestion.papaer=$scope.questions;
			
			/*if(!$scope.user || $scope.user=="Login"){
				alert('Please login');
				$('#myModal').modal('show');
			}*/
			var questionpaper = {};
			questionpaper.text = 'firstquestion';
			//$http.post('savequestionpaper2', $scope.questions);
			$http.post('savequestionpaper2', customQuestion);
		};
		
		$scope.createUser= function(data){
			alert('createUser');
			if(!data){
				alert('please fill data' );
			}
			if(!data.userName){
				alert('please fill user name' );
			}
			if(!data.email && !data.phoneNumber){
				alert('either email or phone number is mandatory')
			}
			
			if(!angular.equals(data.password, data.retypePassword)){
				alert('password confirmation mismatch');
			}
			$http.post('createuser', data).
			 then(function(response) {
				 var userResponse = response.data;
				 if(userResponse.responseCode == "O300"){
					 $scope.user=userResponse.userName;
					 alert($scope.user);
					 $('#myModal').modal('hide');
				 }
			 });
		};
		
		
		
		$scope.login= function(data){
			alert('login');
			$http.post('login', data).
			 then(function(response) {
				 var loginResponse = response.data;
				 if(loginResponse.responseCode =="L500"){
					 $scope.user=loginResponse.userName;
					 $('#myModal').modal('hide');
				 }else{
					 alert(loginResponse.responseDesc);
				 }
				 
				 
			 });
		};
		
		
		$scope.isNumberKey   = function(data)
	       {
			data = data.replace(/[^0-9]/g, '');
			/* var charCode = (evt.which) ? evt.which : evt.keyCode;
	          if (charCode != 46 && charCode > 31 
	            && (charCode < 48 || charCode > 57))
	             return false;

	          return true;*/
			
			return data;
	       };
	        });
	
	
	app.directive('restrictInput', function() {
		  return {
		    restrict: 'A',
		    require: 'ngModel',
		    link: function(scope, element, attr, ctrl) {
		      ctrl.$parsers.unshift(function(viewValue) {
		        var options = scope.$eval(attr.restrictInput);
		        var overrideValue;
		        if (!options.regex && options.type) {
		          switch (options.type) {
		            case 'digitsOnly': options.regex = '^[0-9]*$'; 
		            		//viewValue = viewValue.replace(/[^0-9]/g, '');
		            if (viewValue) {
	                    var transformedInput = viewValue.replace(/[^0-9]/g, '');

	                    if (transformedInput !== viewValue) {
	                    	ctrl.$setViewValue(transformedInput);
	                    	ctrl.$render();
	                    }
	                    return transformedInput;
	                }
	                return undefined;
		            break;
		            case 'lettersOnly': options.regex = '^[a-zA-Z]*$'; break;
		            case 'lowercaseLettersOnly': options.regex = '^[a-z]*$'; break;
		            case 'uppercaseLettersOnly': options.regex = '^[A-Z]*$'; break;
		            case 'lettersAndDigitsOnly': options.regex = '^[a-zA-Z0-9]*$'; break;
		            case 'validPhoneCharsOnly': options.regex = '^[0-9 ()/-]*$'; break;
		            default: options.regex = '';
		          }
		        }
		        var reg = new RegExp(options.regex);
		        if (reg.test(viewValue)) { //if valid view value, return it
		        	element.val(viewValue);
		          return viewValue;
		        } else { //if not valid view value, use the model value (or empty string if that's also invalid)
		           overrideValue = (reg.test(ctrl.$modelValue) ? ctrl.$modelValue : '');
		          element.val(overrideValue);
		          return overrideValue;
		        }
		      });
		    }
		  };
		});
	