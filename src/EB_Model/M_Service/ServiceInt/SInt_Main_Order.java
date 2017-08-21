
package EB_Model.M_Service.ServiceInt;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//主要与实体类E_Order对应的Service层的公共接口
public interface SInt_Main_Order{
	//查询订单表格全部记录的方法
	ArrayList<E_Order> findOrderAll();
	
	//分页查询订单表格记录的方法
	ArrayList<E_Order> findOrderByPage(int currentPage,int pageSize);
	
 //按订单编号查询订单表格记录的方法
	E_Order findOrderByOID(int oId);
	
	//按用户编号查询订单表格记录的方法
	ArrayList<E_Order> findOrderByUID(int uID);

	//查询订单表格行数的方法
	int findOrderRowsNum();
	
	//增加1条记录到订单表格的方法
	int addOrder(E_Order order);
	
	//删除订单表格全部记录的方法
	int delOrderAll();	
	
	//按订单编号删除订单表格记录的方法
	int delOrderByOID(int oId);
	
	//修改订单表格单条记录的方法
	int updateOrder(E_Order order);
}