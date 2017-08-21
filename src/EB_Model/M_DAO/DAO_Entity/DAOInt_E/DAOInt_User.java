package EB_Model.M_DAO.DAO_Entity.DAOInt_E;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//��ʵ����E_User��Ӧ��DAO������ݿ��������ɾ�Ĳ�ȣ��Ĺ����ӿ�
public interface DAOInt_User{
	//��ѯ�û����ȫ����¼�ķ���
	ArrayList<E_User> queryUserAll();
	
	//��ҳ��ѯ�û�����¼�ķ���
	ArrayList<E_User> queryUserByPage(int currentPage,int pageSize);
	
	//���û���Ų�ѯ�û�����¼�ķ���
	E_User queryUserByUID(int uID);
	
	//���û����Ʋ�ѯ�û�����¼�ķ���
	ArrayList<E_User> queryUserByUName(String uName);
	
 //��ѯ�û���������ķ���
	int queryUserRowsNum();
	
 //����1����¼���鱾���ķ���
	int insertUser(E_User user);
	
	//ɾ���û����ȫ����¼�ķ���
	int deleteUserAll();
	
	//���û����ɾ���鱾����¼�ķ���
	int deleteUserByUID(int uID);
	
	//�޸��û��������¼�ķ���
	int modifyUser(E_User user);
}