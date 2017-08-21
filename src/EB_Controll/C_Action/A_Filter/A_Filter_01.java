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
//过滤器
public class A_Filter_01 implements Filter {
	Logger logger=Logger.getLogger("A_Filter_01");
	public void init(FilterConfig fConfig) throws ServletException {
		//过滤器获取初始化参数
		String testParam=fConfig.getInitParameter("test-param");
		System.out.println("过滤器获取初始化参数："+testParam);
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//过滤器字符编码预处理
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
  response.setContentType("text/html;charset=UTF-8");
  //String IPAddress=request.getRemoteAddr();
  //System.out.println("\n过滤器获取客户端IP地址："+IPAddress+"\n");
  //通过过滤链执行下一个过滤器或servlet或jsp
  logger.info("过滤器运行中......");
		chain.doFilter(request, response);
  logger.info("Servlet执行完后继续执行过滤器......");
	}	
	
	public void destroy() {
  System.out.println("过滤器销毁：A_Filter_01");
	}
}