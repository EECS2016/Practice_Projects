
package EB_Model.M_DAO.DAO_Entity.DAOImp_E;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import EB_Model.M_DAO.DAO_DataBase.DAOImp_DB;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_Entity.*;
import java.sql.SQLException;
import java.sql.Timestamp;
//��ʵ����E_UserComment��Ӧ��DAO������ݿ��������ɾ�Ĳ�ȣ��Ľӿ�ʵ����
public class DAOImp_UserComment extends DAOImp_DB implements DAOInt_UserComment,Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;
	
 //�޲ι��췽��
 public DAOImp_UserComment(){}
 
	//��ѯ�û����۱��ȫ����¼�ķ���
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
 
 //��ҳ��ѯ�û����۱���¼�ķ���
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
	  
//���û����۱�Ų�ѯ�û����۱���¼�ķ���
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
	
 //��ѯ�û����۱�������ķ���
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
	
//����1����¼���û����۱��ķ���
	@Override 
	public int insertUserComment(E_UserComment usercomment){
		int n=-1;
		String sql="insert into EB_UserComment(UCContent,UCCreateTime,UCReply,UCReplyTime,UCNickName) values(?,?,?,?,?)";
		n=operate(sql, new Object[]{usercomment.getUCContent(), new Timestamp(usercomment.getUCCreateTime().getTime())
     			,usercomment.getUCReply(), new Timestamp(usercomment.getUCReplyTime().getTime()),usercomment.getUCNickName()});
		return n;
	}
	
	//ɾ���û����۱��ȫ����¼�ķ���
	@Override
	public int deleteUserCommentAll(){
		int n=-1;
		String sql="delete * from EB_UserComment";
		n=operate(sql,null);
		return n;
	}	
	
	//���û����۱��ɾ���û����۱���¼�ķ���
	@Override
	public int deleteUserCommentByUCID(int ucID){
		int n=-1;
		String sql="delete * from EB_UserComment where UCID=?";
		n=operate(sql, new Object[]{ucID});
		return n;
	}
	
	//�޸��û����۱������¼�ķ���
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