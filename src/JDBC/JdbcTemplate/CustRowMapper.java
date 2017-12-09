package JDBC.JdbcTemplate;

import JDBC.Customer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustRowMapper implements RowMapper{
    @Nullable
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer cust = new Customer();
        cust.setID(rs.getInt("cust_id"));
        cust.setAge(rs.getInt("age"));
        cust.setName(rs.getString("name"));
        return cust;
    }
}
