package EB_Model.M_Service.ServiceImp;
import java.io.Serializable;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_DAO.DAO_Entity.DAOImp_E.*;
import EB_Model.M_Service.ServiceInt.*;
public class SImp_Main_Product implements SInt_Main_Product,Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;

	//属性（数据域）封装
	private DAOInt_Product sProduct=new DAOImp_Product();
	
 //无参构造方法
	public SImp_Main_Product(){super();}

	//查询商品表格全部记录的方法
	@Override
	public ArrayList<E_Product> findProductAll(){
		return sProduct.queryProductAll();
	}

	//分页查询商品表格记录的方法
	@Override
	public ArrayList<E_Product> findProductByPage(int currentPage, int pageSize){
		return sProduct.queryProductByPage(currentPage, pageSize);
	}
	
	//按商品编号查询商品表格记录的方法
	@Override
	public E_Product findProductByPID(int pID){
		return sProduct.queryProductByPID(pID);
	}

 //按商分类编号查询商品表格记录的方法
	@Override 
	public ArrayList<E_Product> findProductByPCID(int pcID){
		return sProduct.queryProductByPCID(pcID);
	}

 //查询商品表格行数的方法
	@Override
	public int findProductRowsNum(){
		return sProduct.queryProductRowsNum();
	}

	//增加1条记录到商品表格的方法
	@Override
	public int addProduct(E_Product product){
		return sProduct.insertProduct(product);
	}

	//删除商品表格全部记录的方法
	@Override
	public int delProductAll(){
		return sProduct.deleteProductAll();
	}

	//按商品编号删除商品表格记录的方法
	@Override
	public int delProductByPID(int pID){
		return sProduct.deleteProductByPID(pID);
	}

	//修改商品表格单条记录的方法
	@Override
	public int updateProduct(E_Product product){
		return sProduct.modifyProduct(product);
	}
}