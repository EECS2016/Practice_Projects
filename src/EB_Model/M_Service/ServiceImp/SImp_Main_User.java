package EB_Model.M_Service.ServiceImp;
import java.io.Serializable;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_DAO.DAO_Entity.DAOImp_E.*;
import EB_Model.M_Service.ServiceInt.*;
public class SImp_Main_User implements SInt_Main_User,Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;

	//���ԣ������򣩷�װ
	private DAOInt_User sUser=new DAOImp_User();
	
 //�޲ι��췽��
	public SImp_Main_User(){super();}

	//��ѯ�û����ȫ����¼�ķ���
	@Override
	public ArrayList<E_User> findUserAll(){
		return sUser.queryUserAll();
	}

	//��ҳ��ѯ�û�����¼�ķ���
	@Override
	public ArrayList<E_User> findUserByPage(int currentPage, int pageSize){
		return sUser.queryUserByPage(currentPage, pageSize);
	}

	//���û���Ų�ѯ�û�����¼�ķ���
	@Override 
	public E_User findUserByUID(int uID){
		return sUser.queryUserByUID(uID);
	}

	//���û����Ʋ�ѯ�û�����¼�ķ���
	@Override 
	public ArrayList<E_User> findUserByUName(String uName){
		return sUser.queryUserByUName(uName);
	}

 //��ѯ�û���������ķ���
	@Override 
	public int findUserRowsNum(){
		return sUser.queryUserRowsNum();
	}

 //����1����¼���鱾���ķ���
	@Override
	public int addtUser(E_User user){
		return sUser.insertUser(user);
	}

	//ɾ���û����ȫ����¼�ķ���
	@Override 
	public int delUserAll(){
		return sUser.deleteUserAll();
	}

	//���û����ɾ���鱾����¼�ķ���
	@Override
	public int delUserByUID(int uID){
		return sUser.deleteUserByUID(uID);
	}

	//�޸��û��������¼�ķ���
	@Override
	public int updateUser(E_User user){
		return sUser.modifyUser(user);
	}
}