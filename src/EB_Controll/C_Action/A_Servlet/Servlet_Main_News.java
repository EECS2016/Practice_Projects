/*
 *��ַ���������ݣ���ȫ����������
 *ע����������棡��
*/
package EB_Controll.C_Action.A_Servlet;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import EB_Model.M_Service.ServiceImp.*;
import EB_Model.M_Service.ServiceInt.*;
import EB_Model.M_Entity.*;
public class Servlet_Main_News extends HttpServlet{
	private static final long serialVersionUID=1L;
	//ʵ��Service��News��ؽӿڵ�ʵ��
 private SInt_Main_News main_news=new SImp_Main_News();
 
 //
 @Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		doPost(request,response);
	}
	
 //�鿴��ɾ������һ����Ӧ�ķ�����
 @Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String opNews=request.getParameter("opNews");
		if(null==opNews){
			doFindNews(request,response);
		}else{
			switch (opNews) {
				case "toAddNews":toAddNews(request,response);break;
				case "doAddNews":doAddNews(request, response);break;			
				case "doDelNews":doDelNews(request, response);break;
				case "toModifyNews":toModifyNews(request, response);break;
				case "doModifyNews":doModifyNews(request, response);break;	
				case "doFindNews":doFindNews(request,response);break;
				default:doFindNews(request,response);break;
			}
		}	
	}
	
	//
 @Override
	public void destroy() {
		System.out.println("Servlet���٣�Servlet_Main_News");
	}
 
 public void doFindNews(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		//��ȡ��ǰҳ
		String currentPage=request.getParameter("currentPage");
		int currPage=0;
		if(null==currentPage){
			//��һ�η���ʱ����һҳ
			currPage=1;
		}else{
			//�ڶ��λ������ʾ�Ϊҳ�洫����ֵ
			currPage=Integer.parseInt(currentPage);
		}				
		//ÿҳ��ʾ�ķ����¼������	ȡ4����
		int pageSize=4;				
  ArrayList<E_News> listN=main_news.findNewsByPage(currPage, pageSize);
		int total=main_news.findNewsRowsNum();
		//����ҳ��
		int totalPage=(total%pageSize==0)?(total/pageSize):(total/pageSize+1);
		//��һҳ
		int prePage=0;
		if(currPage==1){
			//��ǰҳ������ҳ����һҳ�뵱ǰҳ���
			prePage=currPage;
		}else{
			prePage=currPage-1;
		}
		//��һҳ
		int nextPage=0;
		if(currPage==totalPage){
			//��ǰҳ��βҳ����һҳ����βҳ
			nextPage=totalPage;
		}else{
			nextPage=currPage+1;
		}	
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("total", total);
  request.setAttribute("listN",listN);
		request.setAttribute("currentPage", currPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("prePage", prePage);
		request.setAttribute("nextPage", nextPage);
  request.getRequestDispatcher("/WEB-INF/EB_View/V_BackEnd/BackEnd_Entity/BE_News.jsp").forward(request, response);
 }
 
 public void toAddNews(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		request.getRequestDispatcher("/WEB-INF/EB_View/V_BackEnd/BackEnd_Entity/BE_AddNews.jsp").forward(request, response);
 }
 
 public void doAddNews(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String nTitle=request.getParameter("title");
		String nContent=request.getParameter("content");	
		Date nCreateTime=new Date();
		E_News news=new E_News(nTitle,nContent,nCreateTime);	
		int result=main_news.addNews(news);	
		if(result>0){
			response.sendRedirect("Servlet_Main_News");
		}else{
			response.sendRedirect("Servlet_Main_News?opNews=toAddNews");
		}
 }
 
 public void doDelNews(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
 	String nID=request.getParameter("nID");
		int result=main_news.delNewsByNId(Integer.parseInt(nID));
		System.out.print("nID="+nID+"result="+result);
		if(result>0){
			response.sendRedirect("Servlet_Main_News");
		}else{
			response.sendRedirect("Servlet_Main_News?opNews=doDelNews&nID="+nID);
		}
 }
 
 public void toModifyNews(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String nID=request.getParameter("nID");
		E_News news=main_news.findNewsByNId(Integer.parseInt(nID));
		request.setAttribute("news",news);
		request.getRequestDispatcher("/WEB-INF/EB_View/V_BackEnd/BackEnd_Entity/BE_ModifyNews.jsp").forward(request, response);
 }
 
 public void doModifyNews(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
 	String nID=request.getParameter("nID");
		E_News news=main_news.findNewsByNId(Integer.parseInt(nID));	
		String nTitle=request.getParameter("title");
		String nContent=request.getParameter("content");	
		Date nCreateTime=new Date();
		news.setNTitle(nTitle);
		news.setNContent(nContent);
		news.setNCreateTime(nCreateTime);
		int result=main_news.updateNews(news);
		if(result>0){
			response.sendRedirect("Servlet_Main_News");
		}else{
			response.sendRedirect("Servlet_Main_News?opNews=toModifyNews&nID="+nID);
		}
 }
}