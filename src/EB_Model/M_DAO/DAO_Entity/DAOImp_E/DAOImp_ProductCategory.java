
package EB_Model.M_DAO.DAO_Entity.DAOImp_E;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import EB_Model.M_DAO.DAO_DataBase.DAOImp_DB;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_Entity.*;
import java.sql.SQLException;
//与实体类E_ProductCategory对应的DAO层的数据库操作（增删改查等）的接口实现类
public class DAOImp_ProductCategory extends DAOImp_DB implements DAOInt_ProductCategory,Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;
	
 //无参构造方法
	public DAOImp_ProductCategory(){}
	
	//查询商品分类表格全部记录的方法
	@Override
	public ArrayList<E_ProductCategory> queryProductCategoryAll(){
		ArrayList<E_ProductCategory> listPC=new ArrayList<>();
		String sql="select * from EB_ProductCategory";
		try{
			ResultSet rs=query(sql,null);
			while(rs.next()){
				E_ProductCategory productcategory=new E_ProductCategory();
				productcategory.setPCID(rs.getInt(1));
				productcategory.setPCName(rs.getString(2));
				productcategory.setPCParentID(rs.getInt(3));
				listPC.add(productcategory);
			}
			rs.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return listPC;
	}
	
//分页查询商品分类表格记录的方法
	@Override 
	public ArrayList<E_ProductCategory> queryProductCategoryByPage(int currentPage,int pageSize){
		ArrayList<E_ProductCategory> listPC=new ArrayList<>();
		String sql="select * from EB_ProductCategory limit ?,?";
		try{
			ResultSet rs=query(sql, new Object[]{(currentPage-1)*pageSize,pageSize});
			while(rs.next()){
				E_ProductCategory productcategory=new E_ProductCategory();
				productcategory.setPCID(rs.getInt(1));
				productcategory.setPCName(rs.getString(2));
				productcategory.setPCParentID(rs.getInt(3));
				listPC.add(productcategory);
			}
			rs.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return listPC;
	}
	
 //按商品分类编号查询商品分类表格记录的方法
	@Override 
	public E_ProductCategory queryProductCategoryByPCID(String pcID){
		E_ProductCategory productcategory=null;
		String sql="select * from EB_ProductCategory where PCID=?";
		try{
			ResultSet rs=query(sql, new Object[]{pcID});
			if(rs.next()){
				productcategory=new E_ProductCategory();
				productcategory.setPCID(rs.getInt(1));
				productcategory.setPCName(rs.getString(2));
				productcategory.setPCParentID(rs.getInt(3));
			}
			rs.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return productcategory;
	}
	
 //查询商品分类表格行数的方法
	@Override 
	public int queryProductCategoryRowsNum(){
		int ProductCategoryRowsNum=0;
		String sql="select count(*) from EB_ProductCategory";
		try{
			ResultSet rs=query(sql,null);
			if(rs.next()){
				ProductCategoryRowsNum=rs.getInt(1);
			}	
			rs.close();
		}catch(SQLException ex){
			 ex.printStackTrace();
		 }
		return ProductCategoryRowsNum;
	}	
	
	//增加1条记录到商品分类表格的方法
	@Override 
	public int insertProductCategory(E_ProductCategory productcategory){
		int n=-1;		
		String sql="insert into EB_ProductCategory(PCName,PCParentID) values(?,?)";
		n=operate(sql,new Object[]{productcategory.getPCName(),productcategory.getPCParentID()});
		return n;
	}
	
	//删除商品分类表格全部记录的方法
	@Override
	public int deleteProductCategoryAll(){
		int n=-1;		
		String sql="delete * from EB_ProductCategory";
		n=operate(sql,null);
		return n;
	}
	
	//按商品分类编号删除商品分类表格记录的方法
	@Override 
	public int deleteProductCategoryByPCID(String pcID){
		int n=-1;		
		String sql="delete * from EB_ProductCategory where PCID=?";
		n=operate(sql,new Object[]{pcID});
		return n;
	}
	
	//修改商品分类表格单条记录的方法
	@Override
	public int modifyProductCategory(E_ProductCategory productcategory){
		int n=-1;
		String sql="update EB_ProductCategory set PCName=? ,PCParentID=? where PCID=?";
		n=operate(sql,new Object[]{productcategory.getPCName(),productcategory.getPCParentID(),productcategory.getPCID()});
		return n;
	}
}