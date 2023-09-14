package presenters;

public interface View {
    /*
     * Метод сохранения заказа
     */
    public void saveOrder(String inputType, String saveType);

    /*
     * Метод отмены заказа
     */
    public void cancelOrder(int orderId);

    /*
     * Метод, который добавляет наблюдателя
     */
    public void setObserver(ViewObserver observer);

    /*
     * Метод, который выдаёт пользователю информацию,
     * о результате добавления заказа
     */
    public void printSaveOrderResult(int resId);

    /*
     * Метод, который выдаёт пользователю информацию,
     * о результате удаления заказа
     */
    public void printDeletionOrderResult(int resId);

}
