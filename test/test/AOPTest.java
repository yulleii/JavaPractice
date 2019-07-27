package test;

import aop.MathCalculator;
import config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        MathCalculator mathCalculator=applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(2,3);
        applicationContext.close();
    }
}
