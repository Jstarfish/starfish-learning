package priv.starfish.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * @description: 日志切面类
 * @author: starfish
 * @date: 2021/7/14 19:30
 */
@Aspect
@Component
public class LogAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 前置通知，目标方法调用前被调用
     */
    @Before("execution(* priv.starfish.aop.aspect.Calculator.add(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("The method " + joinPoint.getSignature().getName()
                + "() begins with " + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 后置通知，目标方法执行完执行
     */
    @After("execution( * *.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        log.info("The method " + joinPoint.getSignature().getName() + "() ends");
    }

    /**
     * 后置异常通知
     *  定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
     *  throwing 只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
     */
    @AfterThrowing(value = "loggingOperation()",throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint,ArithmeticException exception){
        log.error(joinPoint.getSignature().getName() + "has throw an exception" + exception);
    }

    /**
     * 后置返回通知
     * 如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
     * 如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
     * returning 只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行
     */
    @AfterReturning(value = "loggingOperation()",returning = "res")
    public void afterReturningAdvice(JoinPoint joinPoint, Object res){
        System.out.println("- - - - - 后置返回通知- - - - -");
        System.out.println("后置返回通知 返回值："+res);
    }

    /**
     * 环绕通知：
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     */
    @Around("loggingOperation()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint){
        System.out.println("- - - - - 环绕前置通知 - - - -");
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object[] params = joinPoint.getArgs();
        try {
            //调用执行目标方法
            Object obj = joinPoint.proceed();
            System.out.println("- - - - - 环绕后置返回通知 - - - -");
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("- - - - - 环绕异常通知 - - - -");
        }finally {
            System.out.println("- - - - - 环绕后置通知 - - - -");
        }
        return null;
    }


    /**
     * 切入点
     */
    @Pointcut("execution(public int priv.starfish.aop.aspect.CalculatorImpl.*(int,int))")
    public void loggingOperation(){};

}
