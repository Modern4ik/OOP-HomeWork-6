package presenters;

public interface ViewObserver {
    /*
     * Метод для сохранения заказа, который тригерится после полученя наблюдателем сигнала
     */
    public void onSaveOrder(String clientName, String product, int qnt, int price, String saveType);

    /*
     * Метод для удаления заказа, который тригерится после получения наблюдателем сигнала
     */
    public void onCancelOrder(int orderId);
}
