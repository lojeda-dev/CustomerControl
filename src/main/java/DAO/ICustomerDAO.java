package DAO;

import entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDAO {
    List<Customer> findAll() throws SQLException;

    void update(Customer customer) throws SQLException;

    void save(Customer customer) throws SQLException;

    void deleteById(Customer customer) throws SQLException;
}