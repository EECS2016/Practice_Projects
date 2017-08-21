/*

*/
package EB_Controll.C_Action.A_Listener;
import java.util.logging.Logger;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.AsyncListener;
import javax.servlet.AsyncEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionBindingEvent;
//监听器Listener
public class A_Listener_01 implements ServletContextListener, ServletContextAttributeListener,
HttpSessionListener, HttpSessionAttributeListener, HttpSessionActivationListener, HttpSessionBindingListener,
HttpSessionIdListener, ServletRequestListener, ServletRequestAttributeListener, AsyncListener{
	Logger logger=Logger.getLogger("A_Listener_01");
	
	//请求及其属性的监听器
	public void requestInitialized(ServletRequestEvent e){
		logger.info("创建request监听器");
	}
	public void attributeAdded(ServletRequestAttributeEvent e){
		logger.info("request监听器增加属性："+e.getName()+"(value="+e.getValue()+")");
	}
	public void attributeReplaced(ServletRequestAttributeEvent e){
		logger.info("request监听器修改属性"+e.getName()+"(value="+e.getValue()+")为："
	  +e.getName()+"(value="+e.getServletRequest().getAttribute(e.getName())+")");
	}
	public void attributeRemoved(ServletRequestAttributeEvent e){
		logger.info("request监听器删除属性"+e.getName()+"(value="+e.getValue()+")为："
	  +e.getName()+"(value="+e.getServletRequest().getAttribute(e.getName())+")");
	}
	public void requestDestroyed(ServletRequestEvent e){
		logger.info("销毁request监听器");
	}
	
 //请求相关的异步监听器
	public void onStartAsync(AsyncEvent arg0) throws java.io.IOException{}
	public void onError(AsyncEvent arg0) throws java.io.IOException{}
	public void onTimeout(AsyncEvent arg0) throws java.io.IOException{}
	public void onComplete(AsyncEvent arg0) throws java.io.IOException{}
	
	//会话及其属性的监听器
	public void sessionCreated(HttpSessionEvent e){
		logger.info("创建session监听器");
	}
	public void attributeAdded(HttpSessionBindingEvent e){
		logger.info("session监听器增加属性："+e.getName()+"(value="+e.getValue()+")");
	}
	public void attributeReplaced(HttpSessionBindingEvent e){
		logger.info("session监听器修改属性"+e.getName()+"(value="+e.getValue()+")为："
	  +e.getName()+"(value="+e.getSession().getAttribute(e.getName())+")");
	}
	public void attributeRemoved(HttpSessionBindingEvent e){
		logger.info("session监听器删除属性"+e.getName()+"(value="+e.getValue()+")为："
	  +e.getName()+"(value="+e.getSession().getAttribute(e.getName())+")");
	}
	public void sessionDestroyed(HttpSessionEvent e){
		logger.info("销毁session监听器");
	}
	
 //会话相关的监听器
	public void sessionWillPassivate(HttpSessionEvent arg0){}
	public void sessionDidActivate(HttpSessionEvent arg0){}
	public void sessionIdChanged(HttpSessionEvent arg0, String arg1){}
	public void valueBound(HttpSessionBindingEvent arg0){}
	public void valueUnbound(HttpSessionBindingEvent arg0){}
	
	//上下文极其属性的监听器（即对application的监听）
	public void contextInitialized(ServletContextEvent e){
		logger.info("创建ServletContext监听器");
	}
	public void attributeAdded(ServletContextAttributeEvent e){
		logger.info("ServletContext监听器增加属性："+e.getName()+"(value="+e.getValue()+")");
	}
	public void attributeReplaced(ServletContextAttributeEvent e){
		logger.info("ServletContext监听器修改属性"+e.getName()+"(value="+e.getValue()+")为："
	  +e.getName()+"(value="+e.getServletContext().getAttribute(e.getName())+")");
	}
	public void attributeRemoved(ServletContextAttributeEvent e){
		logger.info("ServletContext监听器删除属性"+e.getName()+"(value="+e.getValue()+")为："
	  +e.getName()+"(value="+e.getServletContext().getAttribute(e.getName())+")");
	}
	public void contextDestroyed(ServletContextEvent e){
		logger.info("销毁ServletContext监听器");
	}	
}