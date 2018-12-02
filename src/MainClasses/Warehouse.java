package MainClasses;

public class Warehouse extends Place{

    private String name;
    private int id;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setID(int i) {
        this.id = id;
    }


}
