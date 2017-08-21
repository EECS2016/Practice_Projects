/*
     软件开发的两层架构模式：数据库层（主要指实体类Entity）和应用层（业务逻辑层和显示层）。
 业务逻辑层又可划分出与控制业务流程和显示层交互效果的所谓控制层（Controll层），由此，分化出所谓的MVC三层软件开发的架构模式。
 软件开发的MVC架构模式：模型层（Model层）包含数据库层和划分出Control层后的业务逻辑层，显示层（View层）和控制层（Controll层）
 进一步，业务逻辑层又可划分出数据访问层（DAO层）和服务层（Service层）。
    针对Java Web开发而言，控制层由两大类组件构成，即ActionServlet类和Action类。
    下面针对Java Web开发而言采用分离出的架构模式为：
   1. Model层（Entity层，DAO层和Service层）--->Controll层（ActionServlet组件和Action组件）--->View层（JSP组件）；
   2. 自下向上提供公共接口以供调用，而对应实现类采用JavaBean形式封装。
  
     只针对实际业务合理调用所需的Model层中的实体类和DAO层中对实体类数据库操作的接口和实现类。并不一定与模型层下的实体类一一对应！
  Service层提供与业务直接相关的数据，经Controll层调整后，再提交给View层按实际要求进行显示。

*/

package EB_Model.M_Service.ServiceInt;
import java.util.ArrayList;
import EB_Model.M_Entity.*;
//主要与实体类E_News对应的Service层的公共接口
public interface SInt_Main_News{
	//查询新闻表格全部记录的方法
	ArrayList<E_News> findNewsAll();
	
	//分页查询新闻表格记录的方法
	ArrayList<E_News> findNewsByPage(int currentPage,int pageSize);
	
	//按新闻编号查询新闻表格记录的方法
	E_News findNewsByNId(int nID);
	
 //查询新闻表格行数的方法
	int findNewsRowsNum();
	
	//增加1条记录到新闻表格的方法
	int addNews(E_News news);
	
	//删除新闻表格全部记录的方法
	int delNewsAll();
	
	//按新闻编号删除新闻表格记录的方法
	int delNewsByNId(int nID);
	
	//修改新闻表格单条记录的方法
	int updateNews(E_News news);
}