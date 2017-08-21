package EB_Model.M_Service.ServiceImp;
import java.io.Serializable;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_DAO.DAO_Entity.DAOImp_E.*;
import EB_Model.M_Service.ServiceInt.*;
public class SImp_Main_UserComment implements SInt_Main_UserComment,Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;

	//���ԣ������򣩷�װ
	private DAOInt_UserComment sUserComment=new DAOImp_UserComment();
	
 //�޲ι��췽��
	public SImp_Main_UserComment(){super();}

	//��ѯ�û����۱��ȫ����¼�ķ���
	@Override
	public ArrayList<E_UserComment> findUserCommentAll(){
		return sUserComment.queryUserCommentAll();
	}

 //��ҳ��ѯ�û����۱���¼�ķ��� 
	@Override 
	public ArrayList<E_UserComment> findUserCommentByPage(int currentPage, int pageSize){
		return sUserComment.queryUserCommentByPage(currentPage, pageSize);
	}

	//���û����۱�Ų�ѯ�û����۱���¼�ķ��� 
	@Override 
	public E_UserComment findUserCommentByUCID(int ucID){
		return sUserComment.queryUserCommentByUCID(ucID);
	}

 //��ѯ�û����۱�������ķ���	
	@Override
	public int findUserCommentRowsNum(){
		return sUserComment.queryUserCommentRowsNum();
	}

 //����1����¼���û����۱��ķ���	
	@Override
	public int addUserComment(E_UserComment usercomment){
		return sUserComment.insertUserComment(usercomment);
	}
	
 //ɾ���û����۱��ȫ����¼�ķ���	
	@Override
	public int delUserCommentAll(){
		return sUserComment.deleteUserCommentAll();
	}

 //���û����۱��ɾ���û����۱���¼�ķ���
	@Override
	public int delUserCommentByUCID(int ucID){
		return sUserComment.deleteUserCommentByUCID(ucID);
	}

	//�޸��û����۱������¼�ķ���
	@Override 
	public int updateUserComment(E_UserComment usercomment){
		return sUserComment.modifyUserComment(usercomment);
	}
}