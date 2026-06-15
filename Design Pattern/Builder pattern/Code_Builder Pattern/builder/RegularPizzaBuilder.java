// CONCRETE BUILDER 1 - Builds Regular Pizza
public class RegularPizzaBuilder implements PizzaBuilder {
    private RegularPizza result;    // Holds the product being built
    // Constructor - initializes builder
    public RegularPizzaBuilder() {
        reset();
    } 
    @Override
    public void reset() {
        this.result = new RegularPizza();   // Create new product
    }
    @Override
    public void buildSize(String size) {
        result.setSize(size);
    }
    @Override
    public void buildCheese() {
        result.setCheese(true);
    }
    @Override
    public void buildPepperoni() {
        result.setPepperoni(true);
    }
    @Override
    public void buildMushroom() {
        result.setMushroom(true);
    }
    @Override
    public void buildOlive() {
        result.setOlive(true);
    } 
    @Override
    public void buildSauce(String sauce) {
        result.setSauce(sauce);
    }
    @Override
    public Object getResult() {
        return result;      // Return final product
    }
}