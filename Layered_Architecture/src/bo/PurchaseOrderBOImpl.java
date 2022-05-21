package bo;

import Dao.CrudDAO;
import Dao.Custom.*;
import Dao.Custom.Impl.*;
import db.DBConnection;
import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderBOImpl {
    private final CustomerDAO customerDAO = new CustomerDAOImpl();
    private final ItemDAO itemDAO = new ItemDAOImpl();
    private final OrderDAO orderDAO = new OrderDAOImpl();
    private final OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();
    private final QueryDAO queryDAO=new QueryDAOImpl();

    public boolean purchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {

            CrudDAO<OrderDTO,String> orderDAO= new OrderDAOImpl();
            Connection connection= DBConnection.getDbConnection().getConnection();
            /*if order id already exist*/
            if (orderDAO.exist(orderId)) {

            }

            //connection.setAutoCommit(false);
//            stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
//            stm.setString(1, orderId);
//            stm.setDate(2, Date.valueOf(orderDate));
//            stm.setString(3, customerId);
            OrderDAOImpl orderDAO1 = new OrderDAOImpl();
            boolean save = orderDAO1.save(new OrderDTO(orderId,orderDate,customerId));

            if (!save) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            // stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
            OrderDetailsDAOImpl orderDetailsDAO= new OrderDetailsDAOImpl();

            for (OrderDetailDTO detail : orderDetails) {
                boolean save1 = orderDetailsDAO.save(detail);
                if (!save1) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

//                //Search & Update Item
//                ItemDTO item = findItem(detail.getItemCode());
                ItemDTO item = null;
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());


                CrudDAO<ItemDTO,String>itemDAO= new ItemDAOImpl();
                boolean update = itemDAO.update(new ItemDTO(item.getCode(),
                        item.getDescription(),
                        item.getUnitPrice(),
                        item.getQtyOnHand()));

                if (!update) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }

            // connection.commit();
            // connection.setAutoCommit(true);
            return true;



        //return false;
    }
    public CustomerDTO searchCustomer(String id ) throws SQLException, ClassNotFoundException {
       return customerDAO.search(id);

    }
    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
         return itemDAO.search(code);
    }
    public boolean checkItemAvailable(String code) throws SQLException, ClassNotFoundException {
       return itemDAO.exist(code);
    }
    public boolean checkCustomerIsAvailable(String id) throws SQLException, ClassNotFoundException {
       return customerDAO.exist(id);
    }
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewID();
    }
    public ArrayList <CustomerDTO >loadAllCustomer() throws SQLException, ClassNotFoundException {
     return customerDAO.getAll();
    }
    public ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }
}