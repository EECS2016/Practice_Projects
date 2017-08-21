/*
      软件开发的两层架构模式：数据库层（主要指实体类Entity）和应用层（业务逻辑层和显示层）。
 业务逻辑层又可划分出与控制业务流程和显示层交互效果的所谓控制层（Controll层），由此，分化出所谓的MVC三层软件开发的架构模式。
 软件开发的MVC架构模式：模型层（Model层）包含数据库层和划分出Control层后的业务逻辑层，显示层（View层）和控制层（Controll层）
 进一步，业务逻辑层又可划分出数据访问层（DAO层）和服务层（Service层）。
    针对Java Web开发而言，控制层由两大类组件构成，即ActionServlet类和Action类。
    下面针对Java Web开发而言采用分离出的架构模式为：
   1. Model层（Entity层，DAO层和Service层）--->Controll层（ActionServlet组件和Action组件）--->View层（JSP组件）；
   2. 自下向上提供公共接口以供调用，而对应实现类采用JavaBean形式封装。
    
*/

package EB_Model.M_DAO.DAO_Entity.DAOInt_E;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//与实体类E_News对应的DAO层的数据库操作（增删改查等）的公共接口
public interface DAOInt_News{
	//查询新闻表格全部记录的方法
	ArrayList<E_News> queryNewsAll();
	
	//分页查询新闻表格记录的方法
	ArrayList<E_News> queryNewsByPage(int currentPage,int pageSize);
	
	//按新闻编号查询新闻表格记录的方法
	E_News queryNewsByNId(int nID);
	
 //查询新闻表格行数的方法
	int queryNewsRowsNum();
	
	//增加1条记录到新闻表格起点的方法
 int insertFirstNews(E_News news);
	
	//增加1条记录到新闻表格中间的方法
 int insertMiddleNews(E_News news);
	
	//增加1条记录到新闻表格末尾的方法
	int insertEndNews(E_News news);
	
	//删除新闻表格全部记录的方法
	int deleteNewsAll();
	
	//按新闻编号删除新闻表格记录的方法
	int deleteNewsByNId(int nID);
	
	//修改新闻表格单条记录的方法
	int modifyNews(E_News news);
}