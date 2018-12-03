package MainClasses;

import java.util.ArrayList;

public class Subcategory {

    private String name;
    private ArrayList<InventoriedItem> items;
    private int id;


    public Subcategory(int id,String name) {
        this.name = name;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<InventoriedItem> getItems() {
        return items;
    }

    public void addItem(InventoriedItem a){
        items.add(a);
    }

    public void deleteItem(InventoriedItem a){
        int item_id=a.getId();
        int k=items.size();
        for(int i=0; i<k; i++){
            if(items.get(i).getId()==item_id) {
                items.remove(i);
                break;
            }
        }
    }
}
