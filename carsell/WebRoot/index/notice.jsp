<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公告</title>
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
          <li><a href="#dev">综合</a></li>
          <li><a href="#server">公告</a></li>
          <li><a href="#sql">活动</a></li>
          <li><a href="#tech">资讯</a></li>
          <li><a href="#sys">社区</a></li>
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
      <h3>综合</h3>
      <ul>
        <li>平台：Windows 7 SP1</li>
        <li>工具：Eclipse for Java EE3.7</li>
        <li>人员：杨健</li>
      </ul>
      </section>
      <section id="server">
      <h3>公告</h3>
      <ul>
        <li>Web容器：Tomcat 7.0</li>
        <li>数据库：MySQL5.5</li>
        <li>环境：Java EE 1.7+JRE1.7</li>
        <li>邮件服务器：163邮箱 用户名：nicejava 密码：javaee</li>
      </ul>
      </section>
      <section id="sql">
      <h3>活动</h3>
      <ul>
        <li>用户名：root</li>
        <li>密码：123</li>
        <li>配置：使用数据连接池连接哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈</li>
      <li>密码：123</li>
      <li>密码：123</li>
      <li>密码：123</li>
      <li>密码：123</li>
      <li>密码：123</li>
      </ul>
      </section>
       <section id="tech">
      <h3>资讯</h3>
      <ul>
        <li>HTML5+CSS3+jQuery Bootstrap框架，支持响应式设计，要求使用Chrome等高级浏览器访问</li>
        <li>MySQL5.5 开源小巧的数据库</li>
        <li>Java EE 1.7+JRE1.7 开发设计</li>
      </ul>
      </section>
       <section id="sys">
      <h3>社区</h3>
      <ul>
        <li>
          <p>宝马4S店汽车销售系统使用javaEE开发，基于多种开原件构成，使用了五层MVC模式，用于4S店进行汽车销售中涉及到的，库存管理，销售统计，维修预约，客户信息管理等。方便了企业进行信息化管理。</p>
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