package hogwarts.data;

public class Ingredient extends TeachingMaterial {
    // Fields
    private String name;
    private double amount;
    private String unit;

    // Constructors
    public Ingredient(String name, double amount, String unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    public Ingredient(String name, boolean onShoppingList, boolean required, boolean provided, String notes, String name1, double amount, String unit) {
        super(name, onShoppingList, required, provided, notes);
        this.name = name1;
        this.amount = amount;
        this.unit = unit;
    }

    public Ingredient() {}

    //Getter & Setters
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
