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

package EB_Model.M_DAO.DAO_Entity.DAOInt_E;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//��ʵ����E_News��Ӧ��DAO������ݿ��������ɾ�Ĳ�ȣ��Ĺ����ӿ�
public interface DAOInt_News{
	//��ѯ���ű��ȫ����¼�ķ���
	ArrayList<E_News> queryNewsAll();
	
	//��ҳ��ѯ���ű���¼�ķ���
	ArrayList<E_News> queryNewsByPage(int currentPage,int pageSize);
	
	//�����ű�Ų�ѯ���ű���¼�ķ���
	E_News queryNewsByNId(int nID);
	
 //��ѯ���ű�������ķ���
	int queryNewsRowsNum();
	
	//����1����¼�����ű�����ķ���
 int insertFirstNews(E_News news);
	
	//����1����¼�����ű���м�ķ���
 int insertMiddleNews(E_News news);
	
	//����1����¼�����ű��ĩβ�ķ���
	int insertEndNews(E_News news);
	
	//ɾ�����ű��ȫ����¼�ķ���
	int deleteNewsAll();
	
	//�����ű��ɾ�����ű���¼�ķ���
	int deleteNewsByNId(int nID);
	
	//�޸����ű������¼�ķ���
	int modifyNews(E_News news);
}