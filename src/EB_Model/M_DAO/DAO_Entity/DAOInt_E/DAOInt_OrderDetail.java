package EB_Model.M_DAO.DAO_Entity.DAOInt_E;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//��ʵ����E_OrderDetail��Ӧ��DAO������ݿ��������ɾ�Ĳ�ȣ��Ĺ����ӿ�
public interface DAOInt_OrderDetail{
 //��ѯ����������ȫ����¼�ķ���
	ArrayList<E_OrderDetail> queryOrderDetailAll();
	
	//��ҳ��ѯ�����������¼�ķ���
	ArrayList<E_OrderDetail> queryOrderDetailByPage(int currentPage,int pageSize);
	
//�����������Ų�ѯ�����������¼�ķ���
	E_OrderDetail queryOrderDetailByODID(int odID);
	
//��������Ų�ѯ�����������¼�ķ���
	ArrayList<E_OrderDetail> queryOrderDetailByOID(int oID);	
	
 //��ѯ���������������ķ���
	int queryOrderDetailRowsNum();
	
	//����1����¼������������ķ���
	int insertOrderDetail(E_OrderDetail orderdetail);
	
	//ɾ������������ȫ����¼�ķ���
	int deleteOrderDetailAll();	
	
	//������������ɾ�������������¼�ķ���
	int deleteOrderDetailByODID(int odID);
	
	//�޸Ķ�������������¼�ķ���
	int modifyOrderDetail(E_OrderDetail orderdetail);
}