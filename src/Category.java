import java.util.ArrayList;

public class Category {

    private String name;
    private ArrayList<Subcategory> subcategories;
    private int id;

    public Category(String name) {
        this.name = name;
        this.subcategories=new ArrayList<Subcategory>();
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

}

