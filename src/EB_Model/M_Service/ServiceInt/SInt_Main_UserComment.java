
package EB_Model.M_Service.ServiceInt;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//��Ҫ��ʵ����E_UserComment��ص�Service��Ĺ����ӿ�
public interface SInt_Main_UserComment{
	//��ѯ�û����۱��ȫ����¼�ķ���
	ArrayList<E_UserComment> findUserCommentAll();
	
	//��ҳ��ѯ�û����۱���¼�ķ���
	ArrayList<E_UserComment> findUserCommentByPage(int currentPage,int pageSize);
	
 //���û����۱�Ų�ѯ�û����۱���¼�ķ���
	E_UserComment findUserCommentByUCID(int ucID);
	
 //��ѯ�û����۱�������ķ���
	public int findUserCommentRowsNum();
	
	//����1����¼���û����۱��ķ���
	int addUserComment(E_UserComment usercomment);
	
	//ɾ���û����۱��ȫ����¼�ķ���
	int delUserCommentAll();
	
	//���û����۱��ɾ���û����۱���¼�ķ���
	int delUserCommentByUCID(int ucID);
	
	//�޸��û����۱������¼�ķ���
	int updateUserComment(E_UserComment usercomment);
}