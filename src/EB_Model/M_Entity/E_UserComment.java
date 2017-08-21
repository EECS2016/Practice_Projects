
package EB_Model.M_Entity;
import java.io.Serializable;
import java.util.Date;
//对应数据库中的用户留言表格EB_UserComment
public class E_UserComment implements Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;
	
	//属性（数据域）封装
	private int UCID;                             //用户留言编号（主键，编号自增）
 private String UCNickName;                    //留言用户的昵称
 private String UCContent;                     //用户留言内容
 private Date UCCreateTime;                    //用户留言发布时间
 private String UCReply;                       //用户留言的回复
 private Date UCReplyTime;                     //用户留言的回复时间
 
 //无参构造方法
	public E_UserComment(){super();}

 //全参构造方法
	public E_UserComment(int ucID,String ucContent,Date ucCreateTime,String ucReply,Date ucReplyTime,String ucNickName){
		super();
		this.UCID=ucID;
		this.UCContent=ucContent;
		this.UCCreateTime=ucCreateTime;
		this.UCReply=ucReply;
		this.UCReplyTime=ucReplyTime;
		this.UCNickName=ucNickName;
	}	
	
	//UCID的getter和setter
	public int getUCID(){
		return this.UCID;
	}
	public void setUCID(int ucID){
		this.UCID=ucID;
	}

	//UCNickName的getter和setter
	public String getUCNickName(){
		return this.UCNickName;
	}
	public void setUCNickName(String ucNickName){
		this.UCNickName=ucNickName;
	}
	
	//UCContent的getter和setter
	public String getUCContent(){
		return this.UCContent;
	}
	public void setUCContent(String ucContent){
		this.UCContent=ucContent;
	}

	//UCCreateTime的getter和setter
	public Date getUCCreateTime(){
		return this.UCCreateTime;
	}
	public void setUCCreateTime(Date ucCreateTime){
		this.UCCreateTime=ucCreateTime;
	}

	//UCReply的getter和setter
	public String getUCReply(){
		return this.UCReply;
	}
	public void setUCReply(String ucReply){
		this.UCReply=ucReply;
	}

	//UCReplyTime的getter和setter
	public Date getUCReplyTime(){
		return this.UCReplyTime;
	}
	public void setUCReplyTime(Date ucReplyTime){
		this.UCReplyTime=ucReplyTime;
	}
}