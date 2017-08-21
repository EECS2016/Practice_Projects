
package EB_Model.M_Service.ServiceInt;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//主要与实体类E_UserComment相关的Service层的公共接口
public interface SInt_Main_UserComment{
	//查询用户评论表格全部记录的方法
	ArrayList<E_UserComment> findUserCommentAll();
	
	//分页查询用户评论表格记录的方法
	ArrayList<E_UserComment> findUserCommentByPage(int currentPage,int pageSize);
	
 //按用户评论编号查询用户评论表格记录的方法
	E_UserComment findUserCommentByUCID(int ucID);
	
 //查询用户评论表格行数的方法
	public int findUserCommentRowsNum();
	
	//增加1条记录到用户评论表格的方法
	int addUserComment(E_UserComment usercomment);
	
	//删除用户评论表格全部记录的方法
	int delUserCommentAll();
	
	//按用户评论编号删除用户评论表格记录的方法
	int delUserCommentByUCID(int ucID);
	
	//修改用户评论表格单条记录的方法
	int updateUserComment(E_UserComment usercomment);
}