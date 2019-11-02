package com.book.transaction;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TransactionAspect2 {
	
	
	
	
	@Around("@annotation(Transact)")
	public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("TransactionAspect manageTransaction");
		Object[] signatureArgs = joinPoint.getArgs();
		for(int i = 0; i<signatureArgs.length; i++){
			signatureArgs[i] = null;
		}
		return joinPoint.proceed(signatureArgs);
		
	}

}
