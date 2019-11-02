<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
"http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title><tiles:insertAttribute name="title" ignore="true" /></title>  
<div><tiles:insertAttribute name="header" /></div>  

<!-- <style>
    body {
        height: 100%;
        margin: 0;
        padding: 0;
        background-color: #FFCC00;
    }
  </style> -->

</head>  
<body  >  
        
        <div style="float:left;padding:10px;width:20%;height:80%;"><tiles:insertAttribute name="leftAddPane" /></div>  
        <div style="float:left;padding:10px;width:60%;height:80%;border-left:1px solid black;border-right:1px solid black;"><tiles:insertAttribute name="body" /></div>  
        <div style="float:left;padding:10px;width:20%;height:80%;"><tiles:insertAttribute name="rightAddPane" /></div>
        <div style="float:none;clear:both;height: 20%;"><tiles:insertAttribute name="footer" /></div>  
  
</body>  
</html>  