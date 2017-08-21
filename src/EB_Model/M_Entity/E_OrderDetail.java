
package EB_Model.M_Entity;
import java.io.Serializable;
//对应数据库中的订单详情表格EB_OrderDetail
public class E_OrderDetail implements Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;
	
	//属性（数据域）封装
	private int ODID;                             //订单详情编号（主键，编号自增）
 private int OID;                              //订单编号
 private int PID;                              //商品编号
 private int ODPQuantity;                      //订单中商品数量
	private float OCost;                          //订单消费金额
	
 //无参构造方法
	public E_OrderDetail(){super();}

 //全参构造方法
	public E_OrderDetail(int odID,int oID,int pID,int odPQuantity,float oCost){
		super();
		this.ODID=odID;
		this.OID=oID;
		this.PID=pID;
		this.ODPQuantity=odPQuantity;
		this.OCost=oCost;
	}	
	
	//ODID的getter和setter
	public int getODID(){
		return this.ODID;
	}
	public void setODID(int odID){
		this.ODID=odID;
	}

	//OID的getter和setter
	public int getOID(){
		return this.OID;
	}
	public void setOID(int oID){
		this.OID=oID;
	}

	//PID的getter和setter
	public int getPID(){
		return this.PID;
	}
	public void setPID(int pID){
		this.PID=pID;
	}

	//ODPQuantity的getter和setter
	public int getODPQuantity(){
		return this.ODPQuantity;
	}
	public void setODPQuantity(int odPQuantity){
		this.ODPQuantity=odPQuantity;
	}
	
	//OCost的getter和setter
	public float getOCost(){
		return this.OCost;
	}
	public void setOCost(float oCost){
		this.OCost=oCost;
	}
}