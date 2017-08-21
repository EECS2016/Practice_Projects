/*
     �������������ܹ�ģʽ�����ݿ�㣨��Ҫָʵ����Entity����Ӧ�ò㣨ҵ���߼������ʾ�㣩��
 ҵ���߼����ֿɻ��ֳ������ҵ�����̺���ʾ�㽻��Ч������ν���Ʋ㣨Controll�㣩���ɴˣ��ֻ�����ν��MVC������������ļܹ�ģʽ��
 ���������MVC�ܹ�ģʽ��ģ�Ͳ㣨Model�㣩�������ݿ��ͻ��ֳ�Control����ҵ���߼��㣬��ʾ�㣨View�㣩�Ϳ��Ʋ㣨Controll�㣩
 ��һ����ҵ���߼����ֿɻ��ֳ����ݷ��ʲ㣨DAO�㣩�ͷ���㣨Service�㣩��
    ���Java Web�������ԣ����Ʋ���������������ɣ���ActionServlet���Action�ࡣ
    �������Java Web�������Բ��÷�����ļܹ�ģʽΪ��
   1. Model�㣨Entity�㣬DAO���Service�㣩--->Controll�㣨ActionServlet�����Action�����--->View�㣨JSP�������
   2. ���������ṩ�����ӿ��Թ����ã�����Ӧʵ�������JavaBean��ʽ��װ��
  
     ֻ���ʵ��ҵ�������������Model���е�ʵ�����DAO���ж�ʵ�������ݿ�����Ľӿں�ʵ���ࡣ����һ����ģ�Ͳ��µ�ʵ����һһ��Ӧ��
  Service���ṩ��ҵ��ֱ����ص����ݣ���Controll����������ύ��View�㰴ʵ��Ҫ�������ʾ��

*/

package EB_Model.M_Service.ServiceInt;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//��Ҫ��ʵ����E_News��Ӧ��Service��Ĺ����ӿ�
public interface SInt_Main_News{
	//��ѯ���ű��ȫ����¼�ķ���
	ArrayList<E_News> findNewsAll();
	
	//��ҳ��ѯ���ű���¼�ķ���
	ArrayList<E_News> findNewsByPage(int currentPage,int pageSize);
	
	//�����ű�Ų�ѯ���ű���¼�ķ���
	E_News findNewsByNId(int nID);
	
 //��ѯ���ű�������ķ���
	int findNewsRowsNum();
	
	//����1����¼�����ű��ķ���
	int addNews(E_News news);
	
	//ɾ�����ű��ȫ����¼�ķ���
	int delNewsAll();
	
	//�����ű��ɾ�����ű���¼�ķ���
	int delNewsByNId(int nID);
	
	//�޸����ű������¼�ķ���
	int updateNews(E_News news);
}