
package EB_Model.M_Entity;
import java.io.Serializable;
import java.util.Date;
//��Ӧ���ݿ��еĶ������EB_Order
public class E_Order implements Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;
	
	//���ԣ������򣩷�װ
	private int OID;                              //������ţ����������������                            
 private String UID;                           //�û����
 private String UName;                         //�û���ʵ����
 private String UAddress;                      //�û��ջ���ַ
 private Date OCreateTime;                     //��������ʱ��
	private float OCost;                          //�������ѽ��
	private int OStatus;                          //����״̬��1. ����ˣ�2. ���ͨ����3. �����4. �����ѷ�����5. ���ջ�
	
 //�޲ι��췽��
	public E_Order(){super();}

 //ȫ�ι��췽��
	public E_Order(int oID,String uID,String uName,String uAddress,Date oCreateTime,float oCost,int oStatus){
		super();
		this.OID=oID;
		this.UID=uID;
		this.UName=uName;
		this.UAddress=uAddress;
		this.OCreateTime=oCreateTime;
		this.OCost=oCost;
		this.OStatus=oStatus;
	}	
	
	//OID��getter��setter
	public int getOID(){
		return	this.OID;
	}
	public void setOID(int oID){
		this.OID=oID;
	}

	//UID��getter��setter
	public String getUID(){
		return this.UID;
	}
	public void setUID(String uID){
		this.UID=uID;
	}

	//UName��getter��setter
	public String getUName(){
		return this.UName;
	}
	public void setUName(String uName){
		this.UName=uName;
	}

	//UAddress��getter��setter
	public String getUAddress(){
		return	this.UAddress;
	}
	public void setUAddress(String uAddress){
		this.UAddress=uAddress;
	}

	//OCreateTime��getter��setter
	public Date getOCreateTime(){
		return this.OCreateTime;
	}
	public void setOCreateTime(Date oCreateTime){
		this.OCreateTime=oCreateTime;
	}

	//OCost��getter��setter
	public float getOCost(){
		return this.OCost;
	}
	public void setOCost(float oCost){
		this.OCost=oCost;
	}

	//OStatus��getter��setter
	public int getOStatus(){
		return this.OStatus;
	}
	public void setOStatus(int oStatus){
		this.OStatus=oStatus;
	}
}