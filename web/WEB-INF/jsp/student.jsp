<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  

    
    
<%@page import="java.net.URLEncoder" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() 
	                   + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>学生管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
      <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function check() {
	var name=document.getElementById("name").value;
	var file=document.getElementById("file").value;
	if(name==""){
	alert("填写上传人");
	return false;
	}
	if(file.length==0||file==""){
	return false;
	}
	return true;
	
	}

    <c:forEach var="b" items="${imgList}">
    <img src="http://localhost:8080/student/${b.img}">
        </c:forEach>

        /**
* 页面初始化时加载列表，从第一页开始
*/
$(document).ready(function(){ 

	//加载列表
    searchStudent();
}); 

/**
*  实现分页功能,页面数据加载
*/
function searchStudent(currentPage){

	var stu_name=$("#stu_name").val();

	$.ajax({  
        url: "${pageContext.request.contextPath}/student/studentQuery.action",  
        type: "post",  
        //dataType:"json", 
        data : {"stu_name":stu_name,"currentPage":currentPage},
        
		//数据加载成功调用的方法  sucess()
		success: function(data)
		{
			//这里写数据加载成功后，会执行的代码
			$("#studentList").html(data);
			
		},   
	    
		//数据加载错误后调用的方法 error()
		error: function(data)
		{
			 $("#studentList").html("数据加载失败！");
		}
    });    
}

 
</script>

</head>


<body>
			<p>
				<a href="#">
				               教师姓名：${USER_SESSION.user_name}
				    </a>
				</p>
				<p>
					<a href="${pageContext.request.contextPath }/logout.action">
					退出登录
					</a>
				</p>
				
	<h3>查询结果信息</h3> 
 			 <table border="1" class="table table-condensed">
  <tr align="center" class="success">
  <td>编号</td>
  <td>学号</td>
  <td>学生</td>
  <td>职业</td>
  <td>电话</td>
  <td>课程</td>
  </tr> 
  <tr align="center"   class="warning">
  <td>${student.stu_id}</td>
  <td>${student.stu_number}</td>
  <td>${student.stu_name}</td>
  <td>${student.stu_jobs}</td>
  <td>${student.stu_phone}</td>
  <td>${student.stu_course}</td>
  </tr>
  </table>
  
  <br><br>
		<div id="studentList"></div>



</body>
</html>


