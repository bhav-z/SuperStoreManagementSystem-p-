package MainClasses;

public class Store extends Place{
    private String name;
    private int ID;
    private int capacity;
    private Warehouse linked_warehouse;
    private StoreInventory inventory;
    public void changeWarehouse(Warehouse neeu){
        linked_warehouse=neeu;
    }
    public Store() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
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
