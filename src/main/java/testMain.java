import DAO.CustomerImpl;
import entity.Customer;

import java.sql.SQLException;
import java.util.List;

public class testMain {
    public static void main(String[] args) throws SQLException {
        CustomerImpl c = new CustomerImpl();

        /*Customer newCustomer = new Customer("Estela","Rosalia","erosalia@mail.com","1478523690",400);
        Customer saveCustomer = c.save(newCustomer);
        System.out.println(saveCustomer.toString());*/

        /*List<Customer> customers = c.findAll();
        customers.forEach( customer-> {
            System.out.println(customer.toString());
        });*/
    }
}
