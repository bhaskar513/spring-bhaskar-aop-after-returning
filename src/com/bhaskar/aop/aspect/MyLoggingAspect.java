package com.bhaskar.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.bhaskar.aop.Account;

@Aspect
@Component

@Order(2)
public class MyLoggingAspect {

	@Before("com.bhaskar.aop.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n ===> executing MyLoggingAspect");
		
		// display the method signature
		MethodSignature methoSig=(MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methoSig);
		
		// display method arguments
		
		// Objects[] args
		
		Object[] args=theJoinPoint.getArgs();
		
		for(Object tempArg: args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				Account theAccount=(Account) tempArg;
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account lavel: " + theAccount.getLavel());
			}
			
		}
	}
	
	
	
	
}
