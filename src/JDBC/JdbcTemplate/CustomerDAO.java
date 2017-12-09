package JDBC.JdbcTemplate;

import JDBC.Customer;
import JDBC.ICustomer;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerDAO extends JdbcDaoSupport implements ICustomer {
    @Override
    public void insert(Customer cust) {
        String sql = "INSERT INTO customer(cust_id, name, age)" +
                "VALUES(?,?,?)";

        getJdbcTemplate().update(sql, new Object[]{ cust.getID(),
                cust.getName(), cust.getAge()});
    }

    /* 查询单行 */
    /*
    @Override
    public Customer queryById(int ID) {
        String sql = "SELECT * FROM customer WHERE CUST_ID = ?";
        Customer cust = (Customer)getJdbcTemplate().queryForObject(sql,
                new Object[] {ID}, new CustRowMapper());
        return cust;
    }*/
    @Override
    public Customer queryById(int ID) {
        String sql = "SELECT * FROM customer WHERE CUST_ID = ?";
        Customer cust = (Customer)getJdbcTemplate().queryForObject(sql,
                new Object[] {ID}, new BeanPropertyRowMapper(Customer.class));
        return cust;
    }

    /* 查询多行 */
    /*
    public List<Customer> queryAll(){
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer";

        List<Map<String, Object>> rows =getJdbcTemplate().queryForList(sql);
        for(Map row : rows){
            Customer cust = new Customer();
            cust.setID((int)row.get("cust_id"));
            cust.setAge((int)row.get("age"));
            cust.setName((String)row.get("name"));
            customers.add(cust);
        }
        return customers;
    }
    */

    public List<Customer> queryAll(){
        String sql = "SELECT * FROM customer";

        List<Customer> customers = getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper(Customer.class));

        return customers;
    }

    /* 查询单列 */
    public String queryNameById(int Id){
        String sql = "SELECT name FROM customer WHERE cust_id = ?";

        String name = getJdbcTemplate().queryForObject(sql, new Object[] {Id}, String.class);
        return name;
    }

    /* 查询行数 */
    public int queryCount(){
        String sql = "SELECT COUNT(*) FROM customer";
        Integer cnt =  getJdbcTemplate().queryForObject(sql,new Object[]{}, Integer.class);
        return cnt;
    }

    /* 多行插入 */
    public void insertBatch(final List<Customer> customers){
        String sql = "INSERT INTO customer(cust_id, name, age)"+
                "VALUES(?,?,?)";

        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Customer cust = customers.get(i);
                ps.setInt(1, cust.getID());
                ps.setString(2,cust.getName());
                ps.setInt(3,cust.getAge());
            }

            @Override
            public int getBatchSize() {
                return customers.size();
            }
        });
    }

    public void insertBatch(String sql){
        getJdbcTemplate().batchUpdate(new String[] {sql});
    }
}
