
package EB_Model.M_DAO.DAO_Entity.DAOImp_E;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import EB_Model.M_DAO.DAO_DataBase.DAOImp_DB;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_Entity.*;
import java.sql.SQLException;
import java.sql.Timestamp;
//与实体类E_User对应的DAO层的数据库操作（增删改查等）的接口实现类
public class DAOImp_User extends DAOImp_DB implements DAOInt_User,Serializable{
	private static final long serialVersionUID=1L;
	
	//无参构造方法
	public DAOImp_User(){super();}

	//查询用户表格全部记录的方法
	@Override 
	public ArrayList<E_User> queryUserAll(){
		ArrayList<E_User> listU=new ArrayList<>();
		String sql="select * from EB_User";
		try{
			ResultSet rs=query(sql,null);
			while(rs.next()){
				E_User user=new E_User();
				user.setUID(rs.getString(1));
				user.setUName(rs.getString(2));
				user.setUPassword(rs.getString(3));
				user.setUSex(rs.getString(4));
				user.setUBirthday(rs.getTimestamp("UBirthday"));
				user.setUIdentityCode(rs.getString(6));
				user.setUEmail(rs.getString(7));
				user.setUMobile(rs.getString(8));
				user.setUAddress(rs.getString(9));
				user.setULogin(rs.getInt(10));
				user.setUType(rs.getInt(11));
				listU.add(user);
			}
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return listU;
	}

//分页查询用户表格记录的方法
	@Override 
	public ArrayList<E_User> queryUserByPage(int currentPage,int pageSize){
		ArrayList<E_User> listU=new ArrayList<>();
		String sql="select * from EB_User limit ?,?";
		try{
			ResultSet rs=query(sql, new Object[]{(currentPage-1)*pageSize,pageSize});
			while(rs.next()){
				E_User user=new E_User();
				user.setUID(rs.getString(1));
				user.setUName(rs.getString(2));
				user.setUPassword(rs.getString(3));
				user.setUSex(rs.getString(4));
				user.setUBirthday(rs.getTimestamp("UBirthday"));
				user.setUIdentityCode(rs.getString(6));
				user.setUEmail(rs.getString(7));
				user.setUMobile(rs.getString(8));
				user.setUAddress(rs.getString(9));
				user.setULogin(rs.getInt(10));
				user.setUType(rs.getInt(11));
				listU.add(user);
			}
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return listU;
	}
	
	//按用户编号查询用户表格记录的方法
	@Override 
	public E_User queryUserByUID(int uID){
		E_User user=null;
		String sql="select * from EB_User where UID=?";
		try{
			ResultSet rs=query(sql, new Object[]{uID});
			if(rs.next()){
				user=new E_User();
				user.setUID(rs.getString(1));
				user.setUName(rs.getString(2));
				user.setUPassword(rs.getString(3));
				user.setUSex(rs.getString(4));
				user.setUBirthday(rs.getTimestamp("UBirthday"));
				user.setUIdentityCode(rs.getString(6));
				user.setUEmail(rs.getString(7));
				user.setUMobile(rs.getString(8));
				user.setUAddress(rs.getString(9));
				user.setULogin(rs.getInt(10));
				user.setUType(rs.getInt(11));
			}
			rs.close();
		}catch(SQLException ex){
			 ex.printStackTrace();
		 }
		return user;
	}
	
	//按用户名称查询用户表格记录的方法
	@Override 
	public ArrayList<E_User> queryUserByUName(String uName){
		ArrayList<E_User> listU=new ArrayList<>();
		String sql="select * from EB_User where UName=?";
		try{
			ResultSet rs=query(sql, new Object[]{uName});
			while(rs.next()){
				E_User user=new E_User();
				user.setUID(rs.getString(1));
				user.setUName(rs.getString(2));
				user.setUPassword(rs.getString(3));
				user.setUSex(rs.getString(4));
				user.setUBirthday(rs.getTimestamp("UBirthday"));
				user.setUIdentityCode(rs.getString(6));
				user.setUEmail(rs.getString(7));
				user.setUMobile(rs.getString(8));
				user.setUAddress(rs.getString(9));
				user.setULogin(rs.getInt(10));
				user.setUType(rs.getInt(11));
				listU.add(user);
			}
			rs.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return listU;	
	}
	
 //查询用户表格行数的方法
	@Override 
	public int queryUserRowsNum(){
		int UserRowsNum=0;
		String sql="select count(*) from EB_User";
		try{
			ResultSet rs=query(sql,null);
			if(rs.next()){
			 UserRowsNum=rs.getInt(1);
			}
			rs.close();
		}catch(SQLException ex){
			 ex.printStackTrace();
		 }
		return UserRowsNum;
	}
	
 //增加1条记录到书本表格的方法
	@Override 
	public int insertUser(E_User user){
		int n=-1;
		String sql="insert into EB_User(UName,UPassword,USex,UBirthday,UIdentityCode,UEmail,UMobile,UAddress,ULogin,UType) "
			          + "values(?,?,?,?,?,?,?,?,?,?)";
		n=operate(sql, new Object[]{user.getUName(), user.getUPassword(), user.getUSex(), new Timestamp(user.getUBirthday().getTime())
			     ,user.getUIdentityCode(), user.getUEmail(), user.getUMobile(), user.getUAddress(),user.getULogin(), user.getUType()});
		return n;
	}
	
	//删除用户表格全部记录的方法
	@Override
	public int deleteUserAll(){
		int n=-1;
		String sql="delete * from EB_User";
		n=operate(sql,null);
		return n;
	}
	
	//按用户编号删除书本表格记录的方法
	@Override
	public int deleteUserByUID(int uID){
		int n=-1;
		String sql="delete * from EB_User where UID=?";
		n=operate(sql, new Object[]{uID});
		return n;
	}
	
	//修改用户表格单条记录的方法
	@Override 
	public int modifyUser(E_User user){
		int n=-1;
		String sql="update EB_User set UName=?,UPassword=?,USex=?,UBirthday=?,UIdentityCode=?"
			          + "UEmail=?,UMobile=?,UAddress=?,ULogin=?,UType=? where UID=?";
		n=operate(sql, new Object[]{user.getUName(), user.getUPassword(), user.getUSex(), new Timestamp(user.getUBirthday().getTime())
   ,user.getUIdentityCode(), user.getUEmail(), user.getUMobile(), user.getUAddress()
   ,user.getULogin(),user.getUType(),user.getUID()});
		return n;
	}
}