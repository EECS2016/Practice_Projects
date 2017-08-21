package EB_Model.M_DAO.DAO_Entity.DAOInt_E;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//��ʵ����E_Order��Ӧ��DAO������ݿ��������ɾ�Ĳ�ȣ��Ĺ����ӿ�
public interface DAOInt_Order{
	//��ѯ�������ȫ����¼�ķ���
	ArrayList<E_Order> queryOrderAll();
	
	//��ҳ��ѯ��������¼�ķ���
	ArrayList<E_Order> queryOrderByPage(int currentPage,int pageSize);
	
 //��������Ų�ѯ��������¼�ķ���
	E_Order queryOrderByOID(int oId);
	
	//���û���Ų�ѯ��������¼�ķ���
	ArrayList<E_Order> queryOrderByUID(int uID);

	//��ѯ������������ķ���
	int queryOrderRowsNum();
	
	//����1����¼���������ķ���
	int insertOrder(E_Order order);
	
	//ɾ���������ȫ����¼�ķ���
	int deleteOrderAll();	
	
	//���������ɾ����������¼�ķ���
	int deleteOrderByOID(int oId);
	
	//�޸Ķ����������¼�ķ���
	int modifyOrder(E_Order order);
}