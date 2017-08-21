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


package EB_Model.M_DAO.DAO_DataBase;
import java.sql.ResultSet;
//数据库一般操作（增删改查等）的公共接口（JNDI配置数据库连接池可自动退出，无需手动关闭结果集和数据库连接） 
public interface DAOInt_DB{
	//查询表格记录的方法
 ResultSet query(String sql,Object[] params);	
 
 //操作（增删改等）表格记录的方法
 int operate(String sql,Object[] params);
}