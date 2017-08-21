
package EB_Model.M_Service.ServiceInt;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//主要与实体类E_Product对应的Service层的公共接口
public interface SInt_Main_Product{
	//查询商品表格全部记录的方法
	ArrayList<E_Product> findProductAll();
	
	//分页查询商品表格记录的方法
	ArrayList<E_Product> findProductByPage(int currentPage,int pageSize);
	
	//按商品编号查询商品表格记录的方法
	E_Product findProductByPID(int pID);
	
 //按商分类编号查询商品表格记录的方法
	ArrayList<E_Product> findProductByPCID(int pcID);
	
 //查询商品表格行数的方法
	int findProductRowsNum();
	
	//增加1条记录到商品表格的方法
	int addProduct(E_Product product);
	
	//删除商品表格全部记录的方法
	int delProductAll();
	
	//按商品编号删除商品表格记录的方法
	int delProductByPID(int pID);
	
	//修改商品表格单条记录的方法
	int updateProduct(E_Product product);
}