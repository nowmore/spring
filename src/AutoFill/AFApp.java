package AutoFill;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AFApp {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {""});
        Person person = (Person) ctx.getBean("");
    }
}
