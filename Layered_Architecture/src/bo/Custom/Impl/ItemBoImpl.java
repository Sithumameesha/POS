package bo.Custom.Impl;

import Dao.Custom.Impl.ItemDAOImpl;
import Dao.Custom.ItemDAO;
import bo.Custom.ItemBO;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBO {
    private final ItemDAO itemDAO = new ItemDAOImpl();

 @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }
    @Override
    public boolean deleteItems(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(code);
    }
    @Override
    public boolean saveItems(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.save(dto);
    }
    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(dto);
    }
    @Override
    public boolean itemIsAvailable(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }
    @Override
    public String  generateNewId() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewID();
    }
}
