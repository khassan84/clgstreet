package com.commondboperation.transaction;

import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.commondboperation.exception.DatabaseException;


@Aspect
@Component
public class TransactionAspect {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	static {
		System.out.println("TransactionAspect loaded ");
	}
	
	
	@Around("@annotation(Transactional)")
	public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("TransactionAspect manageTransaction");
		Session session = null;
		Transaction tx = null;
		Object returnObj = null;
		Object[] signatureArgs = joinPoint.getArgs();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Transactional transactional = method.getAnnotation(Transactional.class);
		Class rollbackOn[] = transactional.rollbackOn();
		Class noRollbackOn[] = transactional.dontRollbackOn();
		for(int i=0; i<signatureArgs.length; i++){
			System.out.println(signatureArgs[i]);
			if(method.getParameterTypes()[i] == Session.class){
				if(signatureArgs[i] == null){
					session = sessionFactory.openSession();
					//sessionFactory.getCurrentSession();
					signatureArgs[i] = session;
					tx = session.beginTransaction();
					System.out.println("transaction hash : "+tx.hashCode());
				}else{
					
				}
			}
		}
		try{
			returnObj = joinPoint.proceed(signatureArgs);
			if(tx != null){
				tx.commit();
			}
		}catch(Exception t){// (Throwable t){
			if(tx != null){
				boolean commitFlag = false;
				boolean expectedException = false;
				for(Class c : noRollbackOn){
					if(t.getClass().equals(c)){
						System.out.println("noRollbackOn for : " +t.getClass());
						expectedException = true;
						commitFlag = true;
						break;
					}
				}
				for(Class c : rollbackOn){
					if(t.getClass().equals(c)){
						System.out.println("roll back match found" + t.getClass());
						expectedException = true;
						commitFlag = false;
						break;
					}
				}
				if(!expectedException){
					if (t instanceof RuntimeException){
						commitFlag = false;
					}else{
						commitFlag = true;
					}
				}
				if(commitFlag){
					System.out.println("ts hashcode :" + tx.hashCode());
					tx.commit();
				}else{
					System.out.println("ts hashcode :" + tx.hashCode());
					tx.rollback();
				}
			}
			throw new DatabaseException(t.getMessage());
		}finally{
			if(session != null){
				System.out.println("session hash : " +session.hashCode());
				session.close();
			}
		}
		return returnObj;
	}
}
