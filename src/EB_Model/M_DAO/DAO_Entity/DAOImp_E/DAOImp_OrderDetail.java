package EB_Model.M_DAO.DAO_Entity.DAOImp_E;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import EB_Model.M_DAO.DAO_DataBase.DAOImp_DB;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_Entity.*;
import java.sql.SQLException;
//与实体类E_OrderDetail对应的DAO层的数据库操作（增删改查等）的接口实现类
public class DAOImp_OrderDetail extends DAOImp_DB implements DAOInt_OrderDetail,Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;
	
 //无参构造方法
 public DAOImp_OrderDetail(){}
 
 //查询订单详情表格全部记录的方法
	@Override
	public ArrayList<E_OrderDetail> queryOrderDetailAll(){
		ArrayList<E_OrderDetail> listOD=new ArrayList<>();
		String sql="select * from EB_OrderDetail";
		try{
			ResultSet rs=query(sql,null);
			while(rs.next()){
				E_OrderDetail orderdetail=new E_OrderDetail();
				orderdetail.setODID(rs.getInt(1));
				orderdetail.setOID(rs.getInt(2));
				orderdetail.setPID(rs.getInt(3));
				orderdetail.setODPQuantity(rs.getInt(4));
				orderdetail.setOCost(rs.getFloat(5));
				listOD.add(orderdetail);
			}
			rs.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return listOD;
	}
	
	//分页查询订单详情表格记录的方法
	public ArrayList<E_OrderDetail> queryOrderDetailByPage(int currentPage,int pageSize){
		ArrayList<E_OrderDetail> listOD=new ArrayList<>();
		String sql="select * from EB_OrderDetail limit ?,?";
		try{
			ResultSet rs=query(sql, new Object[]{(currentPage-1)*pageSize,pageSize});
			while(rs.next()){
				E_OrderDetail orderdetail=new E_OrderDetail();
				orderdetail.setODID(rs.getInt(1));
				orderdetail.setOID(rs.getInt(2));
				orderdetail.setPID(rs.getInt(3));
				orderdetail.setODPQuantity(rs.getInt(4));
				orderdetail.setOCost(rs.getFloat(5));
				listOD.add(orderdetail);
			}
			rs.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return listOD;
	}	
	
//按订单详情编号查询订单详情表格记录的方法
	@Override
	public E_OrderDetail queryOrderDetailByODID(int odID){
		E_OrderDetail orderdetail=null;
		String sql="select * from EB_OrderDetail where ODID=?";
		try{
			ResultSet rs=query(sql, new Object[]{odID});
			if(rs.next()){
				orderdetail=new E_OrderDetail();
				orderdetail.setODID(rs.getInt(1));
				orderdetail.setOID(rs.getInt(2));
				orderdetail.setPID(rs.getInt(3));
				orderdetail.setODPQuantity(rs.getInt(4));
				orderdetail.setOCost(rs.getFloat(5));
			}
			rs.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return orderdetail;
	}
	
//按订单编号查询订单详情表格记录的方法
	@Override
	public ArrayList<E_OrderDetail> queryOrderDetailByOID(int oID){
		ArrayList<E_OrderDetail> listOD=new ArrayList<>();
		String sql="select * from EB_OrderDetail where OID=?";
		try{
			ResultSet rs=query(sql,new Object[]{oID});
			while(rs.next()){
				E_OrderDetail orderdetail=new E_OrderDetail();
				orderdetail.setODID(rs.getInt(1));
				orderdetail.setOID(rs.getInt(2));
				orderdetail.setPID(rs.getInt(3));
				orderdetail.setODPQuantity(rs.getInt(4));
				orderdetail.setOCost(rs.getFloat(5));
				listOD.add(orderdetail);
			}
			rs.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return listOD;
	}
	
 //查询订单详情表格行数的方法
	@Override 
	public int queryOrderDetailRowsNum(){
		int OrderDetailRowsNum=0;
		String sql="select count(*) from EB_OrderDetail";
		try{
			ResultSet rs=query(sql,null);
			if(rs.next()){
				OrderDetailRowsNum=rs.getInt(1);
			}
			rs.close();
		}catch(SQLException ex){
			 ex.printStackTrace();
		 }
		return OrderDetailRowsNum;
	}
	
	//增加1条记录到订单详情表格的方法
	@Override
	public int insertOrderDetail(E_OrderDetail orderdetail){
		int n=-1;		
		String sql="insert into EB_OrderDetail(OID,PID,ODPQuantity,OCost) values(?,?,?,?)";
		n=operate(sql,new Object[]{orderdetail.getOID(),orderdetail.getPID(),orderdetail.getODPQuantity(),orderdetail.getOCost()});
		return n;
	}

	//删除订单详情表格全部记录的方法
	@Override
	public int deleteOrderDetailAll(){
		int n=-1;
		String sql="delete * from EB_OrderDetail";
		n=operate(sql,null);
		return n;
	}
	
	//按订单详情编号删除订单详情表格记录的方法
	@Override 
	public int deleteOrderDetailByODID(int odID){
		int n=-1;
		String sql="delete * from EB_OrderDetail where ODID=?";
		n=operate(sql, new Object[]{odID});
		return n;
	}
	
	//修改订单详情表格单条记录的方法
	@Override
	public int modifyOrderDetail(E_OrderDetail orderdetail){
		int n=-1;
		String sql="update EB_OrderDetail set OID=?,PID=?,ODPQuantity=? ,OCost=? where ODID=?";
		n=operate(sql,new Object[]{orderdetail.getOID(),orderdetail.getPID(),orderdetail.getODPQuantity()
			     ,orderdetail.getOCost(),orderdetail.getODID()});
		return n;
	}
}