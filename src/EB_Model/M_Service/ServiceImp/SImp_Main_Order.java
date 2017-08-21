package EB_Model.M_Service.ServiceImp;
import java.io.Serializable;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_DAO.DAO_Entity.DAOImp_E.*;
import EB_Model.M_Service.ServiceInt.*;
public class SImp_Main_Order implements SInt_Main_Order,Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;

	//���ԣ������򣩷�װ
	private DAOInt_Order sOrder=new DAOImp_Order();
	
 //�޲ι��췽��
	public SImp_Main_Order(){super();}

	//��ѯ�������ȫ����¼�ķ���
	@Override 
	public ArrayList<E_Order> findOrderAll(){
		return sOrder.queryOrderAll();
	}

	//��ҳ��ѯ��������¼�ķ���
	@Override 
	public ArrayList<E_Order> findOrderByPage(int currentPage, int pageSize){
		return sOrder.queryOrderByPage(currentPage, pageSize);
	}

 //��������Ų�ѯ��������¼�ķ���
	@Override 
	public E_Order findOrderByOID(int oId){
		return sOrder.queryOrderByOID(oId);
	}

	//���û���Ų�ѯ��������¼�ķ���
	@Override 
	public ArrayList<E_Order> findOrderByUID(int uID){
		return sOrder.queryOrderByUID(uID);
	}

	//��ѯ������������ķ���
	@Override 
	public int findOrderRowsNum(){
		return sOrder.queryOrderRowsNum();
	}

	//����1����¼���������ķ���
	@Override 
	public int addOrder(E_Order order){
		return sOrder.insertOrder(order);
	}

	//ɾ���������ȫ����¼�ķ���
	@Override 
	public int delOrderAll(){
		return sOrder.deleteOrderAll();
	}

	//���������ɾ����������¼�ķ���
	@Override 
	public int delOrderByOID(int oId){
		return sOrder.deleteOrderByOID(oId);
	}

	//�޸Ķ����������¼�ķ���
	@Override
	public int updateOrder(E_Order order){
		return sOrder.modifyOrder(order);
	}
}