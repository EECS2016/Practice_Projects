package EB_Model.M_Service.ServiceInt;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//��Ҫ��ʵ����E_OrderDetail��Ӧ��Service��Ĺ����ӿ�
public interface SInt_Main_OrderDetail{
 //��ѯ����������ȫ����¼�ķ���
	ArrayList<E_OrderDetail> findOrderDetailAll();
	
	//��ҳ��ѯ�����������¼�ķ���
	ArrayList<E_OrderDetail> findOrderDetailByPage(int currentPage,int pageSize);
	
 //�����������Ų�ѯ�����������¼�ķ���
	E_OrderDetail findOrderDetailByODID(int odID);
	
 //��������Ų�ѯ�����������¼�ķ���
	ArrayList<E_OrderDetail> findOrderDetailByOID(int oID);	
	
 //��ѯ���������������ķ���
	int findOrderDetailRowsNum();
	
	//����1����¼������������ķ���
	int addOrderDetail(E_OrderDetail orderdetail);
	
	//ɾ������������ȫ����¼�ķ���
	int delOrderDetailAll();	
	
	//������������ɾ�������������¼�ķ���
	int delOrderDetailByODID(int odID);
	
	//�޸Ķ�������������¼�ķ���
	int updateOrderDetail(E_OrderDetail orderdetail);
}