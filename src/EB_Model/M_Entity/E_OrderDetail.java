
package EB_Model.M_Entity;
import java.io.Serializable;
//��Ӧ���ݿ��еĶ���������EB_OrderDetail
public class E_OrderDetail implements Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;
	
	//���ԣ������򣩷�װ
	private int ODID;                             //���������ţ����������������
 private int OID;                              //�������
 private int PID;                              //��Ʒ���
 private int ODPQuantity;                      //��������Ʒ����
	private float OCost;                          //�������ѽ��
	
 //�޲ι��췽��
	public E_OrderDetail(){super();}

 //ȫ�ι��췽��
	public E_OrderDetail(int odID,int oID,int pID,int odPQuantity,float oCost){
		super();
		this.ODID=odID;
		this.OID=oID;
		this.PID=pID;
		this.ODPQuantity=odPQuantity;
		this.OCost=oCost;
	}	
	
	//ODID��getter��setter
	public int getODID(){
		return this.ODID;
	}
	public void setODID(int odID){
		this.ODID=odID;
	}

	//OID��getter��setter
	public int getOID(){
		return this.OID;
	}
	public void setOID(int oID){
		this.OID=oID;
	}

	//PID��getter��setter
	public int getPID(){
		return this.PID;
	}
	public void setPID(int pID){
		this.PID=pID;
	}

	//ODPQuantity��getter��setter
	public int getODPQuantity(){
		return this.ODPQuantity;
	}
	public void setODPQuantity(int odPQuantity){
		this.ODPQuantity=odPQuantity;
	}
	
	//OCost��getter��setter
	public float getOCost(){
		return this.OCost;
	}
	public void setOCost(float oCost){
		this.OCost=oCost;
	}
}