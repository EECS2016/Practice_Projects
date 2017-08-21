package EB_Model.M_Service.ServiceInt;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//主要与实体类E_OrderDetail对应的Service层的公共接口
public interface SInt_Main_OrderDetail{
 //查询订单详情表格全部记录的方法
	ArrayList<E_OrderDetail> findOrderDetailAll();
	
	//分页查询订单详情表格记录的方法
	ArrayList<E_OrderDetail> findOrderDetailByPage(int currentPage,int pageSize);
	
 //按订单详情编号查询订单详情表格记录的方法
	E_OrderDetail findOrderDetailByODID(int odID);
	
 //按订单编号查询订单详情表格记录的方法
	ArrayList<E_OrderDetail> findOrderDetailByOID(int oID);	
	
 //查询订单详情表格行数的方法
	int findOrderDetailRowsNum();
	
	//增加1条记录到订单详情表格的方法
	int addOrderDetail(E_OrderDetail orderdetail);
	
	//删除订单详情表格全部记录的方法
	int delOrderDetailAll();	
	
	//按订单详情编号删除订单详情表格记录的方法
	int delOrderDetailByODID(int odID);
	
	//修改订单详情表格单条记录的方法
	int updateOrderDetail(E_OrderDetail orderdetail);
}