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
public class Servlet_Main_Product extends HttpServlet{
	//
	private static final long serialVersionUID=1L;
	
	//
 private SInt_Main_Product main_product=new SImp_Main_Product();
 
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
		ArrayList<E_Product> listP=main_product.findProductAll();
		PrintWriter out=response.getWriter();
		out.print("商品编号&#160;&#160;&#160;&#160;商品名称&#160;&#160;&#160;&#160;描述&#160;&#160;&#160;&#160;商品价格（元）&#160;&#160;&#160;&#160;");
		out.print("库存&#160;&#160;&#160;&#160;所属分类;&#160;&#160;&#160;所属二级分类;&#160;&#160;&#160;商品图片<br />");
		for(E_Product p:listP){
			out.print(p.getPID()+"&#160;&#160;&#160;&#160;"+p.getPName()+"&#160;&#160;&#160;&#160;"+p.getPDescription()+"&#160;&#160;&#160;&#160;");
			out.print(p.getPPrice()+"&#160;&#160;&#160;&#160;"+p.getPStock()+"&#160;&#160;&#160;&#160;");
			out.print(p.getPCID()+"&#160;&#160;&#160;&#160;"+p.getPCChildID()+"&#160;&#160;&#160;&#160;"+p.getPUploadFileName()+"<br />");
	  out.flush();
		}
		out.close();
	}
	
	//
 @Override
	public void destroy() {
		System.out.println("Servlet销毁： Servlet_Main_Product");
	}
}