
package EB_Model.M_Entity;
import java.io.Serializable;
//对应数据库中的用户表格EB_User
import java.util.Date;
public class E_User implements Serializable{
	//实现JavaBean序列化，可持久化访问
	private static final long serialVersionUID=1L;
	
	//属性（数据域）封装
	private String UID;                              //用户编号（主键）
 private String UName;                            //用户真实姓名
 private String UPassword;                        //用户密码
 private String USex;                             //用户性别：T为男，F为女
 private Date UBirthday;                          //用户出生日期
 private String UIdentityCode;                    //用户身份证号
 private String UEmail;                           //用户邮箱地址
 private String UMobile;                          //用户手机号码
 private String UAddress;                         //用户收货地址
 private int ULogin;                              //用户登录状态：0. 未登录；1. 已登录
 private int UType;                               //用户类型：1. 普通会员；2. 管理员
 
 //无参构造方法
 public E_User(){super();}

 //全参构造方法
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

	//UPassword的getter和setter
	public String getUPassword(){
		return this.UPassword;
	}
	public void setUPassword(String uPassword){
		this.UPassword=uPassword;
	}

	//USex的getter和setter
	public String getUSex(){
		return this.USex;
	}
	public void setUSex(String uSex){
		this.USex=uSex;
	}

	//UBirthday的getter和setter
	public Date getUBirthday(){
		return this.UBirthday;
	}
	public void setUBirthday(Date uBirthday){
		this.UBirthday=uBirthday;
	}

	//UIdentityCode的getter和setter
	public String getUIdentityCode(){
		return this.UIdentityCode;
	}
	public void setUIdentityCode(String uIdentityCode){
		this.UIdentityCode=uIdentityCode;
	}

	//UEmail的getter和setter
	public String getUEmail(){
		return this.UEmail;
	}
	public void setUEmail(String uEmail){
		this.UEmail=uEmail;
	}

	//UMobile的getter和setter
	public String getUMobile(){
		return this.UMobile;
	}
	public void setUMobile(String uMobile){
		this.UMobile=uMobile;
	}

	//UAddress的getter和setter
	public String getUAddress(){
		return this.UAddress;
	}
	public void setUAddress(String uAddress){
		this.UAddress=uAddress;
	}

	//ULogin的getter和setter
	public int getULogin(){
		return this.ULogin;
	}
	public void setULogin(int uLogin){
		this.ULogin=uLogin;
	}

	//UType的getter和setter
	public int getUType(){
		return this.UType;
	}
	public void setUType(int uType){
		this.UType=uType;
	}
}