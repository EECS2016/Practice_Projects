package EB_Model.M_DAO.DAO_Entity.DAOInt_E;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//��ʵ����E_Product��Ӧ��DAO������ݿ��������ɾ�Ĳ�ȣ��Ĺ����ӿ�
public interface DAOInt_Product{
	//��ѯ��Ʒ���ȫ����¼�ķ���
	ArrayList<E_Product> queryProductAll();
	
	//��ҳ��ѯ��Ʒ����¼�ķ���
	ArrayList<E_Product> queryProductByPage(int currentPage,int pageSize);
	
	//����Ʒ��Ų�ѯ��Ʒ����¼�ķ���
	E_Product queryProductByPID(int pID);
	
 //���̷����Ų�ѯ��Ʒ����¼�ķ���
	ArrayList<E_Product> queryProductByPCID(int pcID);
	
 //��ѯ��Ʒ��������ķ���
	int queryProductRowsNum();
	
	//����1����¼����Ʒ���ķ���
	int insertProduct(E_Product product);
	
	//ɾ����Ʒ���ȫ����¼�ķ���
	int deleteProductAll();
	
	//����Ʒ���ɾ����Ʒ����¼�ķ���
	int deleteProductByPID(int pID);
	
	//�޸���Ʒ�������¼�ķ���
	int modifyProduct(E_Product product);
}