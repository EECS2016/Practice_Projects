/*
 * 
 *
 */
package EB_Controll.C_Action.A_Filter;
import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//������
public class A_Filter_01 implements Filter {
	Logger logger=Logger.getLogger("A_Filter_01");
	public void init(FilterConfig fConfig) throws ServletException {
		//��������ȡ��ʼ������
		String testParam=fConfig.getInitParameter("test-param");
		System.out.println("��������ȡ��ʼ��������"+testParam);
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//�������ַ�����Ԥ����
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
  response.setContentType("text/html;charset=UTF-8");
  //String IPAddress=request.getRemoteAddr();
  //System.out.println("\n��������ȡ�ͻ���IP��ַ��"+IPAddress+"\n");
  //ͨ��������ִ����һ����������servlet��jsp
  logger.info("������������......");
		chain.doFilter(request, response);
  logger.info("Servletִ��������ִ�й�����......");
	}	
	
	public void destroy() {
  System.out.println("���������٣�A_Filter_01");
	}
}