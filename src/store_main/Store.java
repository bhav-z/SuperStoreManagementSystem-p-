package store_main;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class Store {

    private SimpleStringProperty category_name;
    private Button update;
    private Button delete;
    private Button add;
    private Button view;
    //private Button explore;
    //private Button go;

    public Button getExplore() {
        return explore;
    }

    public void setExplore(Button explore) {
        this.explore = explore;
    }

    private Button explore;

    public Store(String category_name) {
        this.category_name = new SimpleStringProperty(category_name);
        this.update=new Button("Update");
        this.delete=new Button("Delete");
        this.add=new Button("Add");
        this.explore=new Button("Explore");
        this.view=new Button("View");
        //this.go=new Button("Go")
    }

    public Button getView() {
        return view;
    }

    public void setView(Button view) {
        this.view = view;
    }

    public Button getAdd() {
        return add;
    }

    public void setAdd(Button add) {
        this.add = add;
    }

    public String getCategory_name() {
        return category_name.get();
    }

    public SimpleStringProperty category_nameProperty() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name.set(category_name);
    }

    public Button getUpdate() {
        return update;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }
}
