package models.savers;

import models.Order;

public interface Saver {
    public void save(Order order);
}
