package EB_Model.M_DAO.DAO_Entity.DAOInt_E;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//与实体类E_Product对应的DAO层的数据库操作（增删改查等）的公共接口
public interface DAOInt_Product{
	//查询商品表格全部记录的方法
	ArrayList<E_Product> queryProductAll();
	
	//分页查询商品表格记录的方法
	ArrayList<E_Product> queryProductByPage(int currentPage,int pageSize);
	
	//按商品编号查询商品表格记录的方法
	E_Product queryProductByPID(int pID);
	
 //按商分类编号查询商品表格记录的方法
	ArrayList<E_Product> queryProductByPCID(int pcID);
	
 //查询商品表格行数的方法
	int queryProductRowsNum();
	
	//增加1条记录到商品表格的方法
	int insertProduct(E_Product product);
	
	//删除商品表格全部记录的方法
	int deleteProductAll();
	
	//按商品编号删除商品表格记录的方法
	int deleteProductByPID(int pID);
	
	//修改商品表格单条记录的方法
	int modifyProduct(E_Product product);
}