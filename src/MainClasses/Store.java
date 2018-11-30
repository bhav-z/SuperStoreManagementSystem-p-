package MainClasses;

public class Store {
    private String name;
    private int ID;
    private int capacity;
    private Warehouse linked_warehouse;
    private StoreInventory inventory;
    public void changeWarehouse(Warehouse neeu){
        linked_warehouse=neeu;
    }
    public Store(String n, int id) {
        this.name = n;
        this.ID = id;
    }
    public Order getItemsToOrder(){
        return  new Order();
    }
    public StoreInventory getInventory(){
        return new StoreInventory();
    }
    public Order createOrder(){
        return new Order();
    }
}
