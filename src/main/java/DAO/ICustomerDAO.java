package DAO;

import entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDAO {
    List<Customer> findAll() throws SQLException;

    Customer update(Long id) throws SQLException;

    Customer save(Customer Customer) throws SQLException;

    void deleteById(Long id) throws SQLException;
}
