package EB_Model.M_Service.ServiceInt;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//��Ҫ��ʵ����E_ProductCategory��Ӧ��Service��Ĺ����ӿ�
public interface SInt_Main_ProductCategory{
	//��ѯ��Ʒ������ȫ����¼�ķ���
	ArrayList<E_ProductCategory> findProductCategoryAll();
	
	//��ҳ��ѯ��Ʒ�������¼�ķ���
	ArrayList<E_ProductCategory> findProductCategoryByPage(int currentPage,int pageSize);
	
 //����Ʒ�����Ų�ѯ��Ʒ�������¼�ķ���
 E_ProductCategory findProductCategoryByPCID(String pcID);

 //��ѯ��Ʒ�����������ķ���
	int findProductCategoryRowsNum();
	
	//����1����¼����Ʒ������ķ���
	int addProductCategory(E_ProductCategory productcategory);
	
	//ɾ����Ʒ������ȫ����¼�ķ���
	int delProductCategoryAll();
	
	//����Ʒ������ɾ����Ʒ�������¼�ķ���
	int delProductCategoryByPCID(String pcID);
	
	//�޸���Ʒ����������¼�ķ���
	int updateProductCategory(E_ProductCategory productcategory);
}