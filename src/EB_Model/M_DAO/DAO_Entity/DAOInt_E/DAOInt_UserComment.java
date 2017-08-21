package EB_Model.M_DAO.DAO_Entity.DAOInt_E;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//��ʵ����E_UserComment��Ӧ��DAO������ݿ��������ɾ�Ĳ�ȣ��Ĺ����ӿ�
public interface DAOInt_UserComment{
	//��ѯ�û����۱��ȫ����¼�ķ���
	ArrayList<E_UserComment> queryUserCommentAll();
	
	//��ҳ��ѯ�û����۱���¼�ķ���
	ArrayList<E_UserComment> queryUserCommentByPage(int currentPage,int pageSize);
	
 //���û����۱�Ų�ѯ�û����۱���¼�ķ���
	E_UserComment queryUserCommentByUCID(int ucID);
	
 //��ѯ�û����۱�������ķ���
	public int queryUserCommentRowsNum();
	
	//����1����¼���û����۱��ķ���
	int insertUserComment(E_UserComment usercomment);
	
	//ɾ���û����۱��ȫ����¼�ķ���
	int deleteUserCommentAll();
	
	//���û����۱��ɾ���û����۱���¼�ķ���
	int deleteUserCommentByUCID(int ucID);
	
	//�޸��û����۱������¼�ķ���
	int modifyUserComment(E_UserComment usercomment);
}