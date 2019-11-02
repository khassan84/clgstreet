package com.book.transaction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Transact {
	
    public Class[] rollbackOn() default {};
    
    public Class[] dontRollbackOn() default {};

}
