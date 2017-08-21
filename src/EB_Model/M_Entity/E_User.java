
package EB_Model.M_Entity;
import java.io.Serializable;
//��Ӧ���ݿ��е��û����EB_User
import java.util.Date;
public class E_User implements Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;
	
	//���ԣ������򣩷�װ
	private String UID;                              //�û���ţ�������
 private String UName;                            //�û���ʵ����
 private String UPassword;                        //�û�����
 private String USex;                             //�û��Ա�TΪ�У�FΪŮ
 private Date UBirthday;                          //�û���������
 private String UIdentityCode;                    //�û����֤��
 private String UEmail;                           //�û������ַ
 private String UMobile;                          //�û��ֻ�����
 private String UAddress;                         //�û��ջ���ַ
 private int ULogin;                              //�û���¼״̬��0. δ��¼��1. �ѵ�¼
 private int UType;                               //�û����ͣ�1. ��ͨ��Ա��2. ����Ա
 
 //�޲ι��췽��
 public E_User(){super();}

 //ȫ�ι��췽��
	public E_User(String uID,String uName,String uPassword,String uSex,
		Date uBirthday,String uIdentityCode,String uEmail,String uMobile,String uAddress,int uLogin,int uType){
		super();
		this.UID=uID;
		this.UName=uName;
		this.UPassword=uPassword;
		this.USex=uSex;
		this.UBirthday=uBirthday;
		this.UIdentityCode=uIdentityCode;
		this.UEmail=uEmail;
		this.UMobile=uMobile;
		this.UAddress=uAddress;
		this.ULogin=uLogin;
		this.UType=uType;
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

	//UPassword��getter��setter
	public String getUPassword(){
		return this.UPassword;
	}
	public void setUPassword(String uPassword){
		this.UPassword=uPassword;
	}

	//USex��getter��setter
	public String getUSex(){
		return this.USex;
	}
	public void setUSex(String uSex){
		this.USex=uSex;
	}

	//UBirthday��getter��setter
	public Date getUBirthday(){
		return this.UBirthday;
	}
	public void setUBirthday(Date uBirthday){
		this.UBirthday=uBirthday;
	}

	//UIdentityCode��getter��setter
	public String getUIdentityCode(){
		return this.UIdentityCode;
	}
	public void setUIdentityCode(String uIdentityCode){
		this.UIdentityCode=uIdentityCode;
	}

	//UEmail��getter��setter
	public String getUEmail(){
		return this.UEmail;
	}
	public void setUEmail(String uEmail){
		this.UEmail=uEmail;
	}

	//UMobile��getter��setter
	public String getUMobile(){
		return this.UMobile;
	}
	public void setUMobile(String uMobile){
		this.UMobile=uMobile;
	}

	//UAddress��getter��setter
	public String getUAddress(){
		return this.UAddress;
	}
	public void setUAddress(String uAddress){
		this.UAddress=uAddress;
	}

	//ULogin��getter��setter
	public int getULogin(){
		return this.ULogin;
	}
	public void setULogin(int uLogin){
		this.ULogin=uLogin;
	}

	//UType��getter��setter
	public int getUType(){
		return this.UType;
	}
	public void setUType(int uType){
		this.UType=uType;
	}
}