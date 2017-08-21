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

package EB_Model.M_DAO.DAO_DataBase;
import java.io.Serializable;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;
/*
 * ���ݿ⹤���࣬���������͹ر����ݿ����ӵķ����ȣ�����JNDIʵ�ֵ����ݿ����ӷ������뱻Servlet��JSP���ò�����Ч
   JNDI�������ݿ����ӳؿ��Զ��˳��������ֶ��رս���������ݿ�����
*/
public class DAOUtils_DB implements Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;
	
	//���ԣ������򣩷�װ
	private static Connection connection=null;
	
	//�޲ι��췽�����������ֶ��������ݿ���������ʹ�õ���ģʽ��
 public DAOUtils_DB(){super();}
 
	//����JNDI�������ݿ����ӵķ���
	public static Connection createCon(){
 	try{
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/mysql_EB");
			if(connection==null){
				connection=ds.getConnection();
			 if(!connection.isClosed()){
			 	System.out.println("���ݿ����ӳɹ���");
			 }
			}
		}catch(SQLException ex1){
			 ex1.printStackTrace();
			 System.out.println("���ݿ�����δ�ɹ���");
		 }catch(Exception ex2){
			  ex2.printStackTrace();
				 System.out.println("���ݿ�����δ�ɹ���");
		 }
		return connection;
	}
	
	//�ر����ݿ����ӵķ���
	public static void closeCon(Connection con){
		try{
			con.close();
			if(con.isClosed()){
			 System.out.println("���ݿ�رճɹ���");
			}
		}catch(SQLException ex){
			 ex.printStackTrace();
			 System.out.println("���ݿ�ر�δ�ɹ���");
	 }
	}	
}