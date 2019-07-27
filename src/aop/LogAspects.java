package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;
import java.util.concurrent.Executor;
@Aspect
public class LogAspects {
    @Pointcut("execution(public int aop.MathCalculator.*(..))")
    public void pointCut(){};

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[]args=joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"运行..参数列表是:{"+ Arrays.asList(args)+"}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        Object[]args=joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"结束...");
    }

    @AfterReturning(value="pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName()+"正常返回...运行结果：{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception){
        System.out.println(joinPoint.getSignature().getName()+"异常...异常信息：{"+exception+"}");
    }
}
