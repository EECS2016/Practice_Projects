
package EB_Model.M_Entity;
import java.io.Serializable;
//对应数据库中的商品分类表格EB_ProductCategory
public class E_ProductCategory implements Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;
	
	//属性（数据域）封装
	private int PCID;                             //商品所属分类编号（主键，编号自增）
 private String PCName;                        //商品所属分类名称
 private int PCParentID;                       //商品所属父类编号：1. 图书音像；2. 百货
	
 //无参构造方法
	public E_ProductCategory(){super();}

 //全参构造方法
	public E_ProductCategory(int pcID,String pcName,int pcParentID){
		super();
		this.PCID=pcID;
		this.PCName=pcName;
		this.PCParentID=pcParentID;
	}	
	
	//PCID的getter和setter
	public int getPCID(){
		return this.PCID;
	}
	public void setPCID(int pcID){
		this.PCID=pcID;
	}

	//PCName的getter和setter
	public String getPCName(){
		return this.PCName;
	}
	public void setPCName(String pcName){
		this.PCName=pcName;
	}
	
	//PCParentID的getter和setter
	public int getPCParentID(){
		return this.PCParentID;
	}
	public void setPCParentID(int pcParentID){
		this.PCParentID=pcParentID;
	}
}