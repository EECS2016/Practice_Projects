package EB_Model.M_DAO.DAO_Entity.DAOInt_E;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//与实体类E_Order对应的DAO层的数据库操作（增删改查等）的公共接口
public interface DAOInt_Order{
	//查询订单表格全部记录的方法
	ArrayList<E_Order> queryOrderAll();
	
	//分页查询订单表格记录的方法
	ArrayList<E_Order> queryOrderByPage(int currentPage,int pageSize);
	
 //按订单编号查询订单表格记录的方法
	E_Order queryOrderByOID(int oId);
	
	//按用户编号查询订单表格记录的方法
	ArrayList<E_Order> queryOrderByUID(int uID);

	//查询订单表格行数的方法
	int queryOrderRowsNum();
	
	//增加1条记录到订单表格的方法
	int insertOrder(E_Order order);
	
	//删除订单表格全部记录的方法
	int deleteOrderAll();	
	
	//按订单编号删除订单表格记录的方法
	int deleteOrderByOID(int oId);
	
	//修改订单表格单条记录的方法
	int modifyOrder(E_Order order);
}