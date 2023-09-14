import models.OrderModel;
import presenters.OrderingPresenter;
import views.OrderingView;

public class Program {
    public static void main(String[] args) {

        /*
         * Создание экземпляра Модели для выполнения логики работы с заказами
         */
        OrderModel model = new OrderModel();
        /*
         * Создание экземпляра Представления для взаимодействия с пользователем
         */
        OrderingView view = new OrderingView();


        /*
         * Создание экземпляра Презентера для осуществления взаимодействия Модели и Представления
         */
        OrderingPresenter presenter = new OrderingPresenter(model, view);


        /*
         * Создание двух заказов в разных форматах сохранения
         */
        view.saveOrder("Console", "JSON");
        view.saveOrder("Console", "TXT");

        /*
         * Удаление первого заказа для теста
         */
        view.cancelOrder(1001);
    }

}
