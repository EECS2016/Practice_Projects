package EB_Model.M_DAO.DAO_Entity.DAOInt_E;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//与实体类E_ProductCategory对应的DAO层的数据库操作（增删改查等）的公共接口
public interface DAOInt_ProductCategory{
	//查询商品分类表格全部记录的方法
	ArrayList<E_ProductCategory> queryProductCategoryAll();
	
	//分页查询商品分类表格记录的方法
	ArrayList<E_ProductCategory> queryProductCategoryByPage(int currentPage,int pageSize);
	
 //按商品分类编号查询商品分类表格记录的方法
 E_ProductCategory queryProductCategoryByPCID(String pcID);

 //查询商品分类表格行数的方法
	int queryProductCategoryRowsNum();
	
	//增加1条记录到商品分类表格的方法
	int insertProductCategory(E_ProductCategory productcategory);
	
	//删除商品分类表格全部记录的方法
	int deleteProductCategoryAll();
	
	//按商品分类编号删除商品分类表格记录的方法
	int deleteProductCategoryByPCID(String pcID);
	
	//修改商品分类表格单条记录的方法
	int modifyProductCategory(E_ProductCategory productcategory);
}