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
			//ת��ת����ַ�������������ȡ�ַ�Ŀ���ҳ�����ݣ������͵��ͻ�������������ͻ����������ҳ���ַ����
			request.getRequestDispatcher("/WEB-INF/EB_View/EB_V_01.jsp").forward(request,response);
			
	 /*
 	  �ض��򣺷��������ض���Ŀ��ҳ��ĵ�ַ�����ͻ��ˣ�����ȥֱ�ӷ��ʣ���Ȼ�÷�������ܱ�����WEB-INFĿ¼��Ч
			response.sendRedirect("/WEB-INF/EB_View/EB_V_01.jsp");		
			System.out.println("�ض���ҳ�治�ɹ���");
	 */
	}
	
	//
 @Override
	public void destroy() {
		System.out.println("Servlet���٣�A_Servlet_00");
	}
}