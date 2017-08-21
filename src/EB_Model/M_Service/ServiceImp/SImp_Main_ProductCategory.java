package EB_Model.M_Service.ServiceImp;
import java.io.Serializable;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_DAO.DAO_Entity.DAOImp_E.*;
import EB_Model.M_Service.ServiceInt.*;
public class SImp_Main_ProductCategory implements SInt_Main_ProductCategory,Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;

	//属性（数据域）封装
	private DAOInt_ProductCategory sProductCategory=new DAOImp_ProductCategory();
	
 //无参构造方法
	public SImp_Main_ProductCategory(){super();}

	//查询商品分类表格全部记录的方法
	@Override 
	public ArrayList<E_ProductCategory> findProductCategoryAll(){
		return sProductCategory.queryProductCategoryAll();
	}

	//分页查询商品分类表格记录的方法
	@Override
	public ArrayList<E_ProductCategory> findProductCategoryByPage(int currentPage, int pageSize){
		return sProductCategory.queryProductCategoryByPage(currentPage, pageSize);
	}

 //按商品分类编号查询商品分类表格记录的方法
	@Override 
	public E_ProductCategory findProductCategoryByPCID(String pcID){
		return sProductCategory.queryProductCategoryByPCID(pcID);
	}

 //查询商品分类表格行数的方法
	@Override
	public int findProductCategoryRowsNum(){
		return sProductCategory.queryProductCategoryRowsNum();
	}

	//增加1条记录到商品分类表格的方法
	@Override 
	public int addProductCategory(E_ProductCategory productcategory){
		return sProductCategory.insertProductCategory(productcategory);
	}

	//删除商品分类表格全部记录的方法
	@Override
	public int delProductCategoryAll(){
		return sProductCategory.deleteProductCategoryAll();
	}

	//按商品分类编号删除商品分类表格记录的方法
	@Override
	public int delProductCategoryByPCID(String pcID){
		return sProductCategory.deleteProductCategoryByPCID(pcID);
	}

	//修改商品分类表格单条记录的方法
	@Override
	public int updateProductCategory(E_ProductCategory productcategory){
		return sProductCategory.modifyProductCategory(productcategory);
	}
}