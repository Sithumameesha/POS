package bo.Custom;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDTO;
import dto.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
