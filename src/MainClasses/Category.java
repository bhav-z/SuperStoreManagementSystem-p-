package MainClasses;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Category {

    private String name;
    private ArrayList<Subcategory> subcategories;
    private int id;
    private  SimpleStringProperty name_s;

    public Category(String name) {
        this.name = name;
        this.name_s=new SimpleStringProperty((String) name);
        this.subcategories=new ArrayList<Subcategory>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SimpleStringProperty name_sProperty() {return  name_s;}
    public void setName(String name) {
        this.name = name;
    }

    public void addSubcategory(Subcategory s){
        subcategories.add(s);
    }

    public void deleteSubcategory(Subcategory s){
        int sub_id=s.getId();
        int k=subcategories.size();
        for(int i=0; i<k; i++){
            if(subcategories.get(i).getId()==sub_id) {
                subcategories.remove(i);
                break;
            }
        }
    }

    public void setId(int id) {
        this.id = id;
    }
}

