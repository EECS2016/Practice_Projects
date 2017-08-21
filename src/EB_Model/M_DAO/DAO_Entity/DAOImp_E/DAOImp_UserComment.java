
package EB_Model.M_DAO.DAO_Entity.DAOImp_E;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import EB_Model.M_DAO.DAO_DataBase.DAOImp_DB;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_Entity.*;
import java.sql.SQLException;
import java.sql.Timestamp;
//与实体类E_UserComment对应的DAO层的数据库操作（增删改查等）的接口实现类
public class DAOImp_UserComment extends DAOImp_DB implements DAOInt_UserComment,Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;
	
 //无参构造方法
 public DAOImp_UserComment(){}
 
	//查询用户评论表格全部记录的方法
	@Override 
	public ArrayList<E_UserComment> queryUserCommentAll(){
		ArrayList<E_UserComment> listUC=new ArrayList<>();
		String sql="select * from EB_UserComment";
		try{
			ResultSet rs=query(sql,null);
			while(rs.next()){
				E_UserComment usercomment=new E_UserComment();
				usercomment=new E_UserComment();
				usercomment.setUCID(rs.getInt(1));
				usercomment.setUCContent(rs.getString(2));
				usercomment.setUCCreateTime(rs.getTimestamp("UCCreateTime"));
				usercomment.setUCReply(rs.getString(4));
				usercomment.setUCReplyTime(rs.getTimestamp("UCReplyTime"));
				usercomment.setUCNickName(rs.getString(6));
				listUC.add(usercomment);
			}
			rs.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return listUC;
	}
 
 //分页查询用户评论表格记录的方法
	@Override 
	public ArrayList<E_UserComment> queryUserCommentByPage(int currentPage,int pageSize){
		ArrayList<E_UserComment> listUC=new ArrayList<>();
		String sql="select * from EB_UserComment limit ?,?";
		try{
			ResultSet rs=query(sql, new Object[]{(currentPage-1)*pageSize,pageSize});
			while(rs.next()){
				E_UserComment usercomment=new E_UserComment();
				usercomment=new E_UserComment();
				usercomment.setUCID(rs.getInt(1));
				usercomment.setUCContent(rs.getString(2));
				usercomment.setUCCreateTime(rs.getTimestamp("UCCreateTime"));
				usercomment.setUCReply(rs.getString(4));
				usercomment.setUCReplyTime(rs.getTimestamp("UCReplyTime"));
				usercomment.setUCNickName(rs.getString(6));
				listUC.add(usercomment);
			}
			rs.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return listUC;
	}
	  
//按用户评论编号查询用户评论表格记录的方法
	@Override 
	public E_UserComment queryUserCommentByUCID(int ucID){
		E_UserComment usercomment=null;
		String sql="select * from EB_UserComment where UCID=?";
		try{
			ResultSet rs=query(sql, new Object[]{ucID});
			if(rs.next()){
				usercomment=new E_UserComment();
				usercomment.setUCID(rs.getInt(1));
				usercomment.setUCContent(rs.getString(2));
				usercomment.setUCCreateTime(rs.getTimestamp("UCCreateTime"));
				usercomment.setUCReply(rs.getString(4));
				usercomment.setUCReplyTime(rs.getTimestamp("UCReplyTime"));
				usercomment.setUCNickName(rs.getString(6));
			}
			rs.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return usercomment;
	}
	
 //查询用户评论表格行数的方法
	@Override 
	public int queryUserCommentRowsNum(){
		int UserCommentRowsNum=0;
		String sql="select count(*) from EB_UserComment";
		try{
			ResultSet rs=query(sql,null);
			if(rs.next()){
				UserCommentRowsNum=rs.getInt(1);
			}
			rs.close();
		}catch(SQLException ex){
			 ex.printStackTrace();
		 }
		return UserCommentRowsNum;
	}	
	
//增加1条记录到用户评论表格的方法
	@Override 
	public int insertUserComment(E_UserComment usercomment){
		int n=-1;
		String sql="insert into EB_UserComment(UCContent,UCCreateTime,UCReply,UCReplyTime,UCNickName) values(?,?,?,?,?)";
		n=operate(sql, new Object[]{usercomment.getUCContent(), new Timestamp(usercomment.getUCCreateTime().getTime())
     			,usercomment.getUCReply(), new Timestamp(usercomment.getUCReplyTime().getTime()),usercomment.getUCNickName()});
		return n;
	}
	
	//删除用户评论表格全部记录的方法
	@Override
	public int deleteUserCommentAll(){
		int n=-1;
		String sql="delete * from EB_UserComment";
		n=operate(sql,null);
		return n;
	}	
	
	//按用户评论编号删除用户评论表格记录的方法
	@Override
	public int deleteUserCommentByUCID(int ucID){
		int n=-1;
		String sql="delete * from EB_UserComment where UCID=?";
		n=operate(sql, new Object[]{ucID});
		return n;
	}
	
	//修改用户评论表格单条记录的方法
	@Override 
	public int modifyUserComment(E_UserComment usercomment){
		int n=-1;
		String sql="update EB_UserComment set UCContent=?, UCCreateTime=?, UCReply=?, UCReplyTime=?, UCNickName=? where UCID=?";
		n=operate(sql, new Object[]{usercomment.getUCContent(), new Timestamp(usercomment.getUCCreateTime().getTime())
		     	,usercomment.getUCReply(), new Timestamp(usercomment.getUCReplyTime().getTime())
			     ,usercomment.getUCNickName(), usercomment.getUCID()});
		return n;
	}
}