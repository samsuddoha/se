// BUILDER INTERFACE - Declares all construction steps
public interface PizzaBuilder {
    void reset();                    // Reset builder state
    void buildSize(String size);     // Build pizza size
    void buildCheese();              // Add cheese topping
    void buildPepperoni();           // Add pepperoni topping
    void buildMushroom();            // Add mushroom topping
    void buildOlive();               // Add olive topping
    void buildSauce(String sauce);   // Add sauce
    Object getResult();              // Return final product
}