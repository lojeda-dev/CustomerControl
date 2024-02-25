package DAO;

import entity.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDAO {
    List<CustomerDTO> findAll();

    CustomerDTO findById(CustomerDTO customer);

    void update(CustomerDTO customer);

    void save(CustomerDTO customer);

    void deleteById(CustomerDTO customer);
}