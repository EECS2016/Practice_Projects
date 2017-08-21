package EB_Model.M_DAO.DAO_Entity.DAOInt_E;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//与实体类E_User对应的DAO层的数据库操作（增删改查等）的公共接口
public interface DAOInt_User{
	//查询用户表格全部记录的方法
	ArrayList<E_User> queryUserAll();
	
	//分页查询用户表格记录的方法
	ArrayList<E_User> queryUserByPage(int currentPage,int pageSize);
	
	//按用户编号查询用户表格记录的方法
	E_User queryUserByUID(int uID);
	
	//按用户名称查询用户表格记录的方法
	ArrayList<E_User> queryUserByUName(String uName);
	
 //查询用户表格行数的方法
	int queryUserRowsNum();
	
 //增加1条记录到书本表格的方法
	int insertUser(E_User user);
	
	//删除用户表格全部记录的方法
	int deleteUserAll();
	
	//按用户编号删除书本表格记录的方法
	int deleteUserByUID(int uID);
	
	//修改用户表格单条记录的方法
	int modifyUser(E_User user);
}