package JDBC.Jdbc;

import JDBC.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class JdbcApp {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"JDBC/Jdbc/spring-module.xml"/*,
        "spring-datasource.xml", "spring-customer.xml"*/});
        CustomerDAO dao = (CustomerDAO)ctx.getBean("CustomerDAO");
        Customer cust = new Customer(19, "x", 25);
        dao.insert(cust);

        System.out.println(dao.queryById(1));
    }
}
