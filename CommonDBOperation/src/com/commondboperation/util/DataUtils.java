package com.commondboperation.util;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.commondboperation.miscallenous.QueryParam;

public class DataUtils {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/*public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/

	/**
	 * @param target object to save in database
	 * @return id of the saved object
	 */
	@Transactional
	@Deprecated
	public <T> Long saveDataToDB(T object){
		System.out.println(" in saveDataToDB hibernate");
		Session session = sessionFactory.openSession();
		 //sessionFactory.getConfiguration().getProperty("hibernate.jdbc.batch_size");
		Long id =  (Long) session.save(object);
		session.flush();
		session.close();
		return id;
	}
	

	public <T> Long saveDataToDBNoCommit(T object){
		System.out.println(" in saveDataToDBNoCommit hibernate");
		Session session = sessionFactory.openSession();
		System.out.println("hash code of session :" + session.hashCode());
		 //sessionFactory.getConfiguration().getProperty("hibernate.jdbc.batch_size");
		Long id =  (Long) session.save(object);
		session.flush();
		session.close();
		return id;
	}
	
	public void getException(Object object) throws UnsupportedEncodingException{
		throw new RuntimeException("Exception deliberated thrown to abort exception");
	}
	
	
	
	
	
	/**
	 * @param target object to save in database
	 */
	@Transactional
	public <T> void updateData(T object){
		System.out.println(" in updateData hibernate");
		Session session = sessionFactory.openSession();
		 //sessionFactory.getConfiguration().getProperty("hibernate.jdbc.batch_size");
		session.update(object);
		session.flush();
		session.close();
		
	}
	
	
	/**
	 * @param query to execute in database
	 * @return result returned by the query
	 */
	@Transactional
	public List fetchData( String query){
		System.out.println(" in fetchData hibernate");
		Session session = sessionFactory.openSession();
		List result = session.createQuery(query).list();
		session.close();
		return result;
	}
	
	/*@Transactional
	@Deprecated
	public BaseDO fetchTopOneData( String hql){
		BaseDO retVal = null;
		System.out.println(" in fetchTopOneData hibernate");
		Session session = sessionFactory.openSession();
		Query query =   session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List result = query.list();
		if(result != null && result.size() > 0){
			retVal = (BaseDO) result.get(0);
		}
		List result = session.createQuery(query).list();
		session.close();
		return result;
		session.close();
		return retVal;
	}*/

	
	/**
	 * @param query to execute in database
	 * @return result returned by the query
	 */
	@Transactional
	public Object fetchTopOneData(String hql){
		Object retVal = null;
		System.out.println(" in fetchTopOneData hibernate");
		Session session = sessionFactory.openSession();
		Query query =   session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List result = query.list();
		if(result != null && result.size() > 0){
			retVal =  result.get(0);
		}
		/*List result = session.createQuery(query).list();
		session.close();
		return result;*/
		session.close();
		return retVal;
	}
	
	/**
	 * @param hql
	 * @param params
	 * @return
	 */
	@Transactional
	public List fetchData( String hql, List<QueryParam> params){
		System.out.println(" in fetchData hibernate");
		Session session = sessionFactory.openSession();
		List result = session.createQuery(hql).list();
		Query query =   session.createQuery(hql);
		session.close();
		return result;
	}
	
	/**
	 * @param hql
	 * @param params
	 * @return
	 */
	@Transactional
	public List fetchData( String hql, Object... params){
		System.out.println(" in fetchData hibernate");
		Session session = sessionFactory.openSession();
		/*List result = session.createQuery(hql).list();
		Query query =   session.createQuery(hql);*/
		Query query = addParamToHql(hql, session, params);
		query.setFirstResult(0);
		query.setMaxResults(100);
		List result = query.list();
		session.close();
		return result;
	}
	
	
	
	
	/**
	 * @param hql
	 * @param params
	 * @return
	 */
	private Query addParamToHql( String hql, List<QueryParam> params){
		Session session = sessionFactory.openSession();
		Query query =   session.createQuery(hql);
		int i = 0;
		for(QueryParam param : params){
			i++;
			query.setParameter(i, param.getParamValue());
		}
		
		
		/*for(QueryParam param : params){
			if(param.getParamValue() instanceof String){
				query.setString(param.getParamName(), (String) param.getParamValue());
			}else if(param.getParamValue() instanceof Integer){
				query.setInteger(param.getParamName(), (Integer) param.getParamValue());
			}else if(param.getParamValue() instanceof BigDecimal){
				query.setBigDecimal(param.getParamName(), (BigDecimal) param.getParamValue());
			}else if(param.getParamValue() instanceof Date){
				query.setDate(param.getParamName(),  (Date) param.getParamValue());
			}else if (param.getParamValue() instanceof Double ){
				query.setDouble(param.getParamName(), (Double) param.getParamValue());
			}else if (param.getParamValue() instanceof Float ){
				query.setFloat(param.getParamName(), (Float) param.getParamValue());
			}else if (param.getParamValue() instanceof Long ){
				query.setLong(param.getParamName(), (Long) param.getParamValue());
			}
		}*/
		
		return query;
	}
	
	/**
	 * @param hql
	 * @param session
	 * @param params
	 * @return
	 */
	private Query addParamToHql(String hql, Session session, Object...params ){
	//	Session session = sessionFactory.openSession();
		Query query =   session.createQuery(hql);
		int i=0;
		for(Object param : params){
			query.setParameter(i++, param);
		}
		return query;
	}
	
	
}
