package DAO;

import SQLconnection.SQLconnection;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements ICustomerDAO {

    private static final String SELECT = "SELECT * FROM customers";
    private static final String INSERT = "INSERT INTO customers (name,surname, email, phone, balance) VALUES (?,?,?,?,?)";
    private static final String UPDATE = "UPDATE customers SET name = ?, surname = ?, email = ?, phone = ?, balance = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM customers WHERE id = ?";

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    @Override
    public List<Customer> findAll() throws SQLException {
        con = SQLconnection.getConnection();
        ps = con.prepareStatement(SELECT);
        rs = ps.executeQuery();
        List<Customer> customers = new ArrayList<>();
        while (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getLong("id"));
            customer.setName(rs.getString("name"));
            customer.setSurname(rs.getString("surname"));
            customer.setEmail(rs.getString("email"));
            customer.setPhone(rs.getString("phone"));
            customer.setBalance(rs.getFloat("balance"));
            customers.add(customer);
        }
        SQLconnection.close(rs);
        SQLconnection.close(ps);
        SQLconnection.close(con);

        return customers;
    }

    @Override
    public Customer save(Customer customer) throws SQLException {
        con = SQLconnection.getConnection();
        ps = con.prepareStatement(INSERT);
        ps.setString(1, customer.getName());
        ps.setString(2, customer.getSurname());
        ps.setString(3, customer.getEmail());
        ps.setString(4, customer.getPhone());
        ps.setDouble(5, customer.getBalance());
        ps.executeUpdate();
        SQLconnection.close(ps);
        SQLconnection.close(con);

        return customer;
    }

    @Override
    public Customer update(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
