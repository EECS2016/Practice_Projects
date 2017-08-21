package EB_Model.M_DAO.DAO_Entity.DAOImp_E;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import EB_Model.M_DAO.DAO_DataBase.DAOImp_DB;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_Entity.*;
import java.sql.SQLException;
//��ʵ����E_Order��Ӧ��DAO������ݿ��������ɾ�Ĳ�ȣ��Ľӿ�ʵ����
public class DAOImp_Order extends DAOImp_DB implements DAOInt_Order,Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;
	
 //�޲ι��췽��
	public DAOImp_Order(){}
	
	//��ѯ�������ȫ����¼�ķ���
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
	
	//��ҳ��ѯ��������¼�ķ���
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
	
	//��������Ų�ѯ��������¼�ķ���
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
	
//���û���Ų�ѯ��������¼�ķ���
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
	
 //��ѯ������������ķ���
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
	
	//����1����¼���������ķ���
	@Override
	public int insertOrder(E_Order order){
		int n=-1;		
		String sql="insert into EB_Order(UID,UName,UAddress,OCreateTime,OCost,OStatus) values(?,?,?,?,?,?)";
		n=operate(sql,new Object[]{order.getUID(),order.getUName(),order.getUAddress()
			     ,order.getOCreateTime(),order.getOCost(),order.getOStatus()});
		return n;
	}
	
	//ɾ���������ȫ����¼�ķ���
	@Override
	public int deleteOrderAll(){
		int n=-1;		
		String sql="delete * from EB_Order";
		n=operate(sql,null);
		return n;
	}	
	
	//���������ɾ����������¼�ķ���
	@Override 
	public int deleteOrderByOID(int oID){
		int n=-1;		
		String sql="delete * from EB_Order where OID=?";
		n=operate(sql,new Object[]{oID});
		return n;
	}
	
	//�޸Ķ����������¼�ķ���
	@Override
	public int modifyOrder(E_Order order){
		int n=-1;
		String sql="update EB_Order set UId=?, UName=? ,UAddress=?,OCreateTime=?,OCost=?, OStatus=? where OID=?";
		n=operate(sql,new Object[]{order.getUID(),order.getUName(),order.getUAddress()
   ,order.getOCreateTime(),order.getOCost(),order.getOStatus(),order.getOID()});
		return n;
	}
}