package Dao.Custom;

import Dao.SuperDAO;
import dto.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<CustomDTO> searchOrderByOrderID(String id)throws SQLException,ClassNotFoundException;
}
