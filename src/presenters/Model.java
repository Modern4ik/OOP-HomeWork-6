package presenters;

import java.util.Collection;

public interface Model {
    /*
     * Метод загрузки коллекции с ID всех заказов
     */
    public Collection<Integer> loadAllOrdersID();

    /*
     * Метод сохранение заказа
     */
    public int saveOrder(String clientName, String product, int qnt, int price, String saveType);

    /*
     * Метод отмены заказа
     */
    public int cancelOrder(int orderId);
}
