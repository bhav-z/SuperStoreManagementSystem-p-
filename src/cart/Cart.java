package cart;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class Cart {

    SimpleStringProperty name;
    SimpleStringProperty quantity;
    SimpleStringProperty cost;
    Button del;
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

    public  Cart(String n, String q, String c){
        this.name=new SimpleStringProperty(n);
        this.quantity=new SimpleStringProperty(q);
        this.cost=new SimpleStringProperty(c);
        this.del=new Button("Remove");
        this.date=new SimpleStringProperty("7/12/18");
        this.ID=new SimpleStringProperty("10");
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getQuantity() {
        return quantity.get();
    }

    public SimpleStringProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity.set(quantity);
    }

    public String getCost() {
        return cost.get();
    }

    public SimpleStringProperty costProperty() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost.set(cost);
    }

    public Button getDel() {
        return del;
    }

    public void setDel(Button del) {
        this.del = del;
    }
}
