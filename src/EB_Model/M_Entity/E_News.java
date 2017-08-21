/*
     软件开发的两层架构模式：数据库层（主要指实体类Entity）和应用层（业务逻辑层和显示层）。
 业务逻辑层又可划分出与控制业务流程和显示层交互效果的所谓控制层（Controll层），由此，分化出所谓的MVC三层软件开发的架构模式。
 软件开发的MVC架构模式：模型层（Model层）包含数据库层和划分出Control层后的业务逻辑层，显示层（View层）和控制层（Controll层）
 进一步，业务逻辑层又可划分出数据访问层（DAO层）和服务层（Service层）。
    针对Java Web开发而言，控制层由两大类组件构成，即ActionServlet类和Action类。
    下面针对Java Web开发而言采用分离出的架构模式为：
   1. Model层（Entity层，DAO层和Service层）--->Controll层（ActionServlet组件和Action组件）--->View层（JSP组件）；
   2. 自下向上提供公共接口以供调用，而对应实现类采用JavaBean形式封装。
   
*/   

package EB_Model.M_Entity;
import java.io.Serializable;
import java.util.Date;
//对应数据库中的新闻表格EB_News
public class E_News implements Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;
	
	//属性（数据域）封装
	private int NID;                              //新闻编号（主键，编号自增）
 private String NTitle;                        //新闻标题
 private String NContent;                      //新闻内容
 private Date NCreateTime=new Date();          //新闻录入时间，默认为系统时间
	
 //无参构造方法
	public E_News(){super();}
	
 //含参构造方法（非全参）
	public E_News(String nTitle,String nContent,Date nCreateTime){
		super();
		this.NTitle=nTitle;
		this.NContent=nContent;
		this.NCreateTime=nCreateTime;
	}
	
	
 //全参构造方法
	public E_News(int nID,String nTitle,String nContent,Date nCreateTime){
		super();
		this.NID=nID;
		this.NTitle=nTitle;
		this.NContent=nContent;
		this.NCreateTime=nCreateTime;
	}
	
	//NID的getter和setter
	public int getNID(){
		return	this.NID;
	}
	public void setNID(int nID){
		this.NID=nID;
	}

	//NTitle的getter和setter
	public String getNTitle(){
		return this.NTitle;
	}
	public void setNTitle(String nTitle){
		this.NTitle=nTitle;
	}

	//NContent的getter和setter
	public String getNContent(){
		return this.NContent;
	}
	public void setNContent(String nContent){
		this.NContent=nContent;
	}

	//NCreateTime的getter和setter
	public Date getNCreateTime(){
		return	this.NCreateTime;
	}
	public void setNCreateTime(Date nCreateTime){
		this.NCreateTime=nCreateTime;
	}
}