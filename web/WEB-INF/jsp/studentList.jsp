<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://itheima.com/mytag" prefix="page" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() 
	                   + ":" + request.getServerPort() + path + "/";
%>

                	<!--id查詢  -->
                	<form action="${pageContext.request.contextPath }/student/findStudentById.action" method="post">
                	<table>
                	<tr>
                	<td>查询编号:</td>
                	<td><input type="text"name="stu_id"/></td>
                	<td><input type="submit" value="查询"/></td>
                	</tr>
                	</table>
                	</form>
                		<!--学号查詢  -->
                	<form action="${pageContext.request.contextPath }/student/findStudentByNumber.action" method="post">
                	<table>
                	<tr>
                	<td>查询学号:</td>
                	<td><input type="text"name="stu_number"/></td>
                	<td><input type="submit" value="查询"/></td>
                	</tr>
                	</table>
                	</form>
                	<br><br>
                	
                	
                	
        		<!--上传 与下载  -->
        	
                <form action="${pageContext.request.contextPath }/student/importFile.action"
		method="post" enctype="multipart/form-data" onsubmit="return check()">
                	<table>
                	<tr>
                	<td>上&nbsp;&nbsp;传&nbsp;人:
                	<input id="name" type="text" name="name"/></td>
                	<!-- multiple="multiple"html5多文件上传属性  -->
                	</tr>
                	<tr>
                	<td><input id="file" type="file" name="uploadStudentfile" multiple="multiple"/></td>
                	</tr>
                	<tr>
                	<td><input type="submit" value="上传"/>
                	<a href="${pageContext.request.contextPath }/student/template.action">
                	<input  type="button" value="下载"></button>
                	</a>
                	</td> 
                	</tr>
                	<tr>
                	
                	</tr>
                	</table>
                	</form>
                	
                	<br><br>
        <!--添加  -->
     	<a class="btn btn-success" href="" data-toggle="modal" data-target="#studentadd">添加</a>
                	
    <table  class="table table-bordered table-striped">
    
		<tr class="success">
			
			     <td>编号</td>
 				 <td>学号</td>
 				 <td>学生</td>
  				 <td>职业</td>
                 <td>电话</td>
                 <td>课程</td>
                 <td>操作</td>
		</tr>
		<c:forEach items="${page.pageList}" var="student">
			<tr class="warning">
				  <td>${student.stu_id}</td>
				  <td>${student.stu_number}</td>
				  <td>${student.stu_name}</td>
				  <td>${student.stu_jobs}</td>
				  <td>${student.stu_phone}</td>
				  <td>${student.stu_course}</td>
				  <td>
				  <!--修改 -->
                	<a class="btn btn-primary" href="" data-toggle="modal" data-target="#studentEditDialog">修改</a>
                	<!--删除  -->
                    <a class="btn btn-danger" 
                    href="#" 
                    onclick="myFunction(${student.stu_id})" value="确认删除"  >删除</a>
</td>
			</tr>
		</c:forEach>
		<tr>
		<td colspan="7">
			<page:mytag currentPage="${page.currentPage}" totalPage="${page.totalPage}"></page:mytag> 
			
			
			</td>
		</tr>
	
	</table>	
	

	<c:forEach items="${page.pageList}" var="student">
 <!-- Modal 修改客户模态框 -->
     <div class="modal fade" id="studentEditDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  	<div class="modal-dialog" role="document">
    <div class="modal-content">
    <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h3 class="modal-title" id="myModalLabel">修改客户信息</h3>
    </div>
     <form action="${pageContext.request.contextPath }/student/updateStudent.action" method="post">
    <div class="modal-body">
        更新编号：<input type="text"name="stu_id" value="${student.stu_id}"/>
    </div>
     <div class="modal-body">
    更新学号：<input type="text"name="stu_number" value="${student.stu_number}"/>
    </div>
     <div class="modal-body">
    更新学生：<input type="text"name="stu_name" value="${student.stu_name}"/>
      </div>
     <div class="modal-body">
    更新职业：<input type="text"name="stu_jobs" value="${student.stu_jobs}"/>
      </div>
     <div class="modal-body">
    更新电话：<input type="text"name="stu_phone" value="${student.stu_phone}"/>
      </div>
     <div class="modal-body">
    更新课程：<input type="text"name="stu_course" value="${student.stu_course}"/>
    </div>

    <div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
    <button type="submit" class="btn btn-primary">修改</button>
    </div>
    </form>

    </div>
  </div></div>
  </c:forEach>
     <!--Modal 模态框 end 结束  -->
     
     <!-- Modal 添加学生模态框 -->
     <div class="modal fade" id="studentadd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  	<div class="modal-dialog" role="document">
    <div class="modal-content">
    <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h3 class="modal-title" id="myModalLabel">添加客户信息</h3>
    </div>
     <form action="${pageContext.request.contextPath }/student/addStudent.action" method="post">
    <div class="modal-body">
        编号：<input type="text"name="stu_id"/>
    </div>
     <div class="modal-body">
   学号：<input type="text"name="stu_number"/>
    </div>
     <div class="modal-body">
    学生：<input type="text"name="stu_name"/>
     </div>
     <div class="modal-body">
    职业：<input type="text"name="stu_jobs"/>
      </div>
     <div class="modal-body">
    电话：<input type="text"name="stu_phone"/>
      </div>
     <div class="modal-body">
    课程：<input type="text"name="stu_course"/>
    </div>

    <div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
    <button type="submit" class="btn btn-primary">添加</button>
    </div>
    </form>

    </div>
  </div></div>
     <!--Modal 模态框 end 结束  -->
	<!--通过Id删除数据  -->
	<script type="text/javascript">
function myFunction(id) {
	    if(confirm('确实要删除该客户吗?')) {
	$.post("<%=basePath%>student/deleteStudent.action",{"stu_id":id},
	function(data){
	            if(data !="OK"){
	                alert("客户删除成功！");
	                window.location.reload();
	            }else{
	                alert("删除客户失败！");
	                window.location.reload();
	            }
	        });
	    }
	}
</script>
		
	
	
