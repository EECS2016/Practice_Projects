package EB_Model.M_DAO.DAO_Entity.DAOImp_E;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import EB_Model.M_DAO.DAO_DataBase.DAOImp_DB;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_Entity.*;
import java.sql.SQLException;
//与实体类E_Order对应的DAO层的数据库操作（增删改查等）的接口实现类
public class DAOImp_Order extends DAOImp_DB implements DAOInt_Order,Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;
	
 //无参构造方法
	public DAOImp_Order(){}
	
	//查询订单表格全部记录的方法
	@Override
	public ArrayList<E_Order> queryOrderAll(){
		ArrayList<E_Order> listO=new ArrayList<>();
		String sql="select * from EB_Order";
		try{
			ResultSet rs=query(sql,null);
			while(rs.next()){
				E_Order order=new E_Order();
				order.setOID(rs.getInt(1));
				order.setUID(rs.getString(2));
				order.setUName(rs.getString(3));
				order.setUAddress(rs.getString(4));
				order.setOCreateTime(rs.getTimestamp("OCreateTime"));
				order.setOCost(rs.getFloat(6));
				order.setOStatus(rs.getInt(7));
				listO.add(order);
			}
			rs.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return listO;
	}
	
	//分页查询订单表格记录的方法
	public ArrayList<E_Order> queryOrderByPage(int currentPage,int pageSize){
		ArrayList<E_Order> listO=new ArrayList<>();
		String sql="select * from EB_Order limit ?,?";
		try{
			ResultSet rs=query(sql, new Object[]{(currentPage-1)*pageSize,pageSize});
			while(rs.next()){
				E_Order order=new E_Order();
				order.setOID(rs.getInt(1));
				order.setUID(rs.getString(2));
				order.setUName(rs.getString(3));
				order.setUAddress(rs.getString(4));
				order.setOCreateTime(rs.getTimestamp("OCreateTime"));
				order.setOCost(rs.getFloat(6));
				order.setOStatus(rs.getInt(7));
				listO.add(order);
			}
			rs.close();
		}catch(SQLException e){
		 	e.printStackTrace();		
	 	}
		return listO;
	}	
	
	//按订单编号查询订单表格记录的方法
	@Override
	public E_Order queryOrderByOID(int oID){
		E_Order order=null;
		String sql="select * from EB_Order where OID=?";
		try{
			ResultSet rs=query(sql, new Object[]{oID});
			if(rs.next()){
				order=new E_Order();
				order.setOID(rs.getInt(1));
				order.setUID(rs.getString(2));
				order.setUName(rs.getString(3));
				order.setUAddress(rs.getString(4));
				order.setOCreateTime(rs.getTimestamp("OCreateTime"));
				order.setOCost(rs.getFloat(6));
				order.setOStatus(rs.getInt(7));
			}
			rs.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return order;
	}
	
//按用户编号查询订单表格记录的方法
	@Override
	public ArrayList<E_Order> queryOrderByUID(int uID){
		ArrayList<E_Order> listO=new ArrayList<>();
		String sql="select * from EB_Order where UID=?";
		try{
			ResultSet rs=query(sql, new Object[]{uID});
			while(rs.next()){
				E_Order order=new E_Order();
				order.setOID(rs.getInt(1));
				order.setUID(rs.getString(2));
				order.setUName(rs.getString(3));
				order.setUAddress(rs.getString(4));
				order.setOCreateTime(rs.getTimestamp("OCreateTime"));
				order.setOCost(rs.getFloat(6));
				order.setOStatus(rs.getInt(7));
				listO.add(order);
			}
			rs.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return listO;
	}	
	
 //查询订单表格行数的方法
	@Override 
	public int queryOrderRowsNum(){
		int OrderRowsNum=0;
		String sql="select count(*) from EB_Order";
		try{
			ResultSet rs=query(sql,null);
			if(rs.next()){
				OrderRowsNum=rs.getInt(1);
			}
			rs.close();
		}catch(SQLException ex){
			 ex.printStackTrace();
		 }
		return OrderRowsNum;
	}
	
	//增加1条记录到订单表格的方法
	@Override
	public int insertOrder(E_Order order){
		int n=-1;		
		String sql="insert into EB_Order(UID,UName,UAddress,OCreateTime,OCost,OStatus) values(?,?,?,?,?,?)";
		n=operate(sql,new Object[]{order.getUID(),order.getUName(),order.getUAddress()
			     ,order.getOCreateTime(),order.getOCost(),order.getOStatus()});
		return n;
	}
	
	//删除订单表格全部记录的方法
	@Override
	public int deleteOrderAll(){
		int n=-1;		
		String sql="delete * from EB_Order";
		n=operate(sql,null);
		return n;
	}	
	
	//按订单编号删除订单表格记录的方法
	@Override 
	public int deleteOrderByOID(int oID){
		int n=-1;		
		String sql="delete * from EB_Order where OID=?";
		n=operate(sql,new Object[]{oID});
		return n;
	}
	
	//修改订单表格单条记录的方法
	@Override
	public int modifyOrder(E_Order order){
		int n=-1;
		String sql="update EB_Order set UId=?, UName=? ,UAddress=?,OCreateTime=?,OCost=?, OStatus=? where OID=?";
		n=operate(sql,new Object[]{order.getUID(),order.getUName(),order.getUAddress()
   ,order.getOCreateTime(),order.getOCost(),order.getOStatus(),order.getOID()});
		return n;
	}
}