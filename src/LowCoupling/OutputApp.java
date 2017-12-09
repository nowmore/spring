package LowCoupling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OutputApp {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        OutputHelper out = (OutputHelper) ctx.getBean("OutputHelper");
        out.generateOutput();
    }
}
