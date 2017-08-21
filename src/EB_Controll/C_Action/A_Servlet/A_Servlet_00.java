package EB_Controll.C_Action.A_Servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//
public class A_Servlet_00 extends HttpServlet{
	//
	private static final long serialVersionUID=1L;
	
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
			//转向（转发或分发）：服务器读取分发目标的页面内容，并发送到客户端浏览器，而客户端浏览器的页面地址不变
			request.getRequestDispatcher("/WEB-INF/EB_View/EB_V_01.jsp").forward(request,response);
			
	 /*
 	  重定向：服务器把重定向目标页面的地址发给客户端，令其去直接访问，显然该方法针对受保护的WEB-INF目录无效
			response.sendRedirect("/WEB-INF/EB_View/EB_V_01.jsp");		
			System.out.println("重定向页面不成功！");
	 */
	}
	
	//
 @Override
	public void destroy() {
		System.out.println("Servlet销毁：A_Servlet_00");
	}
}