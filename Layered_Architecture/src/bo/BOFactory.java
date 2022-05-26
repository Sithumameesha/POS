package bo;

import Dao.Custom.Impl.CustomerDAOImpl;
import Dao.DAOFactory;
import Dao.SuperDAO;
import bo.Custom.Impl.CustomerBoImpl;
import bo.Custom.Impl.ItemBoImpl;
import bo.Custom.Impl.PurchaseOrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    public BOFactory() {
    }

    public static BOFactory boFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;

    }
        public enum BOTypes {
            CUSTOMER,ITEM,PURCHASE_ORDER
        }
    public SuperBO getBO(BOTypes Types) {
        switch (Types) {
            case CUSTOMER:
                return new CustomerBoImpl();
            case ITEM:
                return new ItemBoImpl();
            case PURCHASE_ORDER:
                return new PurchaseOrderBOImpl();
            default:
                return null;
        }

    }
    }

