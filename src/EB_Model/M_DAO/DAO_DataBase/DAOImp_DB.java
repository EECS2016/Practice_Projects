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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//���ݿ�һ���������ɾ�Ĳ�ȣ��Ľӿ�ʵ���ࣨJNDI�������ݿ����ӳؿ��Զ��˳��������ֶ��رս���������ݿ����ӣ�
public class DAOImp_DB implements DAOInt_DB,Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;
	
	//���ԣ������򣩷�װ
	private Connection con=DAOUtils_DB.createCon();
	
	//�޲ι��췽��
	public DAOImp_DB(){super();}
	
	//��ѯ����¼�ķ���
	@Override 
	public ResultSet query(String sql, Object[] params){
		ResultSet rs=null;
		try{
			PreparedStatement pst=con.prepareStatement(sql);
			if(params!=null&&params.length>0){
				for(int i=0;i<params.length;++i){
					pst.setObject(i+1,params[i]);
				}
			}
   rs=pst.executeQuery();
   //pst.close();                                       
   //rs.close();                                        
 	 //DAOUtils_DB.closeCon(con);                          
		}catch(SQLException ex){
			 ex.printStackTrace();
		  System.out.println("SQL������");
	 	}
		return rs;
	}

 //��������ɾ�ĵȣ�����¼�ķ���
	@Override 
	public int operate(String sql,Object[] params){
		int result=-1;
		try{
			PreparedStatement pst=con.prepareStatement(sql);
			if(params!=null&&params.length>0){
				for(int j=0;j<params.length;++j){
					pst.setObject(j+1,params[j]);
				}
			}
			result=pst.executeUpdate();
   //pst.close();                                        
 	 //DAOUtils_DB.closeCon(con);                          
		}catch(SQLException ex){
			 ex.printStackTrace();
		  System.out.println("SQL������");
		 }
		return result;
	}
}