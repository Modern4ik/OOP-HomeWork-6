package models.savers;

import java.io.FileWriter;
import java.io.IOException;

import models.Order;

public class SaverJSON implements Saver{
    public void save(Order order) {
        String fileName = "src//models//DataBase/order" + order.getOrderId() + ".json";
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("{\n");
            writer.write("\"clientName\":\""+ order.getClientName() + "\",\n");
            writer.write("\"product\":\""+order.getProduct()+"\",\n");
            writer.write("\"qnt\":"+order.getQnt()+",\n");
            writer.write("\"price\":"+order.getPrice()+",\n");
            writer.write("\"status\":\""+order.getStatus()+"\"\n");
            writer.write("}\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
