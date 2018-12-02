package MainClasses;

/**
 * Base Inventoried item class
 */
public class InventoriedItem extends Item{

    private int number_of_units;
    private double demand;
    private double carrying_cost;
    private double fixed_cost;

    public InventoriedItem(String name) {
        super(name);
    }

    public int getNumber_of_units() {
        return number_of_units;
    }

    public void setNumber_of_units(int number_of_units) {
        this.number_of_units = number_of_units;
    }

    public double getDemand() {
        return demand;
    }

    public void setDemand(double demand) {
        this.demand = demand;
    }

    public double getCarrying_cost() {
        return carrying_cost;
    }

    public void setCarrying_cost(double carrying_cost) {
        this.carrying_cost = carrying_cost;
    }

    public double getFixed_cost() {
        return fixed_cost;
    }

    public void setFixed_cost(double fixed_cost) {
        this.fixed_cost = fixed_cost;
    }
}
