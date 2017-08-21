
package EB_Model.M_Entity;
import java.io.Serializable;
import java.util.Date;
//对应数据库中的订单表格EB_Order
public class E_Order implements Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;
	
	//属性（数据域）封装
	private int OID;                              //订单编号（主键，编号自增）                            
 private String UID;                           //用户编号
 private String UName;                         //用户真实姓名
 private String UAddress;                      //用户收货地址
 private Date OCreateTime;                     //订单创建时间
	private float OCost;                          //订单消费金额
	private int OStatus;                          //订单状态：1. 待审核；2. 审核通过；3. 配货；4. 卖家已发货；5. 已收货
	
 //无参构造方法
	public E_Order(){super();}

 //全参构造方法
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
	
	//OID的getter和setter
	public int getOID(){
		return	this.OID;
	}
	public void setOID(int oID){
		this.OID=oID;
	}

	//UID的getter和setter
	public String getUID(){
		return this.UID;
	}
	public void setUID(String uID){
		this.UID=uID;
	}

	//UName的getter和setter
	public String getUName(){
		return this.UName;
	}
	public void setUName(String uName){
		this.UName=uName;
	}

	//UAddress的getter和setter
	public String getUAddress(){
		return	this.UAddress;
	}
	public void setUAddress(String uAddress){
		this.UAddress=uAddress;
	}

	//OCreateTime的getter和setter
	public Date getOCreateTime(){
		return this.OCreateTime;
	}
	public void setOCreateTime(Date oCreateTime){
		this.OCreateTime=oCreateTime;
	}

	//OCost的getter和setter
	public float getOCost(){
		return this.OCost;
	}
	public void setOCost(float oCost){
		this.OCost=oCost;
	}

	//OStatus的getter和setter
	public int getOStatus(){
		return this.OStatus;
	}
	public void setOStatus(int oStatus){
		this.OStatus=oStatus;
	}
}