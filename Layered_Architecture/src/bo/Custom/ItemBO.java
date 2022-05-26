package bo.Custom;

import bo.SuperBO;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
     ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

     boolean deleteItems(String code) throws SQLException, ClassNotFoundException;

     boolean saveItems(ItemDTO dto) throws SQLException, ClassNotFoundException;

     boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

     boolean itemIsAvailable(String code) throws SQLException, ClassNotFoundException;

     String  generateNewId() throws SQLException, ClassNotFoundException;

}
