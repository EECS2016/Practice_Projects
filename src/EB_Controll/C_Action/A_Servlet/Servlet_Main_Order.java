package EB_Controll.C_Action.A_Servlet;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import EB_Model.M_Service.ServiceImp.*;
import EB_Model.M_Service.ServiceInt.*;
import EB_Model.M_Entity.*;
//
public class Servlet_Main_Order extends HttpServlet{
	//
	private static final long serialVersionUID=1L;
	
	//
 private SInt_Main_Order main_order=new SImp_Main_Order();
 
 //
 @Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		doPost(request,response);
	}
	
 //
 @Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String opOrder= request.getParameter("opOrder");
		if(null==opOrder){
			doFindOrder(request,response);
		}else{
			switch (opOrder) {
				case "toAddOrder":toAddOrder(request,response);break;
				case "doAddOrder":doAddOrder(request, response);break;
				case "toDelOrder":toDelOrder(request, response);break;			
				case "doDelOrder":doDelOrder(request, response);break;
				case "toModifyOrder":toModifyOrder(request, response);break;
				case "doModifyOrder":doModifyOrder(request, response);break;	
				case "doFindOrderOrder":doFindOrder(request,response);break;
				default:doFindOrder(request,response);break;
			}
		}	
	}
	
	//
 @Override
	public void destroy() {
		System.out.println("Servlet销毁：Servlet_Main_Order");
	}
 
 public void doFindOrder(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		//获取当前页
		String currentPage=request.getParameter("currentPage");
		int currPage=0;
		if(null==currentPage){
			//第一次访问时即第一页
			currPage=1;
		}else{
			//第二次或后面访问钧为页面传出的值
			currPage=Integer.parseInt(currentPage);
		}				
		//每页显示的非零记录个数（	取4个）
		int pageSize=4;				
  ArrayList<E_Order> listO=main_order.findOrderByPage(currPage, pageSize);
		int total=main_order.findOrderRowsNum();
		//求总页数
		int totalPage=(total%pageSize==0)?(total/pageSize):(total/pageSize+1);
		//上一页
		int prePage=0;
		if(currPage==1){
			//当前页就是首页，上一页与当前页相等
			prePage=currPage;
		}else{
			prePage=currPage-1;
		}
		//下一页
		int nextPage=0;
		if(currPage==totalPage){
			//当前页是尾页，下一页就是尾页
			nextPage=totalPage;
		}else{
			nextPage=currPage+1;
		}	
		request.setAttribute("pageSize",pageSize);
		request.setAttribute("total", total);
  request.setAttribute("listO",listO);
		request.setAttribute("currentPage", currPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("prePage", prePage);
		request.setAttribute("nextPage", nextPage);
  request.getRequestDispatcher("/WEB-INF/EB_View/V_BackEnd/BackEnd_Entity/BE_Order.jsp").forward(request, response);
 }
 
 public void toAddOrder(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		request.getRequestDispatcher("/WEB-INF/EB_View/V_BackEnd/BackEnd_Entity/BE_AddOrder.jsp").forward(request, response);
 }
 
 public void doAddOrder(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
 	int oID=main_order.findOrderRowsNum()+1;
		String uID=request.getParameter("uID");
		String uName=request.getParameter("uName");	
		String uAddress=request.getParameter("uAddress");	
		Date oCreateTime=new Date();
		String oCost=request.getParameter("oCost");
		String oStatus=request.getParameter("oStatus");	
		E_Order order=new E_Order(oID,uID,uName,uAddress,oCreateTime,Float.parseFloat(oCost),Integer.parseInt(oStatus));	
		int result=main_order.addOrder(order);	
		if(result>0){
			response.sendRedirect("Servlet_Main_Order");
		}else{
			response.sendRedirect("Servlet_Main_Order?opOrder=toAddOrder&oID="+oID);
		}
 }
 
 public void toDelOrder(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String oID=request.getParameter("oID");
		E_Order order=main_order.findOrderByOID(Integer.parseInt(oID));
		request.setAttribute("order",order);
 }
 
 public void doDelOrder(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
 	String oID=request.getParameter("oID");
		int result=main_order.delOrderByOID(Integer.parseInt(oID));	
		if(result>0){
			response.sendRedirect("Servlet_Main_Order");
		}else{
			response.sendRedirect("Servlet_Main_Order?opOrder=toDelOrder&oID="+oID);
		}
 }
 
 public void toModifyOrder(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String oID=request.getParameter("oID");
		E_Order order=main_order.findOrderByOID(Integer.parseInt(oID));
		request.setAttribute("order",order);
		request.getRequestDispatcher("/WEB-INF/EB_View/V_BackEnd/BackEnd_Entity/BE_ModifyOrder.jsp").forward(request, response);
 }
 
 public void doModifyOrder(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
 	String oID=request.getParameter("oID");
		E_Order order=main_order.findOrderByOID(Integer.parseInt(oID));	
		String uID=request.getParameter("uID");
		String uName=request.getParameter("uName");	
		String uAddress=request.getParameter("uAddress");	
		Date oCreateTime=new Date();
		String oCost=request.getParameter("oCost");
		String oStatus=request.getParameter("oStatus");	
		order.setUID(uID);
		order.setUName(uName);
		order.setUAddress(uAddress);
		order.setOCreateTime(oCreateTime);
		order.setOCost(Float.parseFloat(oCost));
		order.setOStatus(Integer.parseInt(oStatus));
		int result=main_order.updateOrder(order);	
		if(result>0){
			response.sendRedirect("Servlet_Main_Order");
		}else{
			response.sendRedirect("Servlet_Main_Order?opOrder=toModifyOrder&oID="+oID);
		}
 }
}