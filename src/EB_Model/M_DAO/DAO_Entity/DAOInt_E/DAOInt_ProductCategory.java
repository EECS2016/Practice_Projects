package EB_Model.M_DAO.DAO_Entity.DAOInt_E;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//��ʵ����E_ProductCategory��Ӧ��DAO������ݿ��������ɾ�Ĳ�ȣ��Ĺ����ӿ�
public interface DAOInt_ProductCategory{
	//��ѯ��Ʒ������ȫ����¼�ķ���
	ArrayList<E_ProductCategory> queryProductCategoryAll();
	
	//��ҳ��ѯ��Ʒ�������¼�ķ���
	ArrayList<E_ProductCategory> queryProductCategoryByPage(int currentPage,int pageSize);
	
 //����Ʒ�����Ų�ѯ��Ʒ�������¼�ķ���
 E_ProductCategory queryProductCategoryByPCID(String pcID);

 //��ѯ��Ʒ�����������ķ���
	int queryProductCategoryRowsNum();
	
	//����1����¼����Ʒ������ķ���
	int insertProductCategory(E_ProductCategory productcategory);
	
	//ɾ����Ʒ������ȫ����¼�ķ���
	int deleteProductCategoryAll();
	
	//����Ʒ������ɾ����Ʒ�������¼�ķ���
	int deleteProductCategoryByPCID(String pcID);
	
	//�޸���Ʒ����������¼�ķ���
	int modifyProductCategory(E_ProductCategory productcategory);
}