 <body >
 
 
 <p>Book List</p>
			<div class="container" ng-app="ContactApp" ng-controller="ContactCtrl as ctrl" >
			<form ng-submit="search()" >
     <input type="text" ng-model="searchparam.text"> 
    <input type="submit" value="Search">
  </form>
  
   <!--  <div  class="" ng-repeat="rack in sugession.racks"  ng-init="onloadFun()">
    	<a>{{rack.name}}</a>
    
    </div> -->
    
    <div ng-init="onloadFun()" >
    	<div ng-repeat="rack in racks">
    	<!-- <img src="/BookStoreWeb/resources/img/bookstore_1.jpg" alt="Mountain View" width="100" height="100"> -->
    	<img src={{rack.icon}} alt="Mountain View" width="100" height="100">
    		<a>{{rack.name}}</a>
    		</br>
    	</div>
        <a>{{sugession}}</a>
   	    <a>${sugession}</a>
    </div>

    <div>
    
    </div>
			
				
	</div>
</body>