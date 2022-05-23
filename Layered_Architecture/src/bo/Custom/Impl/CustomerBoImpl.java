package bo.Custom.Impl;

import Dao.Custom.CustomerDAO;
import Dao.Custom.Impl.CustomerDAOImpl;
import Dao.DAOFactory;
import bo.Custom.CustomerBo;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {
    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

 @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
       return customerDAO.getAll();

    }
    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(dto);
    }
    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(dto);
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
