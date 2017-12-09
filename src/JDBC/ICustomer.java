package JDBC;


public interface ICustomer {
     void       insert(Customer cust);
     Customer   queryById(int ID);
}
