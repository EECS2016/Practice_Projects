package EB_Model.M_DAO.DAO_Entity.DAOInt_E;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//与实体类E_UserComment对应的DAO层的数据库操作（增删改查等）的公共接口
public interface DAOInt_UserComment{
	//查询用户评论表格全部记录的方法
	ArrayList<E_UserComment> queryUserCommentAll();
	
	//分页查询用户评论表格记录的方法
	ArrayList<E_UserComment> queryUserCommentByPage(int currentPage,int pageSize);
	
 //按用户评论编号查询用户评论表格记录的方法
	E_UserComment queryUserCommentByUCID(int ucID);
	
 //查询用户评论表格行数的方法
	public int queryUserCommentRowsNum();
	
	//增加1条记录到用户评论表格的方法
	int insertUserComment(E_UserComment usercomment);
	
	//删除用户评论表格全部记录的方法
	int deleteUserCommentAll();
	
	//按用户评论编号删除用户评论表格记录的方法
	int deleteUserCommentByUCID(int ucID);
	
	//修改用户评论表格单条记录的方法
	int modifyUserComment(E_UserComment usercomment);
}