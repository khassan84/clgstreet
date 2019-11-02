<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>College Street</title>

    <!-- Bootstrap -->
    <link href="/BookStoreWeb/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/BookStoreWeb/resources/css/custom.css" rel="stylesheet">
	 <link rel="shortcut icon" href="/BookStoreWeb/resources/img/logo.png" type="image/png" />

	<!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>	 -->
		<script src="/BookStoreWeb/resources/angular/angular.js"></script>	
	<script src="/BookStoreWeb/resources/js/search2.js"/></script>
	<script src="/BookStoreWeb/resources/js/ui-bootstrap-tpls-2.5.0.min.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body ng-app="ContactApp" ng-controller="QuestionCtrl" >
    <br>
    
    <div class="row">
    
    <div class="col-md-3">
    <div class="img-circle">
        <img src="/BookStoreWeb/resources/img/logo.png" class="img-circle img-responsive"  style="height:60px;padding-left:15px;">
        <div class="caption">
          <p class="logotext">COLLEGE STREET</p>
        </div>
    </div>
    </div>
    
    
    <div class="col-xs-6 col-md-4 col-sm-3 col-md-offset-1 col-xs-offset-1">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search question paper, book" id="txtSearch" ng-model="searchText"/>
        <div class="input-group-btn">
          <button class="btn btn-primary" type="submit" ng-click="search(searchText)">
            <span class="glyphicon glyphicon-search"></span>
          </button>
        </div>
      </div>
    </div>
    
    <div class="col-xs-1 col-md-1 col-sm-1 col-md-offset-2 ">
    	<div><span class="glyphicon glyphicon-user " ></span></div>
    	<div data-toggle="modal" data-target="#myModal"><span>{{user}}</span></div>
    </div>	
    </div>
    
    
    
    <!-- for tab -->
    <div class="col-xs-2 col-md-2 col-sm-1"></div>
   
    <div class="col-xs-10 col-md-10 col-sm-11">
    
    	<div class="row">
    	
    	<div class="col-xs-12">
    	<!--  <div style="float:left;padding:10px;width:20%;height:80%;"><p>Left Add pane </p></div>  -->
    	<ul class="nav nav-tabs">
    		<li ><a href="#home" data-toggle="tab">Home</a>  </li>
    		<li><a href="#prepareQuestion" data-toggle="tab">Create Question Paper</a>  </li>
    	
    	</ul>
    	
    	<div class="tab-content" >
    		<div id="home" class="tab-pane active" >
    		<p> Home of Student </p>
    		
    		<!-- for reading paper -->
    		<div ng-if="readPaper">
    		<label>{{readPaper.assignmentName}}</label>
    		<div class="col-md-8 well" ng-repeat="q in rquestions">
    		 	<label class="col-md-12">Question : {{q.text}}	</label> 
    		 	<div class="col-md-6" ng-repeat="opt in q.options">
					 <input type={{q.answerType}}>{{opt.text}}</input>
				</div>
				<div class="col-md-12">
						<label for={{q}}>Answer: </label> 
						<div  id={{q}}>
							<div class="col-md-6"  ng-repeat="ans in q.answer">
							{{ans}}
						</div>
						</div>
						
				</div>
    		
    		</div>
    		
    		
    		
    		</div>
    		
    		<!-- end of reading paper -->    	
    		
    		<div class="col-md-8 well" ng-repeat="result in results" ng-click="getcontent(result.code)">
    		<h5>{{result.name}}</h5>   
    		<h6> Submited by : {{result.preparedBy}}	</h6>
    		<h6>  {{result.info}}		</h6>
    		<!-- <label class="col-md-8">{{result.info}}	</label>  -->
    		
    		
    		</div>
    		 </div>
    		 
    		 
    		 <!--  question paper tab body -->
    		 <div id="prepareQuestion" class="tab-pane">
    			<!-- start div -->
    			
    			<div class="container col-md-10"  >


				<!-- <div class="well container-fluid" data-spy="scroll" style="float:left;padding:10px;width:50%;"> -->
				<div class="well"  style="float:left;padding:10px;width:50%;">
				<div><span><b>  Assignment </b></span>
				<span class="pull-right"><input type="button" class="btn btn-primary" value="Save" ng-click="submitPaper()"></span>
				</div>
				<!-- <p><b>  Assignment </b></p> -->
				{{assignment}}
				</br>
				<p><b>Question List </b></p>
				<div style=" max-height:450px; overflow-y:scroll;">
					<div class="col-md-12 well" ng-repeat="question in questions">
					<label class="col-md-12">Question : {{question.text}}	</label> 
					<div class="col-md-6" ng-repeat="opt in question.options">
					 <input type={{question.answerType}}>{{opt.text}}
					</div>
					</br></br></br>
					<div class="col-md-12">
						<label for={{question}}>Answer: </label> 
						<div  id={{question}}>
							<div class="col-md-6"  ng-repeat="ans in question.answer">
							{{ans}}
						</div>
						</div>
						
					</div>
				</div>
				</div>
				
				</br>
				
				
				</div>

				<div class="well col-md-9"  style="float:left;padding:10px;width:50%;height:100%;min-height: 100%" ng-init="init()">
				<!-- <p> Assignment name</p> -->
				<form>
					<div class="form-group col-md-12">
								<label for="assignment" > Assignment name</label>
								<input type="text" id="assignment" class= "form-control input-sm" ng-model="assignment"/>
					</div>
					<div class="form-group col-md-12">
								<label  >Question</label>
								<input type="text" id="question"  class= "form-control input-sm" ng-model="tempquestion.text"/>
					</div>
					
					
					<div class="form-group form-horizontal col-md-12">
						<label for="option"> Answer</label>
					    <input  type="text" placeholder="Write answer option" class= "form-control input-sm" id="option" ng-model="ans" />
					    <button class="btn btn-primary pull-right" ng-click="addOption(ans)">Add Option</button>
					</div>
				
				
				</form>
				
				
				<!-- <label for="assignment"> Assignment name</label>
				<input type="text" id="assignment" ng-model="assignment"> -->
				<!-- <p> Write Question</p>
				<input type="text" ng-model="tempquestion.text"> -->
				<!-- <input type="button" style="" value="Create Question"  ng-click="search()"> -->
				<!-- <form ng-submit="search()" >
				     <input type="text" ng-model="ans"> 
				    <input type="button" class="btn btn-primary" value="Add OPtion" ng-click="addOption(ans)">
				  </form> -->
				  
				  <div >
				  <b>Answer Type</b>
				  </br>
				  <input type="radio" ng-model="answerType" value="radio"> Multiple choice with single correct answer
				  </br>
				  <input type="radio" ng-model="answerType" value="checkbox"> Multiple choice with multiple correct answer
				  </br>
				  <input type="radio" ng-model="answerType" value="text"> Descriptive answer
				  
				  </br></br>
				  
				  <b>Question</b></br>
				  {{tempquestion.text}} 
				  
				  </br>
				  <b>Answer</b></br>
				  <div ng-repeat="option in tempquestion.options">
					<div ng-if="answerType=='radio'"> <input  type={{answerType}} ng-model="tempquestion.choice" value ={{option.text}} >{{option.text}}</div>
				  	<div ng-if="answerType=='checkbox'"><input  type={{answerType}} ng-model="option.selected" ng-true-value ="1" ng-false-value="0" >{{option.text}}</div>
				    
				  </div>
				  <div class = "pull-right">
				  	<!-- <input type="button" class="btn btn-primary" value="Save Question" ng-click="submitPaper()"> -->
				  	<input type="button" class="btn btn-primary" value="Complete Question" ng-click="addToAssignment(tempquestion)">
				  	
				  </div>
				  </div>
				</div>
</div>
    			
    			<!--  end div -->
    			
    		 </div>
    	</div>
    	</div>
    </div>
    </div>
    
    <!-- modal test  -->
    
 <!--  <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Launch demo modal</button> -->
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>

                </button>
                 <h4 class="modal-title" id="myModalLabel">Modal title</h4>

            </div> -->
            <div class="modal-body">
                <div role="tabpanel">
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#loginTab" aria-controls="loginTab" role="tab" data-toggle="tab">Login</a>

                        </li>
                        <li role="presentation"><a href="#signUpTab" aria-controls="signUpTab" role="tab" data-toggle="tab">Signup</a>

                        </li>
                    </ul>
                    <!-- Tab panes -->
                    <div class="tab-content"  >
                        <div role="tabpanel" class="tab-pane active" id="loginTab">
                        
                        
                        <form>
							<div class="form-group">
								<label for="loginuserName"> User Name</label>
								<input class="form-control" placeholder="Login user name" type="text" id="loginuserName" ng-model="loginUser.userName" /> 
							</div>
							<div class="form-group">
								<label for="loginpassword"> Password</label>
								<input class="form-control" placeholder="Login Password" type="password" id="loginpassword" ng-model="loginUser.password"/> 
							</div>
							
						  
						  </form>
                        
                        
                        <button class="btn btn-primary "  ng-click="login(loginUser)">Login</button>
						<button class="btn btn-primary " data-dismiss="modal"  >Close</button>
                        
                        
                        </div>
                        <div role="tabpanel" class="tab-pane" id="signUpTab">
                        	<form>
							<div class="form-group">
								<label for="createUserName">User Name</label>
								<input class="form-control" placeholder="Unique User name" type="text" ng-model="createuser.userName" id="createUserName" />
							</div>
							<div class="form-group">
								<label for="firstName">First Name</label>
								<input class="form-control" placeholder="First name" type="text" id="firstName" ng-model="createuser.firstName"/>
							</div>
							<div class="form-group">
								<label for="lastName">Last Name</label>
								<input class="form-control" placeholder="Last name" type="text" id="lastName" ng-model="createuser.lastName"/>
							</div>
							<div class="form-group">
								<label for="phoneNumber">Phone Number</label>
								<input class="form-control" placeholder="Phone Number" pattern="[0-9]{10}" restrict-input="{type: 'digitsOnly'}"   type="phone" id="phoneNumber"  ng-model="createuser.phoneNumber"/>
								<!-- <input class="form-control" placeholder="Phone Number" pattern="[0-9]{10}"    ng-keypress="isNumberKey(this)" type="phone" id="phoneNumber"  ng-model="createuser.phoneNumber"/> -->
							</div>
							<div class="form-group">
								<label for="phoneNumber">Email</label>
								<input class="form-control" placeholder="Email" type="text" id="email"  ng-model="createuser.email"/>
							</div>
							
							<div class="form-group">
								<label for="password">Password</label>
								<input class="form-control" placeholder="Create Login password" type="password" id="password"  ng-model="createuser.password"/>
							</div>
							<div class="form-group">
								<label for="retypePassword">Retype Password</label>
								<input class="form-control" placeholder="Retype password" type="password" id="retypePassword"  ng-model="createuser.retypePassword"/>
							</div>
							</form>
							<button class="btn btn-primary " ng-click="createUser(createuser)">Create User</button>
							<button class="btn btn-primary " data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- <div class="modal-footer">
               
            </div> -->
        </div>
    </div>
</div>

<!--  modal test end -->
  
    

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/BookStoreWeb/resources/bootstrap/js/bootstrap.min.js"></script>
     <!-- <script src="/BookStoreWeb/resources/js/search2.js"/></script> -->
  </body>
</html>