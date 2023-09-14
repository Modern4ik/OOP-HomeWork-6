package models;

public class Order {

    /*
     * ID заказа
     */
    private int orderId;

    /*
     * Имя клиента
     */
    private String clientName;
    
    /*
     * Название продукта
     */
    private String product;

    /*
     * Количество продукта
     */
    private int qnt;

    /*
     * Цена
     */
    private int price;

    /*
     * Статус заказа
     */
    private String status;

    private static int counter = 1000;

    {
        this.orderId = ++counter;
    }

    public Order() {

    }

    public Order(String clientName, String product, int qnt, int price) {
        this.clientName = clientName;
        this.product = product;
        this.qnt = qnt;
        this.price = price;
        this.status = "Открыт";
    }

    public String getClientName() {
        return this.clientName;
    }

    public String getProduct() {
        return this.product;
    }

    public int getQnt() {
        return this.qnt;
    }

    public int getPrice() {
        return this.price;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
