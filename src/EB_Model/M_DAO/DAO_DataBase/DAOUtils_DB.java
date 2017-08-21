/*
      软件开发的两层架构模式：数据库层（主要指实体类Entity）和应用层（业务逻辑层和显示层）。
 业务逻辑层又可划分出与控制业务流程和显示层交互效果的所谓控制层（Controll层），由此，分化出所谓的MVC三层软件开发的架构模式。
 软件开发的MVC架构模式：模型层（Model层）包含数据库层和划分出Control层后的业务逻辑层，显示层（View层）和控制层（Controll层）
 进一步，业务逻辑层又可划分出数据访问层（DAO层）和服务层（Service层）。
    针对Java Web开发而言，控制层由两大类组件构成，即ActionServlet类和Action类。
    下面针对Java Web开发而言采用分离出的架构模式为：
   1. Model层（Entity层，DAO层和Service层）--->Controll层（ActionServlet组件和Action组件）--->View层（JSP组件）；
   2. 自下向上提供公共接口以供调用，而对应实现类采用JavaBean形式封装。

*/

package EB_Model.M_DAO.DAO_DataBase;
import java.io.Serializable;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;
/*
 * 数据库工具类，包含创建和关闭数据库连接的方法等，利用JNDI实现的数据库连接方法必须被Servlet或JSP调用才能有效
   JNDI配置数据库连接池可自动退出，无需手动关闭结果集和数据库连接
*/
public class DAOUtils_DB implements Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;
	
	//属性（数据域）封装
	private static Connection connection=null;
	
	//无参构造方法（无需像手动创建数据库连接那样使用单例模式）
 public DAOUtils_DB(){super();}
 
	//利用JNDI创建数据库连接的方法
	public static Connection createCon(){
 	try{
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/mysql_EB");
			if(connection==null){
				connection=ds.getConnection();
			 if(!connection.isClosed()){
			 	System.out.println("数据库连接成功！");
			 }
			}
		}catch(SQLException ex1){
			 ex1.printStackTrace();
			 System.out.println("数据库连接未成功！");
		 }catch(Exception ex2){
			  ex2.printStackTrace();
				 System.out.println("数据库连接未成功！");
		 }
		return connection;
	}
	
	//关闭数据库连接的方法
	public static void closeCon(Connection con){
		try{
			con.close();
			if(con.isClosed()){
			 System.out.println("数据库关闭成功！");
			}
		}catch(SQLException ex){
			 ex.printStackTrace();
			 System.out.println("数据库关闭未成功！");
	 }
	}	
}