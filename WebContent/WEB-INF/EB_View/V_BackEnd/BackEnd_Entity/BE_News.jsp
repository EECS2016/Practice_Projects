<%--
 page指令导入所需的JavaBean（实体类等）和jar包


--%>
<%@ page 
 language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
 import="java.util.*, EB_Model.M_Entity.*"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title>后台管理——查看新闻</title>
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





   <%--针对缓存：测试小脚本<%=request.getAttribute("pageSize")%><br />${requestScope.total}<br />--%>
   
   <c:choose>
    <c:when test="${requestScope.total!=0}">
     <div class="main">
	  <h2>新闻管理</h2>
	  <div class="manage">
	   <table class="list">
        <tr>
	     <th>ID</th>
	     <th>新闻标题</th>
	     <th>操作</th>
	   </tr>	
	   <c:forEach items="${requestScope.listN}" var="news" varStatus="status">
	    <tr>
	     <td class="first w4 c">${status.index+1}</td>
	     <td>${news.NTitle}</td>
		 <td class="w1 c">
		  <a href="Servlet_Main_News?opNews=toModifyNews&nID=${news.NID}">修改</a> 
		  <a class="manageDel" href="Servlet_Main_News?opNews=doDelNews&nID=${news.NID}">删除</a>
	     </td>
	    </tr>  
       </c:forEach>    	
      </table>
     </div>
    </div>	  
   
    
    <div class="clear"></div>
    <div class="pager">
	 <ul class="clearfix">
	  <%--动态分页（每页有4条记录）--%>
	   <li><a href="Servlet_Main_News?currentPage=${requestScope.prePage}">上一页</a></li>
       <li><a href="Servlet_Main_News?currentPage=1">首页</a></li>     
       <c:choose>
	    <%--动态分页1：当前页码顺序前2，则不含首页链接和上一页链接--%>
	    <c:when test="${requestScope.currentPage<=2}">
	     <c:choose> 
	    <%--动态分页1.1：当前页码顺序前2，则不含首页链接和上一页链接（尾页码不大于3的情况归于此类；亦可归给“动态分页3”）--%>
	      <c:when test="${requestScope.totalPage<=3}">
	       <c:forEach var="pageNum" begin="1" end="${requestScope.totalPage}">
	        <c:choose> 
	         <c:when test="${requestScope.currentPage==pageNum}">
  	          <li class="current"><a href="Servlet_Main_News?currentPage=${pageNum}">${pageNum}</a></li>
  	        </c:when>
  	         <c:otherwise>
  	          <li><a href="Servlet_Main_News?currentPage=${pageNum}">${pageNum}</a></li>
  	         </c:otherwise>
            </c:choose>
  	       </c:forEach> 
  	      </c:when>   	      
  	      <%--动态分页1.2：当前页码顺序前2，则不含首页链接和上一页链接（尾页码大于3）--%>	     
  	      <c:otherwise>
  	       <c:forEach var="pageNum" begin="1" end="3">
	        <c:choose> 
	         <c:when test="${requestScope.currentPage==pageNum}">
  	          <li class="current"><a href="Servlet_Main_News?currentPage=${pageNum}">${pageNum}</a></li>
  	         </c:when>
  	         <c:otherwise>
  	          <li><a href="Servlet_Main_News?currentPage=${pageNum}">${pageNum}</a></li>
  	         </c:otherwise>
            </c:choose>
  	       </c:forEach> 
  	        <li><a href="Servlet_Main_News?currentPage=4">...</a></li>
  	      </c:otherwise>
	     </c:choose>  
	    </c:when>
	    	
   	    <%--动态分页2——3--%>	
	    <c:when test="${requestScope.currentPage>2&&requestScope.totalPage>3}">
	     <c:choose>       
  	      <%--动态分页2：尾页码必须大于4，当前页码处于顺序前2和倒序前2以外，可含上一页链接，首页链接，尾页链接和下一页链接--%>		
	      <c:when test="${requestScope.currentPage<=requestScope.totalPage-2}">
	       <li><a href="Servlet_Main_News?currentPage=${requestScope.currentPage-2}">...</a></li>	       	       	       	 
	  	   <li><a href="Servlet_Main_News?currentPage=${requestScope.currentPage-1}">${requestScope.currentPage-1}</a></li>  	  	  
	  	   <li class="current"><a href="Servlet_Main_News?currentPage=${requestScope.currentPage}">${requestScope.currentPage}</a></li>	  	       
	       <li><a href="Servlet_Main_News?currentPage=${requestScope.currentPage+1}">${requestScope.currentPage+1}</a></li> 		      	       	 	  	 	  	      
           <li><a href="Servlet_Main_News?currentPage=${requestScope.currentPage+2}">...</a></li>
	      </c:when>	      
	      <%--动态分页3：当前页码必须大于2且尾页码必须大于3，当前页码倒序前2，则不含尾页链接和下一页链接--%>	 	      
	     <c:otherwise>
	       <li><a href="Servlet_Main_News?currentPage=${requestScope.totalPage-3}">...</a></li>
  	       <c:forEach var="pageNum" begin="${requestScope.totalPage-2}" end="${requestScope.totalPage}">  
	        <c:choose> 
	         <c:when test="${requestScope.currentPage==pageNum}">
  	          <li class="current"><a href="Servlet_Main_News?currentPage=${pageNum}">${pageNum}</a></li>
  	         </c:when>
  	         <c:otherwise>
  	          <li><a href="Servlet_Main_News?currentPage=${pageNum}">${pageNum}</a></li>
  	         </c:otherwise> 
            </c:choose>
  	       </c:forEach> 
  	      </c:otherwise>    	        		      	      
  	     </c:choose>    	       	       	      	      	       
	   </c:when>
	  </c:choose>
      <li><a href="Servlet_Main_News?currentPage=${requestScope.totalPage}">尾页</a></li>
      <li><a href="Servlet_Main_News?currentPage=${requestScope.nextPage}">下一页</a></li>
 	 </ul>
     </div>
    </c:when>
 
 
    <c:otherwise>
	 <div class="main">
	 <h2>新闻管理</h2>
	  <div class="manage">
	   <table class="list">
        <tr>
	     <th>ID</th>
	     <th>新闻标题</th>
	     <th>操作</th>
	    </tr>	
       </table>
      </div>
     </div> 
	 <div class="clear"></div>
     <div class="pager">
   	  <ul class="clearfix">
	   <li><a href="Servlet_Main_News?currentPage=1">上一页</a></li>
       <li><a href="Servlet_Main_News?currentPage=1">首页</a></li>
       <li ><a href="Servlet_Main_News?currentPage=1">1</a></li>
       <li><a href="Servlet_Main_News?currentPage=1">尾页</a></li>
       <li><a href="Servlet_Main_News?currentPage=1">下一页</a></li>
 	  </ul>
     </div>   
	</c:otherwise>
   </c:choose> 
  </div>
  
  
  
  <div id="footer">Copyright &copy; 2016 ZR All Rights Reserved. 沪ICP证1000001号</div>
 </body>
</html>