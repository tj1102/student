<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册结果页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
 body{
  	background-repeat:no-repeat;
  	  background-image: url(images/注册页面展示.jpg);
  	  background-size: 100vw 100vh;  
  position:relative;
  left:350px;
  top:200px;
  
  }   
 </style>
  </head>
  
  <body>
      <table border=1>
  <tr>
  </br>
  <td>学生</td>
  <td>密码</td>
  
  </tr> 
  <tr>
  <td>${user.user_name}</td>
  <td>${user.user_password}</td>
  
  </tr>
  </table>
  <a href="login.action"><input type="button"value="返回"></a>
  </body>
</html>
