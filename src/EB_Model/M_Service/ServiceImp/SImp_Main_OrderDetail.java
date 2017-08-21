package EB_Model.M_Service.ServiceImp;
import java.io.Serializable;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_DAO.DAO_Entity.DAOImp_E.*;
import EB_Model.M_Service.ServiceInt.*;
public class SImp_Main_OrderDetail implements SInt_Main_OrderDetail,Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;

	//���ԣ������򣩷�װ
	private DAOInt_OrderDetail sOrderDetail=new DAOImp_OrderDetail();
	
 //�޲ι��췽��
	public SImp_Main_OrderDetail(){super();}

 //��ѯ����������ȫ����¼�ķ���
	@Override 
	public ArrayList<E_OrderDetail> findOrderDetailAll(){
		return sOrderDetail.queryOrderDetailAll();
	}

	//��ҳ��ѯ�����������¼�ķ���
	@Override
	public ArrayList<E_OrderDetail> findOrderDetailByPage(int currentPage, int pageSize){
		return sOrderDetail.queryOrderDetailByPage(currentPage, pageSize);
	}

 //�����������Ų�ѯ�����������¼�ķ���
	@Override 
	public E_OrderDetail findOrderDetailByODID(int odID){
		return sOrderDetail.queryOrderDetailByODID(odID);
	}

 //��������Ų�ѯ�����������¼�ķ���
	@Override 
	public ArrayList<E_OrderDetail> findOrderDetailByOID(int oID){
		return sOrderDetail.queryOrderDetailByOID(oID);
	}

 //��ѯ���������������ķ���
	@Override 
	public int findOrderDetailRowsNum(){
		return sOrderDetail.queryOrderDetailRowsNum();
	}

	//����1����¼������������ķ���
	@Override 
	public int addOrderDetail(E_OrderDetail orderdetail){
		return sOrderDetail.insertOrderDetail(orderdetail);
	}

	//ɾ������������ȫ����¼�ķ���
	@Override
	public int delOrderDetailAll(){
		return sOrderDetail.deleteOrderDetailAll();
	}

	//������������ɾ�������������¼�ķ���
	@Override 
	public int delOrderDetailByODID(int odID){
		return sOrderDetail.deleteOrderDetailByODID(odID);
	}

	//�޸Ķ�������������¼�ķ���
	@Override
	public int updateOrderDetail(E_OrderDetail orderdetail){
		return sOrderDetail.modifyOrderDetail(orderdetail);
	}
}