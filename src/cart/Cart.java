package cart;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class Cart {

    private String name;
    private int quantity;
    private int cost;
    private Button del;
    SimpleStringProperty date;
    SimpleStringProperty ID;

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getID() {
        return ID.get();
    }

    public SimpleStringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public  Cart(String n, int q, int c){
        this.name=n;
        this.quantity=q;
        this.cost= c;
//        this.del=new Button("Remove");
//        this.date=new SimpleStringProperty("7/12/18");
//        this.ID=new SimpleStringProperty("10");
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name=n;
    }

    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int q) {
        quantity=q;
    }

    public int getCost() {
        return cost;
    }


    public void setCost(int c) {
        cost=c;
    }

    public Button getDel() {
        return del;
    }

    public void setDel(Button del) {
        this.del = del;
    }
}
