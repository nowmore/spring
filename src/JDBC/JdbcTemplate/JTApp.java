package JDBC.JdbcTemplate;

import JDBC.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JTApp {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"JDBC/JdbcTemplate/spring-module.xml"});
        CustomerDAO  dao = (CustomerDAO) ctx.getBean("CustomerDAO");
        Customer cust = dao.queryById(1);
        System.out.println(cust.toString());
        System.out.println(dao.queryCount());
    }
}
