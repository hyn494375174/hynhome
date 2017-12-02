package com.hyn.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


public class BaseDao<T> {
	private Class<T> entityClass;					//泛化Dao层对象
	
	@Autowired
	private HibernateTemplate hibernateTemplate;	//ORM框架Hibernate的对象
	
	/**
	 * 通过反射获取子类确定的泛型类
	 */
	public BaseDao() {			
		Type genType = getClass().getGenericSuperclass();	//获得类型
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();	//获得参数
		entityClass = (Class) params[0];	//初始化entityClass
	}
	
	/**
	 * 根据ID加载PO实例
	 * 
	 * @param id
	 * @return 返回相应的持久化PO实例
	 */
	public T load(Serializable id) {
		return (T) getHibernateTemplate().load(entityClass, id);
	}
	
	/**
	 * 根据ID获取PO实例
	 * 
	 * @param id
	 * @return 返回相应的持久化PO实例
	 */
	public T get(Serializable id){
		return (T) getHibernateTemplate().get(entityClass, id);
	}
	
	/**
	 * 获取PO的所有对象
	 * 
	 * @return
	 */
	public List<T> loadAll(){
		return getHibernateTemplate().loadAll(entityClass);
	}
	
	/**
	 * 保存PO
	 * 
	 * @param entity
	 */
	public void save(T entity){
		getHibernateTemplate().save(entity);
	}
	
	/**
	 * 删除PO
	 * 
	 * @param entity
	 */
	public void remove(T entity){
		getHibernateTemplate().delete(entity);
	}
	
	/**
	 * 删除tableNames数据
	 *
	 */
	public void removeAll(String tableName) {
		getSession().createSQLQuery("truncate TABLE " + tableName +"").executeUpdate();
	}
	
	/**
	 * 更改PO
	 * 
	 * @param entity
	 */
	public void update(T entity){
		getHibernateTemplate().update(entity);
	}
	
	/**
	 * 执行HQL查询
	 * 
	 * @param sql
	 * @return 查询结果
	 */
	public List find(String hql){
		return this.getHibernateTemplate().find(hql);
	}
	
	/**
	 * 执行带参的HQL查询
	 * 
	 * @param sql
	 * @param params
	 * @return 查询结果
	 */
	public List find(String hql,Object... params){
		return this.getHibernateTemplate().find(hql,params);
	}
	
	/**
	 * 对延迟加载的实体PO执行初始化
	 * @param entity
	 */
	public void initialize(Object entity) {
		this.getHibernateTemplate().initialize(entity);
	}
	
	/**
	 * 创建Query对象. 对于需要first,max,fetchsize,cache,cacheRegion等诸多设置的函数,可以在返回Query后自行设置.
	 * 留意可以连续设置,如下：
	 * <pre>
	 * dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
	 * </pre>
	 * 调用方式如下：
	 * <pre>
	 *        dao.createQuery(hql)
	 *        dao.createQuery(hql,arg0);
	 *        dao.createQuery(hql,arg0,arg1);
	 *        dao.createQuery(hql,new Object[arg0,arg1,arg2])
	 * </pre>
	 *
	 * @param values 可变参数.
	 */
	public Query createQuery(String hql, Object... values) {
		Assert.hasText(hql);
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	public  Session getSession() {
        return hibernateTemplate.getSessionFactory().getCurrentSession();
    }
}
