package lk.ijse.pos.bo.Custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.dto.OrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseOrderBo extends SuperBO {
     boolean purchaseOrder(OrderDTO dto)throws SQLException, ClassNotFoundException;

     CustomerDTO searchCustomer(String id ) throws SQLException, ClassNotFoundException;

     ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException ;

     boolean checkItemAvailable(String code) throws SQLException, ClassNotFoundException ;

     boolean checkCustomerIsAvailable(String id) throws SQLException, ClassNotFoundException ;

     String generateNewOrderId() throws SQLException, ClassNotFoundException ;

     ArrayList<CustomerDTO > loadAllCustomer() throws SQLException, ClassNotFoundException ;

     ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException ;

}
