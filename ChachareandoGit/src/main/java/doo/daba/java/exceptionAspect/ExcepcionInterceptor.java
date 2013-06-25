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


    @Pointcut("@within(doo.daba.java.annotation.ExceptionAnotation)")
    public void classExceptionPointcut() { }

    @Pointcut("@annotation(doo.daba.java.annotation.ExceptionAnotation)")
    public void methodExceptionPointcut() { }


    @AfterThrowing(pointcut = "classExceptionPointcut()", throwing = "e")
    public void afterThrowingMethod(Throwable e) {
        System.out.println("afterThrowingMethod a nivel de clase: " + e.getMessage());
    }


    @AfterThrowing(pointcut = "methodExceptionPointcut()", throwing = "e")
    public void afterThrowingClass(Throwable e) {
        System.out.println("afterThrowingMethod a nivel de método: " + e.getMessage());
    }

}
