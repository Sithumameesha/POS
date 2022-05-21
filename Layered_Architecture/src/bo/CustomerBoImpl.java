package bo;

import Dao.Custom.CustomerDAO;
import Dao.Custom.Impl.CustomerDAOImpl;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl {
    private final CustomerDAO customerDAO = new CustomerDAOImpl();


    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
       return customerDAO.getAll();

    }
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(dto);
    }
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(dto);
    }
    public boolean customerIsAvailable(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
       return customerDAO.delete(id);
    }
    public String  generateNewId() throws SQLException, ClassNotFoundException {
     return customerDAO.generateNewID();
    }
}
