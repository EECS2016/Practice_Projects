
package EB_Model.M_DAO.DAO_Entity.DAOImp_E;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import EB_Model.M_DAO.DAO_DataBase.DAOImp_DB;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_Entity.*;
import java.sql.SQLException;
//��ʵ����E_ProductCategory��Ӧ��DAO������ݿ��������ɾ�Ĳ�ȣ��Ľӿ�ʵ����
public class DAOImp_ProductCategory extends DAOImp_DB implements DAOInt_ProductCategory,Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;
	
 //�޲ι��췽��
	public DAOImp_ProductCategory(){}
	
	//��ѯ��Ʒ������ȫ����¼�ķ���
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
	
//��ҳ��ѯ��Ʒ�������¼�ķ���
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
	
 //����Ʒ�����Ų�ѯ��Ʒ�������¼�ķ���
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
	
 //��ѯ��Ʒ�����������ķ���
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
	
	//����1����¼����Ʒ������ķ���
	@Override 
	public int insertProductCategory(E_ProductCategory productcategory){
		int n=-1;		
		String sql="insert into EB_ProductCategory(PCName,PCParentID) values(?,?)";
		n=operate(sql,new Object[]{productcategory.getPCName(),productcategory.getPCParentID()});
		return n;
	}
	
	//ɾ����Ʒ������ȫ����¼�ķ���
	@Override
	public int deleteProductCategoryAll(){
		int n=-1;		
		String sql="delete * from EB_ProductCategory";
		n=operate(sql,null);
		return n;
	}
	
	//����Ʒ������ɾ����Ʒ�������¼�ķ���
	@Override 
	public int deleteProductCategoryByPCID(String pcID){
		int n=-1;		
		String sql="delete * from EB_ProductCategory where PCID=?";
		n=operate(sql,new Object[]{pcID});
		return n;
	}
	
	//�޸���Ʒ����������¼�ķ���
	@Override
	public int modifyProductCategory(E_ProductCategory productcategory){
		int n=-1;
		String sql="update EB_ProductCategory set PCName=? ,PCParentID=? where PCID=?";
		n=operate(sql,new Object[]{productcategory.getPCName(),productcategory.getPCParentID(),productcategory.getPCID()});
		return n;
	}
}