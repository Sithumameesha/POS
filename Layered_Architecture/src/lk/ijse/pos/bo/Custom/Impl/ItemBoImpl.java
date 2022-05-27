package lk.ijse.pos.bo.Custom.Impl;

import lk.ijse.pos.Dao.Custom.ItemDAO;
import lk.ijse.pos.Dao.DAOFactory;
import lk.ijse.pos.bo.Custom.ItemBO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBO {
    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

 @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
     ArrayList<Item> all =itemDAO.getAll();
     ArrayList<ItemDTO> allItems =new ArrayList<>();
     for (Item item: all ){
         allItems.add(new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(), item.getQtyOnHand()));
     }
     return allItems;
    }
    @Override
    public boolean deleteItems(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(code);
    }
    @Override
    public boolean saveItems(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.save(new Item(dto.getCode(),dto.getDescription(),dto.getUnitPrice(), dto.getQtyOnHand()));
    }
    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new Item(dto.getCode(),dto.getDescription(),dto.getUnitPrice(), dto.getQtyOnHand()));
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
