package Dao;

import model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO{

    @Override
    public ArrayList<OrderDetailsDAO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDetailsDAO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDetailsDAO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDetailsDAO search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
//    @Override
//    public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
//        return null;
//    }
//
//    @Override
//    public boolean save(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
//       return SQLUtil.executeUpdate("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",dto.getOid(),dto.getItemCode(),dto.getUnitPrice(),dto.getQty());
//    }
//
//    @Override
//    public boolean update(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
//        return false;
//    }
//
//    @Override
//    public boolean exist(String s) throws SQLException, ClassNotFoundException {
//        return false;
//    }
//
//    @Override
//    public OrderDetailDTO search(String s) throws SQLException, ClassNotFoundException {
//        return null;
//    }
//
//    @Override
//    public boolean delete(String s) throws SQLException, ClassNotFoundException {
//        return false;
//    }
//
//    @Override
//    public String generateNewID() throws SQLException, ClassNotFoundException {
//        return null;
//    }
//}
