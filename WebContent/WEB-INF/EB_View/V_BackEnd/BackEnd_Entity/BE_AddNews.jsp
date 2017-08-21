 <%@ page 
 language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
 import="java.util.*, EB_Model.M_Entity.*"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title>后台管理——新增新闻</title>
   <script type="text/jscript" src="${pageContext.request.contextPath}/EB_File/JS/JQuery_Frame/jquery-1.8.3.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/EB_File/JS/EB_Function.js"></script>
   <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/EB_File/CSS/EB_Style.css" />
 </head>
 <body>
  <div id="header" class="wrap">
   <div id="logo"><img src="${pageContext.request.contextPath}/EB_File/Image/logo.gif" /></div>
   <div class="help"><a href="Servlet_EasyBuy_MainPage">返回前台页面</a></div>
   <div class="navbar">
	<ul class="clearfix">
	 <li><a href="Servlet_BE_Main">首页</a></li>
	 <li><a href="Servlet_Main_User">用户</a></li>
	 <li><a href="Servlet_Main_Product">商品</a></li>
     <li><a href="Servlet_Main_Order">订单</a></li>
	 <li><a href="Servlet_Main_UserComment">留言</a></li>
	 <li class="current"><a href="Servlet_Main_News">新闻</a></li>
	</ul>
   </div>
  </div>



  <div id="childNav"><div class="welcome wrap">管理员pillys<div id="BEDate"></div></div></div>



  <div id="position" class="wrap">您现在的位置：<a href="Servlet_BE_Main">易买网</a> &gt; 管理后台</div>



  <div id="main" class="wrap">
   <div id="menu-mng" class="lefter">
	<div class="box">
	 <dl>
	  <dt>用户管理</dt>
	  <dd><a href="Servlet_Main_User">用户管理</a></dd>
	  <dt>商品信息</dt>
	  <dd>
	   <em><a href="Servlet_Main_ProductCategory?opProductCategory=toAddProductCategory">新增</a></em>
	   <a href="Servlet_Main_ProductCategory">分类管理</a>
	  </dd>
	  <dd>
	   <em><a href="Servlet_Main_Product?opProduct=toAddProduct">新增</a></em>
	   <a href="Servlet_Main_Product">商品管理</a>
	  </dd>
	  <dt>订单管理</dt>
	  <dd><a href="Servlet_Main_Order">订单管理</a></dd>
	   <dt>留言管理</dt>
	  <dd><a href="Servlet_Main_UserComment">留言管理</a></dd>
	  <dt>新闻管理</dt>
	  <dd>
	   <em><a href="Servlet_Main_News?opNews=toAddNews">新增</a></em>
	   <a href="Servlet_Main_News">新闻管理</a>
	  </dd>
	 </dl>
	</div>
   </div>


   <div class="main">
	<h2>添加新闻</h2>
	 <div class="manage">
	  <form id="newsAdd" method="post" action="Servlet_Main_News?opNews=doAddNews">
	   <table class="form">
	    <tr>
	     <td class="field">新闻标题：</td>
		 <td><input type="text" class="text" name="title" value="" /><span></span></td>
		</tr>
		<tr>
		 <td class="field">新闻内容：</td>
		 <td><textarea class="text" name="content"></textarea><span></span></td>
		</tr>
		<tr>
		 <td></td>
		 <td><label class="ui-blue"><input type="submit" name="submit" value="添加" /></label></td>
		</tr>
	   </table>
	  </form>
	 </div>
	</div>
   <div class="clear"></div>
  </div>
  
  
  
  <div id="footer">Copyright &copy; 2016 ZR All Rights Reserved. 沪ICP证1000001号</div>
 </body>
</html>