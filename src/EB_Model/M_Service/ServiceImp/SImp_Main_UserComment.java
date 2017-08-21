package EB_Model.M_Service.ServiceImp;
import java.io.Serializable;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_DAO.DAO_Entity.DAOImp_E.*;
import EB_Model.M_Service.ServiceInt.*;
public class SImp_Main_UserComment implements SInt_Main_UserComment,Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;

	//属性（数据域）封装
	private DAOInt_UserComment sUserComment=new DAOImp_UserComment();
	
 //无参构造方法
	public SImp_Main_UserComment(){super();}

	//查询用户评论表格全部记录的方法
	@Override
	public ArrayList<E_UserComment> findUserCommentAll(){
		return sUserComment.queryUserCommentAll();
	}

 //分页查询用户评论表格记录的方法 
	@Override 
	public ArrayList<E_UserComment> findUserCommentByPage(int currentPage, int pageSize){
		return sUserComment.queryUserCommentByPage(currentPage, pageSize);
	}

	//按用户评论编号查询用户评论表格记录的方法 
	@Override 
	public E_UserComment findUserCommentByUCID(int ucID){
		return sUserComment.queryUserCommentByUCID(ucID);
	}

 //查询用户评论表格行数的方法	
	@Override
	public int findUserCommentRowsNum(){
		return sUserComment.queryUserCommentRowsNum();
	}

 //增加1条记录到用户评论表格的方法	
	@Override
	public int addUserComment(E_UserComment usercomment){
		return sUserComment.insertUserComment(usercomment);
	}
	
 //删除用户评论表格全部记录的方法	
	@Override
	public int delUserCommentAll(){
		return sUserComment.deleteUserCommentAll();
	}

 //按用户评论编号删除用户评论表格记录的方法
	@Override
	public int delUserCommentByUCID(int ucID){
		return sUserComment.deleteUserCommentByUCID(ucID);
	}

	//修改用户评论表格单条记录的方法
	@Override 
	public int updateUserComment(E_UserComment usercomment){
		return sUserComment.modifyUserComment(usercomment);
	}
}