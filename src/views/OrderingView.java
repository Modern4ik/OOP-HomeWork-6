package views;

import java.util.Queue;

import presenters.View;
import presenters.ViewObserver;
import views.inputs.InputFromConsole;

public class OrderingView implements View {

    private ViewObserver observer;

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void cancelOrder(int orderId) {
        this.observer.onCancelOrder(orderId);
    }

    @Override
    public void saveOrder(String inputType, String saveType) {
        String clientName = "";
        String product = "";
        int qnt = 0;
        int price = 0;

        switch (inputType) {
            case "Console":
                InputFromConsole orderInput = new InputFromConsole();
                Queue<Object> orderInfo = orderInput.inputFromConsole();

                clientName = (String) orderInfo.poll();
                product = (String) orderInfo.poll();
                qnt = (int) orderInfo.poll();
                price = (int) orderInfo.poll();

                break;
        }

        this.observer.onSaveOrder(clientName, product, qnt, price, saveType);
    }

    public void printSaveOrderResult(int orderRes) {
        if (orderRes != -1) {
            System.out.printf("Заказ успешно оформлен!Ваш номер заказа: %d \n", orderRes);
        } else {
            System.out.println("Невозможно сохранить заказ!Проверьте правильность выбора типа сохранения!");
        }
    }

    public void printDeletionOrderResult(int resId) {
        if (resId != - 1) {
            System.out.println("-------------------------------");
            System.out.printf("Заказ с номером %d успешно удалён!\n", resId);
            System.out.println("-------------------------------");
        }else {
            System.out.println("-------------------------------");
            System.out.println("Удаление невозможно! Заказа с данным ID нету в нашей базе!");
            System.out.println("-------------------------------");
        }
    }
}
