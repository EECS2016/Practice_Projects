
package EB_Model.M_Entity;
import java.io.Serializable;
import java.util.Date;
//��Ӧ���ݿ��е��û����Ա��EB_UserComment
public class E_UserComment implements Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;
	
	//���ԣ������򣩷�װ
	private int UCID;                             //�û����Ա�ţ����������������
 private String UCNickName;                    //�����û����ǳ�
 private String UCContent;                     //�û���������
 private Date UCCreateTime;                    //�û����Է���ʱ��
 private String UCReply;                       //�û����ԵĻظ�
 private Date UCReplyTime;                     //�û����ԵĻظ�ʱ��
 
 //�޲ι��췽��
	public E_UserComment(){super();}

 //ȫ�ι��췽��
	public E_UserComment(int ucID,String ucContent,Date ucCreateTime,String ucReply,Date ucReplyTime,String ucNickName){
		super();
		this.UCID=ucID;
		this.UCContent=ucContent;
		this.UCCreateTime=ucCreateTime;
		this.UCReply=ucReply;
		this.UCReplyTime=ucReplyTime;
		this.UCNickName=ucNickName;
	}	
	
	//UCID��getter��setter
	public int getUCID(){
		return this.UCID;
	}
	public void setUCID(int ucID){
		this.UCID=ucID;
	}

	//UCNickName��getter��setter
	public String getUCNickName(){
		return this.UCNickName;
	}
	public void setUCNickName(String ucNickName){
		this.UCNickName=ucNickName;
	}
	
	//UCContent��getter��setter
	public String getUCContent(){
		return this.UCContent;
	}
	public void setUCContent(String ucContent){
		this.UCContent=ucContent;
	}

	//UCCreateTime��getter��setter
	public Date getUCCreateTime(){
		return this.UCCreateTime;
	}
	public void setUCCreateTime(Date ucCreateTime){
		this.UCCreateTime=ucCreateTime;
	}

	//UCReply��getter��setter
	public String getUCReply(){
		return this.UCReply;
	}
	public void setUCReply(String ucReply){
		this.UCReply=ucReply;
	}

	//UCReplyTime��getter��setter
	public Date getUCReplyTime(){
		return this.UCReplyTime;
	}
	public void setUCReplyTime(Date ucReplyTime){
		this.UCReplyTime=ucReplyTime;
	}
}