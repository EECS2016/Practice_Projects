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

package EB_Model.M_DAO.DAO_Entity.DAOImp_E;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import EB_Model.M_DAO.DAO_DataBase.*;
import EB_Model.M_DAO.DAO_Entity.DAOInt_E.*;
import EB_Model.M_Entity.*;
import java.sql.Timestamp;
import java.sql.SQLException;
//��ʵ����E_News��Ӧ��DAO������ݿ��������ɾ�Ĳ�ȣ��Ľӿ�ʵ����
public class DAOImp_News extends DAOImp_DB implements DAOInt_News,Serializable{
	//ʵ��JavaBean���л����ɳ־û�����
	private static final long serialVersionUID=1L;
	
 //�޲ι��췽��
	public DAOImp_News(){super();}
	
	//��ѯ���ű��ȫ����¼�ķ�����������ʱ�䵹�����У�
	@Override 
	public ArrayList<E_News> queryNewsAll(){
		ArrayList<E_News> listN=new ArrayList<>();
		String sql="select * from EB_News order by NCreateTime desc";
		try{
			ResultSet rs=query(sql,null);
			while(rs.next()){
				E_News news=new E_News();
				news.setNID(rs.getInt(1));
				news.setNTitle(rs.getString(2));
				news.setNContent(rs.getString(3));
				news.setNCreateTime(rs.getTimestamp("NCreateTime"));
				listN.add(news);
			}
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return listN;
	}
	
	//��ҳ��ѯ���ű���¼�ķ���
	public ArrayList<E_News> queryNewsByPage(int currentPage,int pageSize){
		ArrayList<E_News> listN=new ArrayList<>();
		String sql="select * from EB_News limit ?,?";
		try{
			ResultSet rs=query(sql, new Object[]{(currentPage-1)*pageSize,pageSize});
			while(rs.next()){
				E_News news=new E_News();
				news.setNID(rs.getInt(1));
				news.setNTitle(rs.getString(2));
				news.setNContent(rs.getString(3));
				news.setNCreateTime(rs.getTimestamp("NCreateTime"));
				listN.add(news);
			}
			rs.close();
		}catch(SQLException e){
		 	e.printStackTrace();		
	 	}
		return listN;
	}	
	
	//�����ű�Ų�ѯ���ű���¼�ķ���
	@Override 
	public E_News queryNewsByNId(int nID){
		E_News news=null;
		String sql="select * from EB_News where NID=?";
		try{
			ResultSet rs=query(sql, new Object[]{nID});
			if(rs.next()){
				news=new E_News();
				news.setNID(rs.getInt(1));
				news.setNTitle(rs.getString(2));
				news.setNContent(rs.getString(3));
				news.setNCreateTime(rs.getTimestamp("NCreateTime"));
			}
			rs.close();
		}catch(SQLException ex){
		 	ex.printStackTrace();
	 	}
		return news;
	}
	
 //��ѯ���ű�������ķ���
	@Override 
	public int queryNewsRowsNum(){
		int NewsRowsNum=0;
		String sql="select count(*) from EB_News";
		try{
			ResultSet rs=query(sql,null);
			if(rs.next()){
		  NewsRowsNum=rs.getInt(1);
			}
			rs.close();
		}catch(SQLException ex){
			 ex.printStackTrace();
		 }
		return NewsRowsNum;
	}
	
	//����1����¼�����ű�����ķ���
	@Override 
	public int insertFirstNews(E_News news){
		int n=-1;
		news.setNID(queryNewsRowsNum()+1);
		String sql="update insert into EB_News values(?,?,?,?)";
		n=operate(sql, new Object[]{news.getNID(),news.getNTitle(), news.getNContent(), new Timestamp(news.getNCreateTime().getTime())});
		return n;
	}
	
	//����1����¼�����ű���м�ķ���
	@Override 
	public int insertMiddleNews(E_News news){
		int n=-1;
		news.setNID(queryNewsRowsNum()+1);
		String sql="insert into EB_News values(?,?,?,?)";
		n=operate(sql, new Object[]{news.getNID(),news.getNTitle(), news.getNContent(), new Timestamp(news.getNCreateTime().getTime())});
		return n;
	}
	
	//����1����¼�����ű��ĩβ�ķ���
	@Override 
	public int insertEndNews(E_News news){
		int n=-1;
		news.setNID(queryNewsRowsNum()+1);
		String sql="insert into EB_News values(?,?,?,?)";
		n=operate(sql, new Object[]{news.getNID(),news.getNTitle(), news.getNContent(), new Timestamp(news.getNCreateTime().getTime())});
		return n;
	}

	
	
	
	//ɾ�����ű��ȫ����¼�ķ���
	@Override 
	public int deleteNewsAll(){
		int n=-1;
		String sql="delete from EB_News";
		n=operate(sql,null);
		return n;
	}
	
	//�����ű��ɾ�����ű���¼�ķ���
	@Override 
	public int deleteNewsByNId(int nId){
		int n=-1;
		String sql="delete from EB_News where NID=?";
		n=operate(sql, new Object[]{nId});
		return n;
	}

	//�޸����ű������¼�ķ���
	@Override 
	public int modifyNews(E_News news){
		int n=-1;
		String sql="update EB_News set NTitle=?,NContent=?,NCreateTime=? where NID=?";
		n=operate(sql, new Object[]{news.getNTitle(), news.getNContent(), new Timestamp(news.getNCreateTime().getTime()), news.getNID()});
		return n;
	}
}