package EB_Model.M_Service.ServiceImp;
import java.io.Serializable;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_DAO.DAO_Entity.DAOImp_E.*;
import EB_Model.M_Service.ServiceInt.*;
public class SImp_Main_Order implements SInt_Main_Order,Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;

	//属性（数据域）封装
	private DAOInt_Order sOrder=new DAOImp_Order();
	
 //无参构造方法
	public SImp_Main_Order(){super();}

	//查询订单表格全部记录的方法
	@Override 
	public ArrayList<E_Order> findOrderAll(){
		return sOrder.queryOrderAll();
	}

	//分页查询订单表格记录的方法
	@Override 
	public ArrayList<E_Order> findOrderByPage(int currentPage, int pageSize){
		return sOrder.queryOrderByPage(currentPage, pageSize);
	}

 //按订单编号查询订单表格记录的方法
	@Override 
	public E_Order findOrderByOID(int oId){
		return sOrder.queryOrderByOID(oId);
	}

	//按用户编号查询订单表格记录的方法
	@Override 
	public ArrayList<E_Order> findOrderByUID(int uID){
		return sOrder.queryOrderByUID(uID);
	}

	//查询订单表格行数的方法
	@Override 
	public int findOrderRowsNum(){
		return sOrder.queryOrderRowsNum();
	}

	//增加1条记录到订单表格的方法
	@Override 
	public int addOrder(E_Order order){
		return sOrder.insertOrder(order);
	}

	//删除订单表格全部记录的方法
	@Override 
	public int delOrderAll(){
		return sOrder.deleteOrderAll();
	}

	//按订单编号删除订单表格记录的方法
	@Override 
	public int delOrderByOID(int oId){
		return sOrder.deleteOrderByOID(oId);
	}

	//修改订单表格单条记录的方法
	@Override
	public int updateOrder(E_Order order){
		return sOrder.modifyOrder(order);
	}
}