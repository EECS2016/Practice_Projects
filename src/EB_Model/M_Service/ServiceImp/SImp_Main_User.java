package EB_Model.M_Service.ServiceImp;
import java.io.Serializable;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_DAO.DAO_Entity.DAOImp_E.*;
import EB_Model.M_Service.ServiceInt.*;
public class SImp_Main_User implements SInt_Main_User,Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;

	//属性（数据域）封装
	private DAOInt_User sUser=new DAOImp_User();
	
 //无参构造方法
	public SImp_Main_User(){super();}

	//查询用户表格全部记录的方法
	@Override
	public ArrayList<E_User> findUserAll(){
		return sUser.queryUserAll();
	}

	//分页查询用户表格记录的方法
	@Override
	public ArrayList<E_User> findUserByPage(int currentPage, int pageSize){
		return sUser.queryUserByPage(currentPage, pageSize);
	}

	//按用户编号查询用户表格记录的方法
	@Override 
	public E_User findUserByUID(int uID){
		return sUser.queryUserByUID(uID);
	}

	//按用户名称查询用户表格记录的方法
	@Override 
	public ArrayList<E_User> findUserByUName(String uName){
		return sUser.queryUserByUName(uName);
	}

 //查询用户表格行数的方法
	@Override 
	public int findUserRowsNum(){
		return sUser.queryUserRowsNum();
	}

 //增加1条记录到书本表格的方法
	@Override
	public int addtUser(E_User user){
		return sUser.insertUser(user);
	}

	//删除用户表格全部记录的方法
	@Override 
	public int delUserAll(){
		return sUser.deleteUserAll();
	}

	//按用户编号删除书本表格记录的方法
	@Override
	public int delUserByUID(int uID){
		return sUser.deleteUserByUID(uID);
	}

	//修改用户表格单条记录的方法
	@Override
	public int updateUser(E_User user){
		return sUser.modifyUser(user);
	}
}