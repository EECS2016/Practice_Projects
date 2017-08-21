/*
     �������������ܹ�ģʽ�����ݿ�㣨��Ҫָʵ����Entity����Ӧ�ò㣨ҵ���߼������ʾ�㣩��
 ҵ���߼����ֿɻ��ֳ������ҵ�����̺���ʾ�㽻��Ч������ν���Ʋ㣨Controll�㣩���ɴˣ��ֻ�����ν��MVC������������ļܹ�ģʽ��
 ���������MVC�ܹ�ģʽ��ģ�Ͳ㣨Model�㣩�������ݿ��ͻ��ֳ�Control����ҵ���߼��㣬��ʾ�㣨View�㣩�Ϳ��Ʋ㣨Controll�㣩
 ��һ����ҵ���߼����ֿɻ��ֳ����ݷ��ʲ㣨DAO�㣩�ͷ���㣨Service�㣩��
    ���Java Web�������ԣ����Ʋ���������������ɣ���ActionServlet���Action�ࡣ
    �������Java Web�������Բ��÷�����ļܹ�ģʽΪ��
   1. Model�㣨Entity�㣬DAO���Service�㣩--->Controll�㣨ActionServlet�����Action�����--->View�㣨JSP�������
   2. ���������ṩ�����ӿ��Թ����ã�����Ӧʵ�������JavaBean��ʽ��װ��
   
*/   

package EB_Model.M_Entity;
import java.io.Serializable;
import java.util.Date;
//��Ӧ���ݿ��е����ű��EB_News
public class E_News implements Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;
	
	//���ԣ������򣩷�װ
	private int NID;                              //���ű�ţ����������������
 private String NTitle;                        //���ű���
 private String NContent;                      //��������
 private Date NCreateTime=new Date();          //����¼��ʱ�䣬Ĭ��Ϊϵͳʱ��
	
 //�޲ι��췽��
	public E_News(){super();}
	
 //���ι��췽������ȫ�Σ�
	public E_News(String nTitle,String nContent,Date nCreateTime){
		super();
		this.NTitle=nTitle;
		this.NContent=nContent;
		this.NCreateTime=nCreateTime;
	}
	
	
 //ȫ�ι��췽��
	public E_News(int nID,String nTitle,String nContent,Date nCreateTime){
		super();
		this.NID=nID;
		this.NTitle=nTitle;
		this.NContent=nContent;
		this.NCreateTime=nCreateTime;
	}
	
	//NID��getter��setter
	public int getNID(){
		return	this.NID;
	}
	public void setNID(int nID){
		this.NID=nID;
	}

	//NTitle��getter��setter
	public String getNTitle(){
		return this.NTitle;
	}
	public void setNTitle(String nTitle){
		this.NTitle=nTitle;
	}

	//NContent��getter��setter
	public String getNContent(){
		return this.NContent;
	}
	public void setNContent(String nContent){
		this.NContent=nContent;
	}

	//NCreateTime��getter��setter
	public Date getNCreateTime(){
		return	this.NCreateTime;
	}
	public void setNCreateTime(Date nCreateTime){
		this.NCreateTime=nCreateTime;
	}
}