
package EB_Model.M_Service.ServiceInt;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//��Ҫ��ʵ����E_Order��Ӧ��Service��Ĺ����ӿ�
public interface SInt_Main_Order{
	//��ѯ�������ȫ����¼�ķ���
	ArrayList<E_Order> findOrderAll();
	
	//��ҳ��ѯ��������¼�ķ���
	ArrayList<E_Order> findOrderByPage(int currentPage,int pageSize);
	
 //��������Ų�ѯ��������¼�ķ���
	E_Order findOrderByOID(int oId);
	
	//���û���Ų�ѯ��������¼�ķ���
	ArrayList<E_Order> findOrderByUID(int uID);

	//��ѯ������������ķ���
	int findOrderRowsNum();
	
	//����1����¼���������ķ���
	int addOrder(E_Order order);
	
	//ɾ���������ȫ����¼�ķ���
	int delOrderAll();	
	
	//���������ɾ����������¼�ķ���
	int delOrderByOID(int oId);
	
	//�޸Ķ����������¼�ķ���
	int updateOrder(E_Order order);
}