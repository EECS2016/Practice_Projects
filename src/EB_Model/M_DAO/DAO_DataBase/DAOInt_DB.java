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
import java.sql.ResultSet;
//���ݿ�һ���������ɾ�Ĳ�ȣ��Ĺ����ӿڣ�JNDI�������ݿ����ӳؿ��Զ��˳��������ֶ��رս���������ݿ����ӣ� 
public interface DAOInt_DB{
	//��ѯ����¼�ķ���
 ResultSet query(String sql,Object[] params);	
 
 //��������ɾ�ĵȣ�����¼�ķ���
 int operate(String sql,Object[] params);
}