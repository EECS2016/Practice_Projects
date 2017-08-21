package EB_Model.M_Service.ServiceImp;
import java.io.Serializable;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_DAO.DAO_Entity.DAOImp_E.*;
import EB_Model.M_Service.ServiceInt.*;
public class SImp_Main_Product implements SInt_Main_Product,Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;

	//���ԣ������򣩷�װ
	private DAOInt_Product sProduct=new DAOImp_Product();
	
 //�޲ι��췽��
	public SImp_Main_Product(){super();}

	//��ѯ��Ʒ���ȫ����¼�ķ���
	@Override
	public ArrayList<E_Product> findProductAll(){
		return sProduct.queryProductAll();
	}

	//��ҳ��ѯ��Ʒ����¼�ķ���
	@Override
	public ArrayList<E_Product> findProductByPage(int currentPage, int pageSize){
		return sProduct.queryProductByPage(currentPage, pageSize);
	}
	
	//����Ʒ��Ų�ѯ��Ʒ����¼�ķ���
	@Override
	public E_Product findProductByPID(int pID){
		return sProduct.queryProductByPID(pID);
	}

 //���̷����Ų�ѯ��Ʒ����¼�ķ���
	@Override 
	public ArrayList<E_Product> findProductByPCID(int pcID){
		return sProduct.queryProductByPCID(pcID);
	}

 //��ѯ��Ʒ��������ķ���
	@Override
	public int findProductRowsNum(){
		return sProduct.queryProductRowsNum();
	}

	//����1����¼����Ʒ���ķ���
	@Override
	public int addProduct(E_Product product){
		return sProduct.insertProduct(product);
	}

	//ɾ����Ʒ���ȫ����¼�ķ���
	@Override
	public int delProductAll(){
		return sProduct.deleteProductAll();
	}

	//����Ʒ���ɾ����Ʒ����¼�ķ���
	@Override
	public int delProductByPID(int pID){
		return sProduct.deleteProductByPID(pID);
	}

	//�޸���Ʒ�������¼�ķ���
	@Override
	public int updateProduct(E_Product product){
		return sProduct.modifyProduct(product);
	}
}