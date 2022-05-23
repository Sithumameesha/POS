package Dao;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }
    public static DAOFactory getDaoFactory(){
        if (daoFactory==null){
            daoFactory= new DAOFactory();
        }
        return daoFactory;

    }
    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER,ORDERDETAILS,QUERYDAO

    }
    public void getDAO(DAOTypes Types){
        switch (Types){
            case CUSTOMER:
                return;
            case ITEM:
                return;
            case ORDER:
                return;
            case ORDERDETAILS:
                return;
            case QUERYDAO:
                return;
        }
    }
}
