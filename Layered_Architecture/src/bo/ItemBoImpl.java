package bo;

import Dao.Custom.Impl.ItemDAOImpl;
import Dao.Custom.ItemDAO;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl {
    private final ItemDAO itemDAO = new ItemDAOImpl();

    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }
    public boolean deleteItems(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(code);
    }
    public boolean saveItems(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.save(dto);
    }
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(dto);
    }
    public boolean itemIsAvailable(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }
    public String  generateNewId() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewID();
    }
}
