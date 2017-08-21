
<%@ page 
 language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
 import="java.util.*, EB_Model.M_Entity.*"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title>后台管理主页</title>
   <script type="text/jscript" src="${pageContext.request.contextPath}/EB_File/JS/JQuery_Frame/jquery-1.8.3.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/EB_File/JS/EB_Function.js"></script>
   <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/EB_File/CSS/EB_Style.css" />
 </head>
 <body>
  <div id="header" class="wrap">
   <div id="logo"><img src="${pageContext.request.contextPath}/EB_File/Image/logo.gif" /></div>
   <div class="help"><a href="${pageContext.request.contextPath}/EasyBuy_MainPage.jsp">返回前台页面</a></div>
   <div class="navbar">
	<ul class="clearfix">
	 <li  class="current"><a href="BE_Main.jsp">首页</a></li>
	 <li><a href="BE_User.jsp">用户</a></li>
	 <li><a href="BE_Product.jsp">商品</a></li>
     <li><a href="BE_Order.jsp">订单</a></li>
	 <li><a href="BE_UserComment.jsp">留言</a></li>
	 <li><a href="BE_News.jsp">新闻</a></li>
	</ul>
   </div>
  </div>



  <div id="childNav"><div class="welcome wrap">管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。</div></div>
  
  

  <div id="position" class="wrap">您现在的位置：<a href="BE_Main.jsp">易买网</a> &gt; 管理后台</div>



  <div id="main" class="wrap">
   <div id="menu-mng" class="lefter">
	<div class="box">
	 <dl>
	  <dt>用户管理</dt>
	  <dd><a href="BE_User.jsp">用户管理</a></dd>
	  <dt>商品信息</dt>
	  <dd>
	   <em><a href="BE_AddProductCategory.jsp">新增</a></em>
	   <a href="BE_ProductCategory.jsp">分类管理</a>
	  </dd>
	  <dd>
	   <em><a href="BE_AddProduct.jsp">新增</a></em>
	   <a href="BE_ProductCategory.jsp">商品管理</a>
	  </dd>
	  <dt>订单管理</dt>
	  <dd><a href="BE_Order_01.jsp">订单管理</a></dd>
	   <dt>留言管理</dt>
	  <dd><a href="BE_FUserComment.jsp">留言管理</a></dd>
	  <dt>新闻管理</dt>
	  <dd>
	   <em><a href="BE_AddNews.jsp">新增</a></em>
	   <a href="BE_News.jsp">新闻管理</a>
	  </dd>
	 </dl>
	</div>
   </div>


   <div class="main">
    <h2>管理首页</h2>
    <div id="welcome" class="manage">
	 <div class="shadow">
	  <em class="corner lb"></em>
	  <em class="corner rt"></em>
	  <div class="box">
	   <div class="msg">
	    <p>欢迎回来</p>
	   </div>
	  </div>
     </div>
    </div>
   </div>
  
  
   <div class="clear"></div>
  </div>



  <div id="footer">Copyright &copy; 2016 ZR All Rights Reserved. 沪ICP证1000001号</div>
 </body>
</html>