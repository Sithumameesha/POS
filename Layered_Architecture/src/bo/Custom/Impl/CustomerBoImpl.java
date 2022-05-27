package bo.Custom.Impl;

import Dao.Custom.CustomerDAO;
import Dao.DAOFactory;
import bo.Custom.CustomerBo;
import dto.CustomerDTO;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {
    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

 @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
     //  return customerDAO.getAll();
     ArrayList<Customer> all =customerDAO.getAll();
     ArrayList<CustomerDTO>allCustomers =new ArrayList<>();
     for (Customer customer: all ){
         allCustomers.add(new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress()));
     }
     return allCustomers;
    }
    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }
    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }
    @Override
    public boolean customerIsAvailable(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }
    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
       return customerDAO.delete(id);
    }
    @Override
    public String  generateNewId() throws SQLException, ClassNotFoundException {
     return customerDAO.generateNewID();
    }
}
