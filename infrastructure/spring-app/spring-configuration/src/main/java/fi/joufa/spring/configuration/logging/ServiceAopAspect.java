package fi.joufa.spring.configuration.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/** Aspect for logging business events. */
@Aspect
@Configuration
public class ServiceAopAspect {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Before("execution(* fi.joufa.agileservices.services.*.*(..))")
  public void beforeI(JoinPoint joinPoint) {
    logger.info("Before execution of {}", joinPoint);
  }

  @AfterReturning(
      value = "execution(* fi.joufa.agileservices.services.*.*(..))",
      returning = "result")
  public void afterReturning(JoinPoint joinPoint, Object result) {
    logger.info("{} returned with value {}", joinPoint, result);
  }

  @After(value = "execution(* fi.joufa.agileservies.services.*.*(..))")
  public void after(JoinPoint joinPoint) {
    logger.info("after execution of {}", joinPoint);
  }
}
