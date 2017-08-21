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

package EB_Model.M_Service.ServiceImp;
import java.io.Serializable;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_DAO.DAO_Entity.DAOImp_E.*;
import EB_Model.M_Service.ServiceInt.*;
//��Ҫ��ʵ����E_News��Ӧ��Service��Ĺ����ӿ�ʵ����
public class SImp_Main_News implements SInt_Main_News,Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;

	//���ԣ������򣩷�װ
	private DAOInt_News sNews=new DAOImp_News();
	
 //�޲ι��췽��
	public SImp_Main_News(){super();}

	//��ѯ���ű��ȫ����¼�ķ���
	@Override 
	public ArrayList<E_News> findNewsAll(){
		return sNews.queryNewsAll();
	}

	//��ҳ��ѯ���ű���¼�ķ���
	@Override 
	public ArrayList<E_News> findNewsByPage(int currentPage, int pageSize){
		return sNews.queryNewsByPage(currentPage, pageSize);
	}

	//�����ű�Ų�ѯ���ű���¼�ķ���
	@Override 
	public E_News findNewsByNId(int nID){
		return sNews.queryNewsByNId(nID);
	}

 //��ѯ���ű�������ķ���
	@Override 
	public int findNewsRowsNum(){
		return sNews.queryNewsRowsNum();
	}

	//����1����¼�����ű��ķ���
	@Override 
	public int addNews(E_News news){
		return sNews.insertNews(news);
	}

	//ɾ�����ű��ȫ����¼�ķ���
	@Override 
	public int delNewsAll(){
		return sNews.deleteNewsAll();
	}

	//�����ű��ɾ�����ű���¼�ķ���
	@Override 
	public int delNewsByNId(int nID){
		return sNews.deleteNewsByNId(nID);
	}

	//�޸����ű������¼�ķ���
	@Override 
	public int updateNews(E_News news){
		return sNews.modifyNews(news);
	}
}