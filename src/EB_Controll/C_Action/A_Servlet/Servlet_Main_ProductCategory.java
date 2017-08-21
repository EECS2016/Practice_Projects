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
public class Servlet_Main_ProductCategory extends HttpServlet{
	//
	private static final long serialVersionUID=1L;
	
	//
 private SInt_Main_ProductCategory main_productcategory=new SImp_Main_ProductCategory();
 
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
		ArrayList<E_ProductCategory> listPC	=main_productcategory.findProductCategoryAll();
		PrintWriter out=response.getWriter();
		out.print("��Ʒ������&#160;&#160;&#160;&#160;��Ʒ��������&#160;&#160;&#160;&#160;");
		out.print("��Ʒ���ױ��&#160;&#160;&#160;&#160;<br />");
		for(E_ProductCategory pc:listPC){
			out.print(pc.getPCID()+"&#160;&#160;&#160;&#160;"+pc.getPCName()+"&#160;&#160;&#160;&#160;");
			out.print(pc.getPCParentID()+"<br />");
	  out.flush();
		}
		out.close();
	}
	
	//
 @Override
	public void destroy() {
		System.out.println("Servlet���٣� Servlet_Main_ProductCategory");
	}
}