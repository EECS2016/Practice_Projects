
package EB_Model.M_Service.ServiceInt;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//��Ҫ��ʵ����E_Product��Ӧ��Service��Ĺ����ӿ�
public interface SInt_Main_Product{
	//��ѯ��Ʒ���ȫ����¼�ķ���
	ArrayList<E_Product> findProductAll();
	
	//��ҳ��ѯ��Ʒ����¼�ķ���
	ArrayList<E_Product> findProductByPage(int currentPage,int pageSize);
	
	//����Ʒ��Ų�ѯ��Ʒ����¼�ķ���
	E_Product findProductByPID(int pID);
	
 //���̷����Ų�ѯ��Ʒ����¼�ķ���
	ArrayList<E_Product> findProductByPCID(int pcID);
	
 //��ѯ��Ʒ��������ķ���
	int findProductRowsNum();
	
	//����1����¼����Ʒ���ķ���
	int addProduct(E_Product product);
	
	//ɾ����Ʒ���ȫ����¼�ķ���
	int delProductAll();
	
	//����Ʒ���ɾ����Ʒ����¼�ķ���
	int delProductByPID(int pID);
	
	//�޸���Ʒ�������¼�ķ���
	int updateProduct(E_Product product);
}