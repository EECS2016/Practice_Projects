package cn.zr.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginServlet extends HttpServlet {
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request, response);
 }

 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String op=request.getParameter("op");
  if(null==op){
   request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
  }else{
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    String validaterCode=request.getParameter("validateCode");
    if(!request.getSession().getAttribute("validateCode").equals(validaterCode)){
     request.setAttribute("errorMsg", "验证码失败！");
     request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
    }else{	
     }
   }
 }

 public void destroy() {
  super.destroy(); 
 }
}