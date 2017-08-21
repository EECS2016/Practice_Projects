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
//������Listener
public class A_Listener_01 implements ServletContextListener, ServletContextAttributeListener,
HttpSessionListener, HttpSessionAttributeListener, HttpSessionActivationListener, HttpSessionBindingListener,
HttpSessionIdListener, ServletRequestListener, ServletRequestAttributeListener, AsyncListener{
	Logger logger=Logger.getLogger("A_Listener_01");
	
	//���������Եļ�����
	public void requestInitialized(ServletRequestEvent e){
		logger.info("����request������");
	}
	public void attributeAdded(ServletRequestAttributeEvent e){
		logger.info("request�������������ԣ�"+e.getName()+"(value="+e.getValue()+")");
	}
	public void attributeReplaced(ServletRequestAttributeEvent e){
		logger.info("request�������޸�����"+e.getName()+"(value="+e.getValue()+")Ϊ��"
	  +e.getName()+"(value="+e.getServletRequest().getAttribute(e.getName())+")");
	}
	public void attributeRemoved(ServletRequestAttributeEvent e){
		logger.info("request������ɾ������"+e.getName()+"(value="+e.getValue()+")Ϊ��"
	  +e.getName()+"(value="+e.getServletRequest().getAttribute(e.getName())+")");
	}
	public void requestDestroyed(ServletRequestEvent e){
		logger.info("����request������");
	}
	
 //������ص��첽������
	public void onStartAsync(AsyncEvent arg0) throws java.io.IOException{}
	public void onError(AsyncEvent arg0) throws java.io.IOException{}
	public void onTimeout(AsyncEvent arg0) throws java.io.IOException{}
	public void onComplete(AsyncEvent arg0) throws java.io.IOException{}
	
	//�Ự�������Եļ�����
	public void sessionCreated(HttpSessionEvent e){
		logger.info("����session������");
	}
	public void attributeAdded(HttpSessionBindingEvent e){
		logger.info("session�������������ԣ�"+e.getName()+"(value="+e.getValue()+")");
	}
	public void attributeReplaced(HttpSessionBindingEvent e){
		logger.info("session�������޸�����"+e.getName()+"(value="+e.getValue()+")Ϊ��"
	  +e.getName()+"(value="+e.getSession().getAttribute(e.getName())+")");
	}
	public void attributeRemoved(HttpSessionBindingEvent e){
		logger.info("session������ɾ������"+e.getName()+"(value="+e.getValue()+")Ϊ��"
	  +e.getName()+"(value="+e.getSession().getAttribute(e.getName())+")");
	}
	public void sessionDestroyed(HttpSessionEvent e){
		logger.info("����session������");
	}
	
 //�Ự��صļ�����
	public void sessionWillPassivate(HttpSessionEvent arg0){}
	public void sessionDidActivate(HttpSessionEvent arg0){}
	public void sessionIdChanged(HttpSessionEvent arg0, String arg1){}
	public void valueBound(HttpSessionBindingEvent arg0){}
	public void valueUnbound(HttpSessionBindingEvent arg0){}
	
	//�����ļ������Եļ�����������application�ļ�����
	public void contextInitialized(ServletContextEvent e){
		logger.info("����ServletContext������");
	}
	public void attributeAdded(ServletContextAttributeEvent e){
		logger.info("ServletContext�������������ԣ�"+e.getName()+"(value="+e.getValue()+")");
	}
	public void attributeReplaced(ServletContextAttributeEvent e){
		logger.info("ServletContext�������޸�����"+e.getName()+"(value="+e.getValue()+")Ϊ��"
	  +e.getName()+"(value="+e.getServletContext().getAttribute(e.getName())+")");
	}
	public void attributeRemoved(ServletContextAttributeEvent e){
		logger.info("ServletContext������ɾ������"+e.getName()+"(value="+e.getValue()+")Ϊ��"
	  +e.getName()+"(value="+e.getServletContext().getAttribute(e.getName())+")");
	}
	public void contextDestroyed(ServletContextEvent e){
		logger.info("����ServletContext������");
	}	
}