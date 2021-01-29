<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>公告信息管理</title>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<link rel="stylesheet" href="${path}/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${path}/css/bootstrap.res.css"/>
<link rel="stylesheet" href="${path}/css/base.css"/>
</head>
<body>

<jsp:include page="../index/top.jsp"></jsp:include>
<div class="container-fluid" id="main">
  <div class="row-fluid">
    <div class="span2"> 
      <jsp:include page="../index/left.jsp"></jsp:include>
    </div>
    <div class="span10"> 
     
      <h2>公告信息管理</h2>
      	<div class="span4">
			<a href="${path}/news/add.jsp" class="btn btn-primary">发布新公告</a>
		</div>
		<div class="span4">			
				<form class="form-search" action="${path}/news/search.do" method="post">
						<input type="text" class="input-medium search-query" name="newssearch"
								id="enginesearch" placeholder="主题名称">
						<button type="submit" class="btn btn-primary">搜索公告信息</button>
				</form>				
		</div>
<table class="table table-striped" width="100%">
<tr>
<strong><td>编号</td></strong>
<strong><td>主题</td></strong>
<strong><td>内容</td></strong>
<strong><td>发布用户</td></strong>
<strong><td>发布时间</td></strong>
<strong><td>操作</td></strong>
</tr>
<c:forEach var="emp" items="${carlist }">
<tr>
<td>${emp.carid}</td>
<td><img src="${emp.carpic}" width="120" height="90" class="img-rounded"></td>
<td>${emp.carname}</td>
<td>${emp.price}</td>
<td>${emp.stock}辆</td>
<td><a class="btn" href="delete.do?carid=${emp.carid}"><i class="icon-remove "></i>删除</a></td>
</tr>
</c:forEach>

</table>
      
    </div>
  </div>
</div>
<jsp:include page="../index/bottom.jsp"></jsp:include>
</body>
<script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js"> </script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"> </script>
<script>
 $(".xinwen").addClass("active");//选中的添加acrive
</script>
</html>