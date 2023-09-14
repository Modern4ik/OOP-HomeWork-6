package presenters;

public class OrderingPresenter implements ViewObserver {
    private Model model;
    private View view;

    public OrderingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setObserver(this);
    }

    public void onSaveOrder(String clientName, String product, int qnt, int price, String saveType) {
        try{
            int resId = this.model.saveOrder(clientName, product, qnt, price, saveType);
            view.printSaveOrderResult(resId);
        }catch(RuntimeException exc){
            view.printSaveOrderResult(-1);
        }
    }

    public void onCancelOrder(int orderId){
        try{
            int cancelId = this.model.cancelOrder(orderId);
            view.printDeletionOrderResult(cancelId);
        }catch(RuntimeException exc){
            view.printDeletionOrderResult(-1);
        }
    }

}
