package EB_Model.M_Service.ServiceInt;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//主要与实体类E_User对应的Service层的公共接口
public interface SInt_Main_User{
	//查询用户表格全部记录的方法
	ArrayList<E_User> findUserAll();
	
	//分页查询用户表格记录的方法
	ArrayList<E_User> findUserByPage(int currentPage,int pageSize);
	
	//按用户编号查询用户表格记录的方法
	E_User findUserByUID(int uID);
	
	//按用户名称查询用户表格记录的方法
	ArrayList<E_User> findUserByUName(String uName);
	
 //查询用户表格行数的方法
	int findUserRowsNum();
	
 //增加1条记录到书本表格的方法
	int addtUser(E_User user);
	
	//删除用户表格全部记录的方法
	int delUserAll();
	
	//按用户编号删除书本表格记录的方法
	int delUserByUID(int uID);
	
	//修改用户表格单条记录的方法
	int updateUser(E_User user);
}