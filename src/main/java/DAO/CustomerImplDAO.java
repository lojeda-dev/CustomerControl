package DAO;

import Connection.SQLconnection;
import entity.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerImplDAO implements ICustomerDAO {

    private static final String SELECT = "SELECT * FROM customers";
    private static final String SELECT_BY_ID = "SELECT * FROM customers WHERE id = ?";
    private static final String INSERT = "INSERT INTO customers (name,surname, email, phone, balance) VALUES (?,?,?,?,?)";
    private static final String UPDATE = "UPDATE customers SET name = ?, surname = ?, email = ?, phone = ?, balance = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM customers WHERE id = ?";

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs = null;

    @Override
    public List<CustomerDTO> findAll() {
        List<CustomerDTO> customers = new ArrayList<>();
        ResultSet result = null;
        try {
            con = SQLconnection.getConnection();
            ps = con.prepareStatement(SELECT);
            result = ps.executeQuery();

            while (result.next()) {
                CustomerDTO customer = new CustomerDTO();
                customer.setId(result.getInt("id"));
                customer.setName(result.getString("name"));
                customer.setSurname(result.getString("surname"));
                customer.setEmail(result.getString("email"));
                customer.setPhone(result.getString("phone"));
                customer.setBalance(result.getFloat("balance"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                SQLconnection.close(result);
                SQLconnection.close(ps);
                SQLconnection.close(con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return customers;
    }

    @Override
    public CustomerDTO findById(CustomerDTO customer) {
        try {
            con = SQLconnection.getConnection();
            ps = con.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, customer.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                customer.setName(rs.getString("name"));
                customer.setSurname(rs.getString("surname"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));
                customer.setBalance(rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                SQLconnection.close(rs);
                SQLconnection.close(ps);
                SQLconnection.close(con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return customer;
    }

    @Override
    public void save(CustomerDTO customer) {
        try {
            con = SQLconnection.getConnection();
            ps = con.prepareStatement(INSERT);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getSurname());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPhone());
            ps.setDouble(5, customer.getBalance());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                SQLconnection.close(ps);
                SQLconnection.close(con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void update(CustomerDTO customer) {
        try {
            con = SQLconnection.getConnection();
            ps = con.prepareStatement(UPDATE);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getSurname());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPhone());
            ps.setDouble(5, customer.getBalance());
            ps.setInt(6, customer.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                SQLconnection.close(ps);
                SQLconnection.close(con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void deleteById(CustomerDTO customer) {
        try {
            con = SQLconnection.getConnection();
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, customer.getId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                SQLconnection.close(ps);
                SQLconnection.close(con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
