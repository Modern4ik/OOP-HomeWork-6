package models;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import models.savers.Saver;
import models.savers.SaverJSON;
import models.savers.SaverTXT;
import presenters.Model;

public class OrderModel implements Model {
    private Collection<Integer> ordersList;

    public OrderModel() {
        this.ordersList = new ArrayList<>();
    }

    @Override
    public Collection<Integer> loadAllOrdersID() {
        return this.ordersList;
    }

    @Override
    public int cancelOrder(int orderId) throws RuntimeException {

        if (loadAllOrdersID().contains(orderId)) {
            File jsonFile = new File("src/models/DataBase/order" + orderId + ".json");
            jsonFile.delete();

            File txtFile = new File("src/models/DataBase/order" + orderId + ".txt");
            txtFile.delete();

            return orderId;
        }

        throw new RuntimeException("Deletion Error");
    }

    @Override
    public int saveOrder(String clientName, String product, int qnt, int price, String saveType)
            throws RuntimeException {
        Saver saver;
        Order newOrder = new Order(clientName, product, qnt, price);

        switch (saveType.toUpperCase()) {
            case "JSON":
                saver = new SaverJSON();
                saver.save(newOrder);

                loadAllOrdersID().add(newOrder.getOrderId());
                return newOrder.getOrderId();
            case "TXT":
                saver = new SaverTXT();
                saver.save(newOrder);

                loadAllOrdersID().add(newOrder.getOrderId());
                return newOrder.getOrderId();
            default:
                throw new RuntimeException("SaveFileError");
        }
    }

}
