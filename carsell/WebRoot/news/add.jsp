<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>发布新公告</title>
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
     
      <h2>发布公告</h2>
<form class="form-horizontal" action="add.do" method="post" enctype="multipart/form-data">
  <div class="control-group">
    <label class="control-label" for="inputtopic">主题</label>
    <div class="controls">
      <input type="text" class="input-xlarge" id="inputtopic" name="inputtopic" maxlength="80" required placeholder="主题内容">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputuser">发布用户</label>
    <div class="controls">
      <select name="inputuser" class="span5" width="80" required>
  <option>销售人员</option>
  <option>维修人员</option>
  <option>经理/管理员</option>
</select>
    </div>
  </div>
<div class="control-group">
    <label class="control-label" for="inputnews">内容</label>
    <div class="controls">
    <textarea rows="8" cols="50" class="input-xlarge" id="inputnews" name="inputnews" required placeholder="请输入要发布的公告内容"></textarea>
    </div>
 </div>
  <div class="form-actions">
      <button type="submit" class="btn btn-primary">添加</button>
       <a href="main.do" class="btn">取消</a>
  </div>
</form>
      
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