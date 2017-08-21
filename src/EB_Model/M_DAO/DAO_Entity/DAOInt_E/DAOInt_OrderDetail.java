package EB_Model.M_DAO.DAO_Entity.DAOInt_E;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//与实体类E_OrderDetail对应的DAO层的数据库操作（增删改查等）的公共接口
public interface DAOInt_OrderDetail{
 //查询订单详情表格全部记录的方法
	ArrayList<E_OrderDetail> queryOrderDetailAll();
	
	//分页查询订单详情表格记录的方法
	ArrayList<E_OrderDetail> queryOrderDetailByPage(int currentPage,int pageSize);
	
//按订单详情编号查询订单详情表格记录的方法
	E_OrderDetail queryOrderDetailByODID(int odID);
	
//按订单编号查询订单详情表格记录的方法
	ArrayList<E_OrderDetail> queryOrderDetailByOID(int oID);	
	
 //查询订单详情表格行数的方法
	int queryOrderDetailRowsNum();
	
	//增加1条记录到订单详情表格的方法
	int insertOrderDetail(E_OrderDetail orderdetail);
	
	//删除订单详情表格全部记录的方法
	int deleteOrderDetailAll();	
	
	//按订单详情编号删除订单详情表格记录的方法
	int deleteOrderDetailByODID(int odID);
	
	//修改订单详情表格单条记录的方法
	int modifyOrderDetail(E_OrderDetail orderdetail);
}