package w_manageorder;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class Order {

    private SimpleStringProperty sname;
    private SimpleStringProperty sid;
    private SimpleStringProperty iname;
    private SimpleStringProperty iid;
    private SimpleStringProperty quantity;
    private SimpleStringProperty date;
    private SimpleStringProperty feasible;
    private Button fulfill;
    private Button forward;
    private Button order;
    private Button link;
    private Button view;
    private Button delete;
    private Button setpass;

    public Button getLink() {
        return link;
    }

    public Button getSetpass() {
        return setpass;
    }

    public void setSetpass(Button setpass) {
        this.setpass = setpass;
    }

    public void setLink(Button link) {
        this.link = link;
    }

    public Button getView() {
        return view;
    }

    public void setView(Button view) {
        this.view = view;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public Order(String sname, String sid, String iname, String iid, String quantity, String date, String feasible) {
        this.sname = new SimpleStringProperty(sname);
        this.sid = new SimpleStringProperty(sid);
        this.iname = new SimpleStringProperty(iname);
        this.iid = new SimpleStringProperty(iid);
        this.quantity = new SimpleStringProperty(quantity);
        this.date = new SimpleStringProperty(date);
        this.feasible = new SimpleStringProperty(feasible);
        this.fulfill=new Button("Fulfill");
        this.forward=new Button("Forward");
        this.order=new Button("Order");
        this.view=new Button("View");
        this.link=new Button("Link");
        this.delete=new Button("Delete");
        this.setpass=new Button("Set Password");
    }

    public Button getOrder() {
        return order;
    }

    public void setOrder(Button order) {
        this.order = order;
    }

    public Button getFulfill() {
        return fulfill;
    }

    public void setFulfill(Button fulfill) {
        this.fulfill = fulfill;
    }

    public Button getForward() {
        return forward;
    }

    public void setForward(Button forward) {
        this.forward = forward;
    }

    public String getSname() {
        return sname.get();
    }

    public SimpleStringProperty snameProperty() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname.set(sname);
    }

    public String getSid() {
        return sid.get();
    }

    public SimpleStringProperty sidProperty() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid.set(sid);
    }

    public String getIname() {
        return iname.get();
    }

    public SimpleStringProperty inameProperty() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname.set(iname);
    }

    public String getIid() {
        return iid.get();
    }

    public SimpleStringProperty iidProperty() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid.set(iid);
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

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getFeasible() {
        return feasible.get();
    }

    public SimpleStringProperty feasibleProperty() {
        return feasible;
    }

    public void setFeasible(String feasible) {
        this.feasible.set(feasible);
    }
}
