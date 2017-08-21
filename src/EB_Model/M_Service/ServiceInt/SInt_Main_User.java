package EB_Model.M_Service.ServiceInt;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//��Ҫ��ʵ����E_User��Ӧ��Service��Ĺ����ӿ�
public interface SInt_Main_User{
	//��ѯ�û����ȫ����¼�ķ���
	ArrayList<E_User> findUserAll();
	
	//��ҳ��ѯ�û�����¼�ķ���
	ArrayList<E_User> findUserByPage(int currentPage,int pageSize);
	
	//���û���Ų�ѯ�û�����¼�ķ���
	E_User findUserByUID(int uID);
	
	//���û����Ʋ�ѯ�û�����¼�ķ���
	ArrayList<E_User> findUserByUName(String uName);
	
 //��ѯ�û���������ķ���
	int findUserRowsNum();
	
 //����1����¼���鱾���ķ���
	int addtUser(E_User user);
	
	//ɾ���û����ȫ����¼�ķ���
	int delUserAll();
	
	//���û����ɾ���鱾����¼�ķ���
	int delUserByUID(int uID);
	
	//�޸��û��������¼�ķ���
	int updateUser(E_User user);
}