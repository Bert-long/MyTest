<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>关于-BMW汽车订购系统</title>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<link rel="stylesheet" href="../css/bootstrap.res.css"/>
<link rel="stylesheet" href="../css/base.css"/>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container"> <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </a> <a class="brand" href="#">BMW汽车订购系统</a>
      <div class="nav-collapse collapse">
        <ul class="nav">
          <li class="active"> <a href="../index/index.jsp"><i class="icon-home icon-white"></i>主页</a> </li>
          <li><a href="#dev">开发环境</a></li>
          <li><a href="#server">服务器信息</a></li>
          <li><a href="#sql">数据库信息</a></li>
          <li><a href="#tech">使用的技术</a></li>
          <li><a href="#sys">综合概述</a></li>
        </ul>
        <ul class="nav pull-right">
          <li class="divider-vertical"></li>
          <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">欢迎你,${user}<b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="#"><i class="icon-cog"></i>设置</a></li>
              <li><a href="#"><i class="icon-off"></i>登出</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </div>
</div>
<div class="container-fluid" id="main">
  <div class="row-fluid">
       <div class="span12"> 
    <section id="dev">
      <h3>开发环境</h3>
      <ul>
        <li>平台：Windows 10</li>
        <li>工具：Eclipse-Photon</li>
      </ul>
      </section>
      <section id="server">
      <h3>服务器信息</h3>
      <ul>
        <li>Web容器：Tomcat 9.0</li>
        <li>数据库：MySQL5.5</li>
        <li>环境：Java EE 1.8+JRE1.8</li>
      </ul>
      </section>
      <section id="sql">
      <h3>数据库信息</h3>
      <ul>
        <li>用户名：root</li>
        <li>密码：123456</li>
        <li>配置：使用数据连接池连接</li>
      </ul>
      </section>
       <section id="tech">
      <h3>使用的技术</h3>
      <ul>
        <li>HTML5+CSS3+jQuery Bootstrap框架</li>
        <li>MySQL5.5 </li>
        <li>Java EE 1.8+JRE1.8 开发设计</li>
      </ul>
      </section>
       <section id="sys">
      <h3>综合概述</h3>
      <ul>
        <li>
          <p>宝马4S店汽车订购系统使用javaEE开发，基于多种开原件构成，使用了五层MVC模式，用于4S店进行汽车订购中涉及到的，库存管理，订购统计，维修预约，客户信息管理等。方便了企业进行信息化管理。</p>
        </li>
        <li>
          <p>使用：Servlet，JSP，Filter，Listener，数据库连接池，JNDI，EL，JSTL，JavaMail, JDBC，I18N。页面使用JSP＋EL＋JSTL，在JSP页面中没有使用Java脚本代码。</p>
        </li>
      </ul>
      </section>
    </div>
  </div>
</div>
<jsp:include page="../index/bottom.jsp"></jsp:include>
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"> </script>
<script type="text/javascript" src="../js/bootstrap.min.js"> </script>
</body>
</html>
