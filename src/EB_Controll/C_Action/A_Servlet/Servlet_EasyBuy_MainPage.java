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
public class Servlet_EasyBuy_MainPage extends HttpServlet{
	//
	private static final long serialVersionUID=1L;
	
	//
 private SInt_Main_News main_news=new SImp_Main_News();
 
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
		String opNews= request.getParameter("opNews");
		if(null==opNews){
			doFindNews(request,response);
		}else{
			switch (opNews) {
				case "doFindNews":doFindNews(request,response);break;
				default:doFindNews(request,response);break;
			}
		}	
	}
	
	//
 @Override
	public void destroy() {
		System.out.println("ServletÏú»Ù£ºServlet_EasyBuy_MainPage");
	}
 
 public void doFindNews(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{

  request.getRequestDispatcher("/WEB-INF/EB_View/EasyBuy_MainPage.jsp").forward(request, response);
 }
}