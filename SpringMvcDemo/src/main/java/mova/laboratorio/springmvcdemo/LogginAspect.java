package mova.laboratorio.springmvcdemo;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LogginAspect.class);
	
	@Before("execution(public * mova.laboratorio.springmvcdemo.AlienController.getAliens())")
	public void logBefore() {
		
		LOGGER.warn("Metodo a llamar: getAliens" );
	}
	
	@AfterReturning("execution(public * mova.laboratorio.springmvcdemo.AlienController.getAliens())")
	public void logAfter() {
		
		LOGGER.info("Metodo Finalizado: getAliens" );
	}
	
	@AfterThrowing("execution(public * mova.laboratorio.springmvcdemo.AlienController.getAliens())")
	public void logError() {
		
		LOGGER.info("Problemas" );
	}

}
