
package EB_Model.M_Entity;
import java.io.Serializable;
//��Ӧ���ݿ��е���Ʒ������EB_ProductCategory
public class E_ProductCategory implements Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;
	
	//���ԣ������򣩷�װ
	private int PCID;                             //��Ʒ���������ţ����������������
 private String PCName;                        //��Ʒ������������
 private int PCParentID;                       //��Ʒ���������ţ�1. ͼ������2. �ٻ�
	
 //�޲ι��췽��
	public E_ProductCategory(){super();}

 //ȫ�ι��췽��
	public E_ProductCategory(int pcID,String pcName,int pcParentID){
		super();
		this.PCID=pcID;
		this.PCName=pcName;
		this.PCParentID=pcParentID;
	}	
	
	//PCID��getter��setter
	public int getPCID(){
		return this.PCID;
	}
	public void setPCID(int pcID){
		this.PCID=pcID;
	}

	//PCName��getter��setter
	public String getPCName(){
		return this.PCName;
	}
	public void setPCName(String pcName){
		this.PCName=pcName;
	}
	
	//PCParentID��getter��setter
	public int getPCParentID(){
		return this.PCParentID;
	}
	public void setPCParentID(int pcParentID){
		this.PCParentID=pcParentID;
	}
}