package JDBC.Jdbc;

import JDBC.Customer;
import JDBC.ICustomer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO implements ICustomer {
    private DataSource dataSrc;

    public void setDataSrc(DataSource dataSrc){ this.dataSrc = dataSrc;}

    public void insert(Customer cust){
        String sql = "INSERT INTO customer(cust_id, name, age)" +
                "VALUES(?,?,?)";

        Connection conn = null;

        try{
            conn = dataSrc.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, cust.getID());
            ps.setString(2, cust.getName());
            ps.setInt(3,cust.getAge());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            if(null != conn){
                try{
                    conn.close();
                }catch (SQLException e){

                }
            }
        }

    }

    public Customer queryById(int Id){
        Customer cust = null;
        String sql = "SELECT * FROM customer WHERE CUST_ID = ?";

        Connection conn = null;
        try{
            conn = dataSrc.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cust = new Customer(rs.getInt("cust_id"),
                        rs.getString("name"),
                        rs.getInt("age")
                );
            }
            rs.close();
            ps.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            if(null != conn){
                try{
                    conn.close();
                }catch (SQLException e){

                }
            }
        }

        return cust;
    }
}
