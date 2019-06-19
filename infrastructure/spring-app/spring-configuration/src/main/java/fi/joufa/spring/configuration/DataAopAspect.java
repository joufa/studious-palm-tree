package fi.joufa.spring.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class DataAopAspect {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  // Data logging
  @AfterReturning(
      value = "execution(* fi.joufa.databaserepository.repository.impl.*.*(..))",
      returning = "result")
  public void afterReturning(JoinPoint joinPoint, Object result) {
    logger.info("{} returned with value {}", joinPoint, result);
  }

  @After(value = "execution(* fi.joufa.databaserepository.repository.impl*.*(..))")
  public void after(JoinPoint joinPoint) {
    logger.info("after execution of {}", joinPoint);
  }

  @Before("execution(* fi.joufa.databaserepository.repository.impl*.*(..))")
  public void before(JoinPoint joinPoint) {
    logger.info(" Before execution {}", joinPoint);
  }
}
