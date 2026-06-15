// CONCRETE BUILDER 2 - Builds Veg Pizza (Different product)
public class VegPizzaBuilder implements PizzaBuilder {
    private VegPizza result;    // Holds different product type
    // Constructor - initializes builder
    public VegPizzaBuilder() {
        reset();
    } 
    @Override
    public void reset() {
        this.result = new VegPizza();   // Create new veg pizza
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
        // PROBLEM: Veg pizza cannot have pepperoni
        System.out.println("No pepperoni for Veg Pizza");
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
        return result;      // Return different product type
    }
}