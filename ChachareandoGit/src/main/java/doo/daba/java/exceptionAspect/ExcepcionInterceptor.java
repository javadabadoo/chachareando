package doo.daba.java.exceptionAspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 19/06/13
 */
@Aspect
@Component
public class ExcepcionInterceptor {


    @Pointcut("within(doo.daba.java.exceptionAspect.basura..*)")
    public void customPointcut() { }


    @Before("doo.daba.java.exceptionAspect.ExcepcionInterceptor.customPointcut()")
    public void doExecuteControllerAdviceUno() {
        System.out.println("Antes de ejecutar el poincut");
    }


    @AfterThrowing(pointcut = "doo.daba.java.exceptionAspect.ExcepcionInterceptor.customPointcut()", throwing = "e")
    public void afterThrowingMethod(Throwable e) {
        System.out.println("afterThrowingMethod: " + e.getMessage());
    }

}
