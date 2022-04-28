package Dao;

import db.DBConnection;
import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl {
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
        ArrayList<CustomerDTO>AllCustomer= new ArrayList<>();
        while (rst.next()){
            String id = rst.getString(1);
            String name = rst.getString(2);
            String address = rst.getString(3);
            AllCustomer.add(new CustomerDTO(id, name, address));
        }
        return AllCustomer;
        }
        public boolean SaveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
            Connection connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
            pstm.setString(1, dto.getId());
            pstm.setString(2, dto.getName());
            pstm.setString(3, dto.getAddress());
            return pstm.executeUpdate()<0;
        }
        public boolean UpdateCustomer(CustomerDTO dtos) throws SQLException, ClassNotFoundException {
            Connection connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
            pstm.setString(1, dtos.getId());
            pstm.setString(2, dtos.getName());
            pstm.setString(3, dtos.getAddress());
            return pstm.executeUpdate()>0;
        }
    }

