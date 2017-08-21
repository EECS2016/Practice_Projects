package EB_Model.M_Service.ServiceImp;
import java.io.Serializable;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_DAO.DAO_Entity.DAOImp_E.*;
import EB_Model.M_Service.ServiceInt.*;
public class SImp_Main_OrderDetail implements SInt_Main_OrderDetail,Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;

	//属性（数据域）封装
	private DAOInt_OrderDetail sOrderDetail=new DAOImp_OrderDetail();
	
 //无参构造方法
	public SImp_Main_OrderDetail(){super();}

 //查询订单详情表格全部记录的方法
	@Override 
	public ArrayList<E_OrderDetail> findOrderDetailAll(){
		return sOrderDetail.queryOrderDetailAll();
	}

	//分页查询订单详情表格记录的方法
	@Override
	public ArrayList<E_OrderDetail> findOrderDetailByPage(int currentPage, int pageSize){
		return sOrderDetail.queryOrderDetailByPage(currentPage, pageSize);
	}

 //按订单详情编号查询订单详情表格记录的方法
	@Override 
	public E_OrderDetail findOrderDetailByODID(int odID){
		return sOrderDetail.queryOrderDetailByODID(odID);
	}

 //按订单编号查询订单详情表格记录的方法
	@Override 
	public ArrayList<E_OrderDetail> findOrderDetailByOID(int oID){
		return sOrderDetail.queryOrderDetailByOID(oID);
	}

 //查询订单详情表格行数的方法
	@Override 
	public int findOrderDetailRowsNum(){
		return sOrderDetail.queryOrderDetailRowsNum();
	}

	//增加1条记录到订单详情表格的方法
	@Override 
	public int addOrderDetail(E_OrderDetail orderdetail){
		return sOrderDetail.insertOrderDetail(orderdetail);
	}

	//删除订单详情表格全部记录的方法
	@Override
	public int delOrderDetailAll(){
		return sOrderDetail.deleteOrderDetailAll();
	}

	//按订单详情编号删除订单详情表格记录的方法
	@Override 
	public int delOrderDetailByODID(int odID){
		return sOrderDetail.deleteOrderDetailByODID(odID);
	}

	//修改订单详情表格单条记录的方法
	@Override
	public int updateOrderDetail(E_OrderDetail orderdetail){
		return sOrderDetail.modifyOrderDetail(orderdetail);
	}
}