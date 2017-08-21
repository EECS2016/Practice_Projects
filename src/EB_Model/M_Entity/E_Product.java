
package EB_Model.M_Entity;
import java.io.Serializable;
//对应数据库中的商品表格EB_Product
public class E_Product implements Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;
	
	//属性（数据域）封装
	private int PID;                              //商品编号（主键，编号自增）
 private String PName;                         //商品名称
 private String PDescription;                  //商品描述
 private float PPrice;                         //商品价格
	private int PStock;                           //商品库存量
 private int PCID;                             //商品所属分类编号
 private int PCChildID;                        //商品所属二级分类编号
	private String PUploadFileName;               //上传的商品相关文件名称
		
 //无参构造方法
	public E_Product(){super();}

 //全参构造方法
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
	
	//PID的getter和setter
	public int getPID(){
		return this.PID;
	}
	public void setPID(int pID){
		this.PID=pID;
	}

	//PName的getter和setter
	public String getPName(){
		return this.PName;
	}
	public void setPName(String pName){
		this.PName=pName;
	}

	//Pdescription的getter和setter
	public String getPDescription(){
		return this.PDescription;
	}
	public void setPDescription(String pDescription){
		this.PDescription = pDescription;
	}

	//PPrice的getter和setter
	public float getPPrice(){
		return this.PPrice;
	}
	public void setPPrice(float pPrice){
		this.PPrice=pPrice;
	}

	//PStock的getter和setter
	public int getPStock(){
		return this.PStock;
	}
	public void setPStock(int pStock){
		this.PStock=pStock;
	}

	//PCID的getter和setter
	public int getPCID(){
		return this.PCID;
	}
	public void setPCID(int pcID){
		this.PCID=pcID;
	}

	//PCChildID的getter和setter
	public int getPCChildID(){
		return this.PCChildID;
	}
	public void setPCChildID(int pcChildID){
		this.PCChildID=pcChildID;
	}

	//PUploadFileName的getter和setter
	public String getPUploadFileName(){
		return this.PUploadFileName;
	}
	public void setPUploadFileName(String pUploadFileName){
		this.PUploadFileName=pUploadFileName;
	}
}