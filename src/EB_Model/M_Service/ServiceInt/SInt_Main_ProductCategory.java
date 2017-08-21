package EB_Model.M_Service.ServiceInt;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//主要与实体类E_ProductCategory对应的Service层的公共接口
public interface SInt_Main_ProductCategory{
	//查询商品分类表格全部记录的方法
	ArrayList<E_ProductCategory> findProductCategoryAll();
	
	//分页查询商品分类表格记录的方法
	ArrayList<E_ProductCategory> findProductCategoryByPage(int currentPage,int pageSize);
	
 //按商品分类编号查询商品分类表格记录的方法
 E_ProductCategory findProductCategoryByPCID(String pcID);

 //查询商品分类表格行数的方法
	int findProductCategoryRowsNum();
	
	//增加1条记录到商品分类表格的方法
	int addProductCategory(E_ProductCategory productcategory);
	
	//删除商品分类表格全部记录的方法
	int delProductCategoryAll();
	
	//按商品分类编号删除商品分类表格记录的方法
	int delProductCategoryByPCID(String pcID);
	
	//修改商品分类表格单条记录的方法
	int updateProductCategory(E_ProductCategory productcategory);
}