package EB_Model.M_DAO.DAO_Entity.DAOImp_E;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import EB_Model.M_DAO.DAO_DataBase.DAOImp_DB;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_Entity.*;
import java.sql.SQLException;
//��ʵ����E_Product��Ӧ��DAO������ݿ��������ɾ�Ĳ�ȣ��Ľӿ�ʵ����
public class DAOImp_Product extends DAOImp_DB implements DAOInt_Product,Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;
	
 //�޲ι��췽��	
	public DAOImp_Product(){}
	
	//��ѯ��Ʒ���ȫ����¼�ķ���
	@Override 
	public ArrayList<E_Product> queryProductAll(){
		ArrayList<E_Product> listP=new ArrayList<>();
		String sql="select * from EB_Product";
		try{
			ResultSet rs=query(sql,null);
			while(rs.next()){
				E_Product product=new E_Product();
				product=new E_Product();
				product.setPID(rs.getInt(1));
				product.setPName(rs.getString(2));
				product.setPDescription(rs.getString(3));
				product.setPPrice(rs.getFloat(4));
				product.setPStock(rs.getInt(5));
				product.setPCID(rs.getInt(6));
				product.setPCChildID(rs.getInt(7));
				product.setPUploadFileName(rs.getString(8));
				listP.add(product);
			}
			rs.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return listP;
	}
	
 //��ҳ��ѯ��Ʒ����¼�ķ���
	@Override 	
	public ArrayList<E_Product> queryProductByPage(int currentPage,int pageSize){
		ArrayList<E_Product> listP=new ArrayList<>();
		String sql="select * from EB_Product limit ?,?";
		try{
			ResultSet rs=query(sql, new Object[]{(currentPage-1)*pageSize,pageSize});
			while(rs.next()){
				E_Product product=new E_Product();
				product=new E_Product();
				product.setPID(rs.getInt(1));
				product.setPName(rs.getString(2));
				product.setPDescription(rs.getString(3));
				product.setPPrice(rs.getFloat(4));
				product.setPStock(rs.getInt(5));
				product.setPCID(rs.getInt(6));
				product.setPCChildID(rs.getInt(7));
				product.setPUploadFileName(rs.getString(8));
				listP.add(product);
			}
			rs.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return listP;
	}
			
//����Ʒ��Ų�ѯ��Ʒ����¼�ķ���
	@Override
	public E_Product queryProductByPID(int pID){
		E_Product product=null;
		String sql="select * from EB_Product where PID=?";
		try{
			ResultSet rs=query(sql, new Object[]{pID});
			if(rs.next()){
				product=new E_Product();
				product.setPID(rs.getInt(1));
				product.setPName(rs.getString(2));
				product.setPDescription(rs.getString(3));
				product.setPPrice(rs.getFloat(4));
				product.setPStock(rs.getInt(5));
				product.setPCID(rs.getInt(6));
				product.setPCChildID(rs.getInt(7));
				product.setPUploadFileName(rs.getString(8));
			}
			rs.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return product;
	}
	
//����Ʒ�����Ų�ѯ��Ʒ����¼�ķ���
	@Override 
	public ArrayList<E_Product> queryProductByPCID(int pcID){
		ArrayList<E_Product> listP=new ArrayList<>();
		String sql="select * from EB_Product where PCID=?";
		try{
			ResultSet rs=query(sql, new Object[]{pcID});
			while(rs.next()){
				E_Product product=new E_Product();
				product=new E_Product();
				product.setPID(rs.getInt(1));
				product.setPName(rs.getString(2));
				product.setPDescription(rs.getString(3));
				product.setPPrice(rs.getFloat(4));
				product.setPStock(rs.getInt(5));
				product.setPCID(rs.getInt(6));
				product.setPCChildID(rs.getInt(7));
				product.setPUploadFileName(rs.getString(8));
				listP.add(product);
			}
			rs.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return listP;
	}

 //��ѯ��Ʒ��������ķ���
	@Override 
	public int queryProductRowsNum(){
		int ProductRowsNum=0;
		String sql="select count(*) from EB_Product";
		try{
			ResultSet rs=query(sql,null);
			if(rs.next()){
				ProductRowsNum=rs.getInt(1);
			}
			rs.close();
		}catch(SQLException ex){
			 ex.printStackTrace();
		 }
		return ProductRowsNum;
	}
	
	//����1����¼����Ʒ���ķ���
	@Override 
	public int insertProduct(E_Product product){
		int n=-1;		
		String sql="insert into EB_Product(PName,PDescription,PPrice,PStock,PCID,PCChildID,PUploadFileName) values(?,?,?,?,?,?,?)";
		n=operate(sql,new Object[]{product.getPName(), product.getPDescription(), product.getPPrice(), product.getPStock()
		     	,product.getPCID(),product.getPCChildID(),product.getPUploadFileName()});		
		return n;
	}
	
	//ɾ����Ʒ���ȫ����¼�ķ���
	@Override
	public int deleteProductAll(){
		int n=-1;
		String sql="delete * from EB_Product";
		n=operate(sql,null);
		return n;
	}
	
	//����Ʒ���ɾ����Ʒ����¼�ķ���
	@Override 
	public int deleteProductByPID(int pID){
		int n=-1;
		String sql="delete * from EB_Product where PID=?";
		n=operate(sql, new Object[]{pID});
		return n;
	}
	
	//�޸���Ʒ�������¼�ķ���
	@Override 
	public int modifyProduct(E_Product product){
		int n=-1;
		String sql="update EB_Product set PName=?,PDescription=?,PPrice=?,PStock=?,PCID=?,PCChild=? ,PUploadFileName=? where PID=?";
		n=operate(sql,new Object[]{product.getPName(), product.getPDescription(), product.getPPrice(), product.getPStock()
  	,product.getPCID(),product.getPCChildID(),product.getPUploadFileName(), product.getPID()});
		return n;
	}
}