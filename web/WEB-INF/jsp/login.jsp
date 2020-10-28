<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE HTML>
<html>
<head>
<title>登录页面</title>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/css/style.css"
	type=text/css rel=stylesheet>
<link href="${pageContext.request.contextPath}/css/boot-crm.css"
	type=text/css rel=stylesheet>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>

<script>
	// 判断是登录账号和密码是否为空
	function check() {
		var username = $("#username").val();
		var password = $("#password").val();
		if (username == "" || password == "") {
			$("#message").text("学生或密码不能为空！");
			return false;
		}
		return true;
	}
	
	/**
	 *刷新验证码
	 */
	 
</script>
 <script type="text/javascript">
	$(function(){
		$("#img").click(function(){
			this.src="yzmImage.action?ts="+new Date().getTime();

		})
	
	
	
	
	})
 </script>
  <script type="text/javascript">
	$(function(){
		$("#img").click(function(){
			this.src="yzmImage.action?ts="+new Date().getTime();

		})
	
	
	
	
	})
 </script>
<style>
 body{
  	background-repeat:no-repeat;
  	  background-image: url(images/1.jpeg );
  	  background-size: 100vw 100vh;  
  position:relative;
  left:350px;
  top:200px;
  
  }   
 </style>
  </head>
</head>
<body>
	<div ALIGN="center" background="red">
		<table border="0" width="80%" height="100%" 
			id="table1">
			<tr>
				<td height="100%"></td>
				<td></td>
			</tr>
			<tr>
				<td class="login_msg" width="700" align="center">
					<!-- margin:0px auto; 控制当前标签居中 -->
					<fieldset style="width: auto; margin: 0px auto;">
						<legend>	
							<font style="font-size:15px" face="宋体"> 欢迎使用教务管理系统 </font>
						</legend>
						<font color="red"> <%-- 提示信息--%> <span id="message">${msg}</span>
						</font>
						<%-- 提交后的位置：/WEB-INF/jsp/customer.jsp--%>
						<form action="${pageContext.request.contextPath }/login.action"
							method="post" onsubmit="return check()">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />
							<br />教&nbsp;师：<input id="username" type="text" name="username" /><br />
							<br /> 密&nbsp;码：<input id="password" type="password"
								name="password" /> <br />
			   <!-- 验证码输入区 -->					
						          &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
						       验证码：<input type="text" id="checkCode" size="20"  name="yzm" />
						        <span class="text_cray1"><img src="yzmImage.action" id="img"/></span>
							<center>
								<input type="submit" value="登录" />
							<input type="button" value="注册" onclick="window.location.href='register.jsp'"/>
							</center>
						</form>
					</fieldset>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
