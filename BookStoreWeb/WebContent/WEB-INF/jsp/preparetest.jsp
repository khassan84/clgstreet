<div class="container" ng-app="ContactApp" ng-controller="QuestionCtrl" >


<div style="float:left;padding:10px;width:50%;border-right:1px solid black; min-height: 100%; overflow-y: auto;">
<p><b>  Assignment </b></p>
{{assignment}}
</br>
<p>Question List</p>
<div ng-repeat="question in questions">
quetion : {{question.text}}
	<div  ng-repeat="opt in question.options">
	 <input type={{question.answerType}}>{{opt.text}}
	</div>
	</br>
	Answer: 
	<div ng-repeat="ans in question.answer">
		{{ans}}
	</div>
	

</div>

</div>

<div style="float:left;padding:10px;width:50%;height:100%;border-left:1px solid black;min-height: 100%" ng-init="init()">
<p> Assignment name</p>
<input type="text" ng-model="assignment">
<p> Write Question</p>
<input type="text" ng-model="tempquestion.text">
<!-- <input type="button" style="" value="Create Question"  ng-click="search()"> -->
<form ng-submit="search()" >
     <input type="text" ng-model="ans"> 
    <input type="button" value="Add OPtion" ng-click="addOption(ans)">
  </form>
  
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
  <div >
  	<input type="button"  value="complete question" ng-click="addToAssignment(tempquestion)">
  </div>
 
 
  <input type="button"  value="save question" ng-click="submitPaper()">
  
  </div>
  
  
</div>

</div>