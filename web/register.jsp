<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE HTML>

<html>
  <head>
  <style>
 body{
  	background-repeat:no-repeat;
  	  background-image: url(images/注册.jpg );
  	  background-size: 100vw 100vh;  
  position:relative;
  left:600px;
  top:300px;
  
  }   
 </style>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body> 
    <form action="${pageContext.request.contextPath }/user/register.action" method="post"/>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />
							<br />学&nbsp;生：<input id="user_name" type="text" name="user_name" /><br />
							<br /> 密&nbsp;码：<input id="user_password" type="text"
								name="user_password" /> <br />
							<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="submit" value="注册"  onclick="window.location.href='register.jsp'"/>
    </form>
  </body>
</html>
