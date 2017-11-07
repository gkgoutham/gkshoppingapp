package com.gk.app.shopping.config;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private Log log = LogFactory.getLog(this.getClass());

	@Pointcut("execution(* com.gk.app.shopping.controller.*.*(..)) || "
			+ " execution(* com.gk.app.shopping.service.*.*(..)) ||" + " execution(* com.gk.app.shopping.dao.*.*(..))")
	public void loggingOperation() {

	}

	@Before("loggingOperation()")
	@Order(1)
	public void logJoinPoint(JoinPoint joinPoint) {
		log.info("Signature declaring type : " + joinPoint.getSignature().getDeclaringTypeName());
		log.info("Signature name : " + joinPoint.getSignature().getName());
		log.info("Arguments : " + Arrays.toString(joinPoint.getArgs()));
		log.info("Target class : " + joinPoint.getTarget().getClass().getName());
	}

	@AfterReturning(pointcut = "loggingOperation()", returning = "result")
	@Order(2)
	public void logAfter(JoinPoint joinPoint, Object result) {
		log.info("Exiting from Method :" + joinPoint.getSignature().getName());
		log.info("Return value :" + result);
	}

	@AfterThrowing(pointcut = "execution(* com.gk.app.shopping.controller.*.*(..)) || "
			+ " execution(* com.gk.app.shopping.service.*.*(..)) ||"
			+ " execution(* com.gk.app.shopping.dao.*.*(..))", throwing = "e")
	@Order(3)
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		log.error("An exception has been thrown in " + joinPoint.getSignature().getName() + "()");
		log.error("Cause :" + e.getCause());
	}

	@Around("execution(* com.gk.app.shopping.controller.*.*(..)) || "
			+ " execution(* com.gk.app.shopping.service.*.*(..)) || " + " execution(* com.gk.app.shopping.dao.*.*(..))")
	@Order(4)
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("The method " + joinPoint.getSignature().getName() + "() begins with "
				+ Arrays.toString(joinPoint.getArgs()));
		try {
			Object result = joinPoint.proceed();
			log.info("The method " + joinPoint.getSignature().getName() + "() ends with " + result);
			return result;
		} catch (IllegalArgumentException e) {
			log.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in "
					+ joinPoint.getSignature().getName() + "()");
			throw e;
		}
	}
}
