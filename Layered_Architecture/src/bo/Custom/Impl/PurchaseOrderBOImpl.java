package bo.Custom.Impl;

import Dao.CrudDAO;
import Dao.Custom.*;
import Dao.Custom.Impl.*;
import Dao.DAOFactory;
import bo.Custom.PurchaseOrderBo;
import db.DBConnection;
import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDTO;
import dto.OrderDetailDTO;
import entity.Customer;
import entity.Item;
import entity.OrderDetails;
import entity.Orders;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderBOImpl implements PurchaseOrderBo {
    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);// hide the object creation logic through the factory
    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    private final OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    private final OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);
    private final QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERYDAO);


@Override
    public boolean purchaseOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
    CrudDAO<Orders,String> orderDAO= new OrderDAOImpl();
            Connection connection= DBConnection.getDbConnection().getConnection();
            /*if order id already exist*/
            if (orderDAO.exist(dto.getOrderId())) {

            }

            //connection.setAutoCommit(false);
//            stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
//            stm.setString(1, orderId);
//            stm.setDate(2, Date.valueOf(orderDate));
//            stm.setString(3, customerId);
            OrderDAOImpl orderDAO1 = new OrderDAOImpl();
            boolean save = orderDAO1.save(new Orders(dto.getOrderId(),dto.getOrderDate(), dto.getCustomerId()));

            if (!save) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            // stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
            OrderDetailsDAOImpl orderDetailsDAO= new OrderDetailsDAOImpl();

            for (OrderDetailDTO detailDTO : dto.getOrderDetails()) {
                boolean save1 = orderDetailsDAO.save(new OrderDetails(detailDTO.getOid(),detailDTO.getItemCode(),detailDTO.getQty(),detailDTO.getUnitPrice()));
                if (!save1) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

//                //Search & Update Item
//                ItemDTO item = findItem(detail.getItemCode());
                ItemDTO item = null;
                item.setQtyOnHand(item.getQtyOnHand() - detailDTO.getQty());



                boolean update= itemDAO.update(new Item(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));
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


    @Override
    public CustomerDTO searchCustomer(String id ) throws SQLException, ClassNotFoundException {
      // return customerDAO.search(id);
        Customer ent = customerDAO.search(id);
        return new CustomerDTO(ent.getId(), ent.getName(), ent.getAddress());

    }
    @Override
    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        Item ent = itemDAO.search(code);
        return new ItemDTO(ent.getCode(), ent.getDescription(), ent.getUnitPrice(),ent.getQtyOnHand());
    }
    @Override
    public boolean checkItemAvailable(String code) throws SQLException, ClassNotFoundException {
       return itemDAO.exist(code);
    }
    @Override
    public boolean checkCustomerIsAvailable(String id) throws SQLException, ClassNotFoundException {
       return customerDAO.exist(id);
    }
    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewID();
    }
    @Override
    public ArrayList <CustomerDTO >loadAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> all = customerDAO.getAll();
        ArrayList<CustomerDTO>allCustomers=new ArrayList<>();
        for (Customer cu : all) {
            allCustomers.add(new CustomerDTO(cu.getId(),cu.getName(),cu.getAddress()));

        }
        return allCustomers;

    }
    @Override
    public ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<Item> all = itemDAO.getAll();
        ArrayList<ItemDTO>allItems = new ArrayList<>();
        for (Item item : all) {
allItems.add(new ItemDTO(item.getCode(), item.getDescription(),item.getUnitPrice(), item.getQtyOnHand()));
        }
        return  allItems;
        //Nothung

    }
}
