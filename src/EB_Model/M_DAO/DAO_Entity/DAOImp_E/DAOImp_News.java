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

package EB_Model.M_DAO.DAO_Entity.DAOImp_E;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import EB_Model.M_DAO.DAO_DataBase.*;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_Entity.*;
import java.sql.Timestamp;
import java.sql.SQLException;
//与实体类E_News对应的DAO层的数据库操作（增删改查等）的接口实现类
public class DAOImp_News extends DAOImp_DB implements DAOInt_News,Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;
	
 //无参构造方法
	public DAOImp_News(){super();}
	
	//查询新闻表格全部记录的方法（按发布时间倒序排列）
	@Override 
	public ArrayList<E_News> queryNewsAll(){
		ArrayList<E_News> listN=new ArrayList<>();
		String sql="select * from EB_News order by NCreateTime desc";
		try{
			ResultSet rs=query(sql,null);
			while(rs.next()){
				E_News news=new E_News();
				news.setNID(rs.getInt(1));
				news.setNTitle(rs.getString(2));
				news.setNContent(rs.getString(3));
				news.setNCreateTime(rs.getTimestamp("NCreateTime"));
				listN.add(news);
			}
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return listN;
	}
	
	//分页查询新闻表格记录的方法
	public ArrayList<E_News> queryNewsByPage(int currentPage,int pageSize){
		ArrayList<E_News> listN=new ArrayList<>();
		String sql="select * from EB_News limit ?,?";
		try{
			ResultSet rs=query(sql, new Object[]{(currentPage-1)*pageSize,pageSize});
			while(rs.next()){
				E_News news=new E_News();
				news.setNID(rs.getInt(1));
				news.setNTitle(rs.getString(2));
				news.setNContent(rs.getString(3));
				news.setNCreateTime(rs.getTimestamp("NCreateTime"));
				listN.add(news);
			}
			rs.close();
		}catch(SQLException e){
		 	e.printStackTrace();		
	 	}
		return listN;
	}	
	
	//按新闻编号查询新闻表格记录的方法
	@Override 
	public E_News queryNewsByNId(int nID){
		E_News news=null;
		String sql="select * from EB_News where NID=?";
		try{
			ResultSet rs=query(sql, new Object[]{nID});
			if(rs.next()){
				news=new E_News();
				news.setNID(rs.getInt(1));
				news.setNTitle(rs.getString(2));
				news.setNContent(rs.getString(3));
				news.setNCreateTime(rs.getTimestamp("NCreateTime"));
			}
			rs.close();
		}catch(SQLException ex){
		 	ex.printStackTrace();
	 	}
		return news;
	}
	
 //查询新闻表格行数的方法
	@Override 
	public int queryNewsRowsNum(){
		int NewsRowsNum=0;
		String sql="select count(*) from EB_News";
		try{
			ResultSet rs=query(sql,null);
			if(rs.next()){
		  NewsRowsNum=rs.getInt(1);
			}
			rs.close();
		}catch(SQLException ex){
			 ex.printStackTrace();
		 }
		return NewsRowsNum;
	}
	
	//增加1条记录到新闻表格起点的方法
	@Override 
	public int insertFirstNews(E_News news){
		int n=-1;
		news.setNID(queryNewsRowsNum()+1);
		String sql="update insert into EB_News values(?,?,?,?)";
		n=operate(sql, new Object[]{news.getNID(),news.getNTitle(), news.getNContent(), new Timestamp(news.getNCreateTime().getTime())});
		return n;
	}
	
	//增加1条记录到新闻表格中间的方法
	@Override 
	public int insertMiddleNews(E_News news){
		int n=-1;
		news.setNID(queryNewsRowsNum()+1);
		String sql="insert into EB_News values(?,?,?,?)";
		n=operate(sql, new Object[]{news.getNID(),news.getNTitle(), news.getNContent(), new Timestamp(news.getNCreateTime().getTime())});
		return n;
	}
	
	//增加1条记录到新闻表格末尾的方法
	@Override 
	public int insertEndNews(E_News news){
		int n=-1;
		news.setNID(queryNewsRowsNum()+1);
		String sql="insert into EB_News values(?,?,?,?)";
		n=operate(sql, new Object[]{news.getNID(),news.getNTitle(), news.getNContent(), new Timestamp(news.getNCreateTime().getTime())});
		return n;
	}

	
	
	
	//删除新闻表格全部记录的方法
	@Override 
	public int deleteNewsAll(){
		int n=-1;
		String sql="delete from EB_News";
		n=operate(sql,null);
		return n;
	}
	
	//按新闻编号删除新闻表格记录的方法
	@Override 
	public int deleteNewsByNId(int nId){
		int n=-1;
		String sql="delete from EB_News where NID=?";
		n=operate(sql, new Object[]{nId});
		return n;
	}

	//修改新闻表格单条记录的方法
	@Override 
	public int modifyNews(E_News news){
		int n=-1;
		String sql="update EB_News set NTitle=?,NContent=?,NCreateTime=? where NID=?";
		n=operate(sql, new Object[]{news.getNTitle(), news.getNContent(), new Timestamp(news.getNCreateTime().getTime()), news.getNID()});
		return n;
	}
}