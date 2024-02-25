import DAO.CustomerImplDAO;
import entity.CustomerDTO;

import java.util.List;

public class test {
    public static void main(String[] args) {
        List<CustomerDTO> customers = new CustomerImplDAO().findAll();
        customers.forEach(customerDTO -> {
            System.out.println(customerDTO);
        });
    }
}
