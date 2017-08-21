package EB_Controll.C_Action.A_Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import EB_Model.M_Service.ServiceImp.*;
import EB_Model.M_Service.ServiceInt.*;
import EB_Model.M_Entity.*;
//
public class A_Servlet_01 extends HttpServlet{
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
		ArrayList<E_News> listN=main_news.findNewsAll();
		PrintWriter out=response.getWriter();
		out.print("新闻编号&#160;&#160;&#160;&#160;新闻标题&#160;&#160;&#160;&#160;");
		out.print("新闻内容&#160;&#160;&#160;&#160;发布时间<br />");
		for(E_News n:listN){
			out.print(n.getNID()+"&#160;&#160;&#160;&#160;"+n.getNTitle()+"&#160;&#160;&#160;&#160;");
			out.print(n.getNContent()+"&#160;&#160;&#160;&#160;"+n.getNCreateTime()+"<br />");
	  out.flush();
		}
		out.close();
	}
	
	//
 @Override
	public void destroy() {
		System.out.println("Servlet销毁：A_Servlet_01");
	}
}