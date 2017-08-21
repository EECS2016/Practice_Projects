package EB_Model.M_Service.ServiceImp;
import java.io.Serializable;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_DAO.DAO_Entity.DAOImp_E.*;
import EB_Model.M_Service.ServiceInt.*;
public class SImp_Main_ProductCategory implements SInt_Main_ProductCategory,Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;

	//���ԣ������򣩷�װ
	private DAOInt_ProductCategory sProductCategory=new DAOImp_ProductCategory();
	
 //�޲ι��췽��
	public SImp_Main_ProductCategory(){super();}

	//��ѯ��Ʒ������ȫ����¼�ķ���
	@Override 
	public ArrayList<E_ProductCategory> findProductCategoryAll(){
		return sProductCategory.queryProductCategoryAll();
	}

	//��ҳ��ѯ��Ʒ�������¼�ķ���
	@Override
	public ArrayList<E_ProductCategory> findProductCategoryByPage(int currentPage, int pageSize){
		return sProductCategory.queryProductCategoryByPage(currentPage, pageSize);
	}

 //����Ʒ�����Ų�ѯ��Ʒ�������¼�ķ���
	@Override 
	public E_ProductCategory findProductCategoryByPCID(String pcID){
		return sProductCategory.queryProductCategoryByPCID(pcID);
	}

 //��ѯ��Ʒ�����������ķ���
	@Override
	public int findProductCategoryRowsNum(){
		return sProductCategory.queryProductCategoryRowsNum();
	}

	//����1����¼����Ʒ������ķ���
	@Override 
	public int addProductCategory(E_ProductCategory productcategory){
		return sProductCategory.insertProductCategory(productcategory);
	}

	//ɾ����Ʒ������ȫ����¼�ķ���
	@Override
	public int delProductCategoryAll(){
		return sProductCategory.deleteProductCategoryAll();
	}

	//����Ʒ������ɾ����Ʒ�������¼�ķ���
	@Override
	public int delProductCategoryByPCID(String pcID){
		return sProductCategory.deleteProductCategoryByPCID(pcID);
	}

	//�޸���Ʒ����������¼�ķ���
	@Override
	public int updateProductCategory(E_ProductCategory productcategory){
		return sProductCategory.modifyProductCategory(productcategory);
	}
}