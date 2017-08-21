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
public class Servlet_Main_User extends HttpServlet{
	//
	private static final long serialVersionUID=1L;
	
	//
 private SInt_Main_User main_user=new SImp_Main_User();
 
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
		ArrayList<E_User> listU=main_user.findUserAll();
		PrintWriter out=response.getWriter();
		out.print("�û��˺�&#160;&#160;&#160;&#160;��ʵ����&#160;&#160;&#160;&#160;��¼����&#160;&#160;&#160;&#160;�Ա�&#160;&#160;&#160;&#160;");
		out.print("��������&#160;&#160;&#160;&#160;����֤��&#160;&#160;&#160;&#160;��������&#160;&#160;&#160;&#160;�ֻ�&#160;&#160;&#160;&#160;");
		out.print("��ַ&#160;&#160;&#160;&#160;��¼״̬&#160;&#160;&#160;&#160;�û�����<br />");
		for(E_User u:listU){
			out.print(u.getUID()+"&#160;&#160;&#160;&#160;"+u.getUName()+"&#160;&#160;&#160;&#160;"+u.getUPassword()+"&#160;&#160;&#160;&#160;");
			out.print(u.getUSex()+"&#160;&#160;&#160;&#160;"+u.getUBirthday()+"&#160;&#160;&#160;&#160;"+u.getUIdentityCode()+"&#160;&#160;&#160;&#160;");
			out.print(u.getUEmail()+"&#160;&#160;&#160;&#160;"+u.getUMobile()+"&#160;&#160;&#160;&#160;"+u.getUAddress()+"&#160;&#160;&#160;&#160;");
			out.print(u.getULogin()+"&#160;&#160;&#160;&#160;"+u.getUType()+"<br />");
			out.flush();
		}
		out.close();
	}
	
	//
 @Override
	public void destroy() {
		System.out.println("Servlet���٣� Servlet_Main_User");
	}
}