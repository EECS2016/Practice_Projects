package cn.zr.servlet;
import java.io.IOException;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.zr.entity.Book;
import cn.zr.service.BookService;
import cn.zr.service.impl.BookServiceImpl;
public class BookServlet extends HttpServlet{
	private BookService bookService = new BookServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//编码处理
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=UTF-8");	
		String op = request.getParameter("op");
		if(null==op){
			query(request,response);
		}else{
			switch (op) {
				case "query":
					query(request,response);
					break;
				case "toModify":
					toModify(request, response);
					break;
				case "doModify":
					doModify(request, response);
					break;
				default:
					query(request,response);
					break;
			}
		}	
	}
	
	//查询数据
	public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//List<Book> books = bookService.findByAll();	
				//获取当前页
				String currentPage = request.getParameter("currentPage");
				int currPage = 0;
				if(null == currentPage){//第一次访问时即第一页
					currPage = 1;
				}else{//第二次或后面访问钧为页面传出的值
					currPage = Integer.parseInt(currentPage);
				}				
				//每页显示的个数
				int pageSize = 2;				
				//分页查询
				List<Book> books = bookService.findByPage(currPage, pageSize);				
				//所有数据的总个数
				int total = bookService.findCount();
				//求总页数
				int totalPage = (total%pageSize==0)?(total/pageSize):(total/pageSize+1);
				//上一页
				int prePage = -1;
				if(currPage==1){//当前页就是首页，上一页与当前页相等
					prePage = currPage;
				}else{
					prePage = currPage-1;
				}
				//下一页
				int nextPage = 0;
				if(currPage == totalPage){//当前页是尾页，下一页就是尾页
					nextPage = totalPage;
				}else{
					nextPage = currPage+1;
				}								
				request.setAttribute("books", books);
				request.setAttribute("currentPage", currPage);
				request.setAttribute("total", total);
				request.setAttribute("totalPage", totalPage);
				request.setAttribute("prePage", prePage);
				request.setAttribute("nextPage", nextPage);
				request.getRequestDispatcher("WEB-INF/jsp/books.jsp").forward(request, response);
				
	}
	
	//转向修改页面
	public void toModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("bid");
		Book book = bookService.findById(Integer.parseInt(id));
		request.setAttribute("book", book);
		request.getRequestDispatcher("WEB-INF/jsp/book.jsp").forward(request, response);
	}
	
	//需要完成的修改业务逻辑
	public void doModify(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String bid = request.getParameter("bid");
		Book book = bookService.findById(Integer.parseInt(bid));	
		//从页面上获取修改后的数据
		String bname = request.getParameter("bname");
		String author = request.getParameter("author");
		String count = request.getParameter("count");	
		//将修改后的数据保存到实体对象中
		book.setBname(bname);
		book.setCount(Integer.parseInt(count));
		book.setAuthor(author);	
		int result = bookService.modify(book);	
		if(result>0){
			response.sendRedirect("bookservlet");
		}else{
			response.sendRedirect("bookModifyServlet?bid="+bid);
		}
	}

	@Override
	public void destroy() {
		System.out.println("bookServlet销毁");
	}
}