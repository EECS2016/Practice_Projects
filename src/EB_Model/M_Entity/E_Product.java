
package EB_Model.M_Entity;
import java.io.Serializable;
//��Ӧ���ݿ��е���Ʒ���EB_Product
public class E_Product implements Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;
	
	//���ԣ������򣩷�װ
	private int PID;                              //��Ʒ��ţ����������������
 private String PName;                         //��Ʒ����
 private String PDescription;                  //��Ʒ����
 private float PPrice;                         //��Ʒ�۸�
	private int PStock;                           //��Ʒ�����
 private int PCID;                             //��Ʒ����������
 private int PCChildID;                        //��Ʒ��������������
	private String PUploadFileName;               //�ϴ�����Ʒ����ļ�����
		
 //�޲ι��췽��
	public E_Product(){super();}

 //ȫ�ι��췽��
	public E_Product(int pId,String pName,String pDescription,float pPrice,int pStock,int pcID,int pcChildID,String pUploadFileName){
		super();
		this.PID=pId;
		this.PName=pName;
		this.PDescription=pDescription;
		this.PPrice=pPrice;
		this.PStock=pStock;
		this.PCID=pcID;
		this.PCChildID=pcChildID;
		this.PUploadFileName=pUploadFileName;
	}	
	
	//PID��getter��setter
	public int getPID(){
		return this.PID;
	}
	public void setPID(int pID){
		this.PID=pID;
	}

	//PName��getter��setter
	public String getPName(){
		return this.PName;
	}
	public void setPName(String pName){
		this.PName=pName;
	}

	//Pdescription��getter��setter
	public String getPDescription(){
		return this.PDescription;
	}
	public void setPDescription(String pDescription){
		this.PDescription = pDescription;
	}

	//PPrice��getter��setter
	public float getPPrice(){
		return this.PPrice;
	}
	public void setPPrice(float pPrice){
		this.PPrice=pPrice;
	}

	//PStock��getter��setter
	public int getPStock(){
		return this.PStock;
	}
	public void setPStock(int pStock){
		this.PStock=pStock;
	}

	//PCID��getter��setter
	public int getPCID(){
		return this.PCID;
	}
	public void setPCID(int pcID){
		this.PCID=pcID;
	}

	//PCChildID��getter��setter
	public int getPCChildID(){
		return this.PCChildID;
	}
	public void setPCChildID(int pcChildID){
		this.PCChildID=pcChildID;
	}

	//PUploadFileName��getter��setter
	public String getPUploadFileName(){
		return this.PUploadFileName;
	}
	public void setPUploadFileName(String pUploadFileName){
		this.PUploadFileName=pUploadFileName;
	}
}