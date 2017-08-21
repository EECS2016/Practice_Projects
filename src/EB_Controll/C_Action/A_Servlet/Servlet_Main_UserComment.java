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
public class Servlet_Main_UserComment extends HttpServlet{
	//
	private static final long serialVersionUID=1L;
	
	//
 private SInt_Main_UserComment main_userComment=new SImp_Main_UserComment();
 
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
		String opOrderDetail= request.getParameter("opOrder");
		if(null==opOrderDetail){
			doFindOrderDetail(request,response);
		}else{
			switch (opOrderDetail) {
				case "toAddOrderDetail":toAddOrderDetail(request,response);break;
				case "doAddOrderDetail":doAddOrderDetail(request, response);break;
				case "toDelOrderDetail":toDelOrderDetail(request, response);break;			
				case "doDelOrderDetail":doDelOrderDetail(request, response);break;
				case "toModifyOrderDetail":toModifyOrderDetail(request, response);break;
				case "doModifyOrderDetail":doModifyOrderDetail(request, response);break;	
				case "doFindOrderOrderDetail":doFindOrderDetail(request,response);break;
				default:doFindOrderDetail(request,response);break;
			}
		}	
	}
	
	//
 @Override
	public void destroy() {
		System.out.println("Servlet销毁：Servlet_Main_OrderDetail");
	}
 
 public void doFindOrderDetail(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
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
  ArrayList<E_OrderDetail> listOD=main_orderdetail.findOrderDetailByPage(currPage, pageSize);
		int total=main_orderdetail.findOrderDetailRowsNum();
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
  request.setAttribute("listOD",listOD);
		request.setAttribute("currentPage", currPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("prePage", prePage);
		request.setAttribute("nextPage", nextPage);
  request.getRequestDispatcher("/WEB-INF/EB_View/V_BackEnd/BackEnd_Entity/BE_OrderDetail.jsp").forward(request, response);
 }
 
 public void toAddOrderDetail(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String odID=request.getParameter("odID");
		E_OrderDetail orderdetail=main_orderdetail.findOrderDetailByODID(Integer.parseInt(odID));
		request.setAttribute("orderdetail",orderdetail);
		request.getRequestDispatcher("/WEB-INF/EB_View/V_BackEnd/BackEnd_Entity/BE_AddOrderDetail.jsp").forward(request, response);
 }
 
 public void doAddOrderDetail(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
 	int odID=main_orderdetail.findOrderDetailRowsNum()+1;
		String oID=request.getParameter("oID");
		String pID=request.getParameter("pID");	
		String odPQuantity=request.getParameter("odPQuantity");	
		String oCost=request.getParameter("oCost");
		E_OrderDetail orderdetail=new E_OrderDetail(odID,Integer.parseInt(oID),Integer.parseInt(pID)
	                               		,Integer.parseInt(odPQuantity),Float.parseFloat(oCost));	
		int result=main_orderdetail.addOrderDetail(orderdetail);	
		if(result>0){
			response.sendRedirect("Servlet_Main_OrderDetail");
		}else{
			response.sendRedirect("Servlet_Main_OrderDetail?opOrder=toAddOrderDetail&odID="+odID);
		}
 }
 
 public void toDelOrderDetail(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String odID=request.getParameter("odID");
		E_OrderDetail orderdetail=main_orderdetail.findOrderDetailByODID(Integer.parseInt(odID));
		request.setAttribute("orderdetail",orderdetail);
 }
 
 public void doDelOrderDetail(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
 	String odID=request.getParameter("odID");
		int result=main_orderdetail.delOrderDetailByODID(Integer.parseInt(odID));	
		if(result>0){
			response.sendRedirect("Servlet_Main_OrderDetail");
		}else{
			response.sendRedirect("Servlet_Main_OrderDetail?opOrderDetail=toDelOrderDetail&odID="+odID);
		}
 }
 
 public void toModifyOrderDetail(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String odID=request.getParameter("odID");
		E_OrderDetail orderdetail=main_orderdetail.findOrderDetailByODID(Integer.parseInt(odID));
		request.setAttribute("orderdetail",orderdetail);
		request.getRequestDispatcher("/WEB-INF/EB_View/V_BackEnd/BackEnd_Entity/BE_ModifyOrderDetail.jsp").forward(request, response);
 }
 
 public void doModifyOrderDetail(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
 	String odID=request.getParameter("odID");
		E_OrderDetail orderdetail=main_orderdetail.findOrderDetailByODID(Integer.parseInt(odID));	
		String oID=request.getParameter("oID");
		String pID=request.getParameter("pID");	
		String odPQuantity=request.getParameter("odPQuantity");	
		String oCost=request.getParameter("oCost");
		orderdetail.setODID(Integer.parseInt(odID));
		orderdetail.setOID(Integer.parseInt(oID));
		orderdetail.setPID(Integer.parseInt(pID));
		orderdetail.setODPQuantity(Integer.parseInt(odPQuantity));
		orderdetail.setOCost(Float.parseFloat(oCost));
		int result=main_orderdetail.updateOrderDetail(orderdetail);	
		if(result>0){
			response.sendRedirect("Servlet_Main_OrderDetail");
		}else{
			response.sendRedirect("Servlet_Main_OrderDetail?opOrderDetail=toModifyOrderDetail&odID="+odID);
		}
 }
}