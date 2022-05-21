package bo;

import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PurchaseOrderBo {
     boolean purchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails)throws SQLException, ClassNotFoundException;

     CustomerDTO searchCustomer(String id ) throws SQLException, ClassNotFoundException;

     ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException ;

     boolean checkItemAvailable(String code) throws SQLException, ClassNotFoundException ;

     boolean checkCustomerIsAvailable(String id) throws SQLException, ClassNotFoundException ;

     String generateNewOrderId() throws SQLException, ClassNotFoundException ;

     ArrayList<CustomerDTO > loadAllCustomer() throws SQLException, ClassNotFoundException ;

     ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException ;

}
