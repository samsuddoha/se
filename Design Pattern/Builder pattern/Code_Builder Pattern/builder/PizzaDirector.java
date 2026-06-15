// DIRECTOR - Defines the order of construction steps
public class PizzaDirector {
    private PizzaBuilder builder;   // Current builder being used
    // Constructor - attaches builder (as shown in diagram: d = new Director(b))
    public PizzaDirector(PizzaBuilder builder) {
        this.builder = builder;
    } 
    // Change builder at runtime (as shown in diagram: changeBuilder(builder))
    public void changeBuilder(PizzaBuilder builder) {
        this.builder = builder;
    }
    // Predefined configuration 1 - Margherita
    public void makeMargherita() {
        builder.reset();                    // Step 1: Reset
        builder.buildSize("Large");         // Step 2: Set size
        builder.buildCheese();              // Step 3: Add cheese
        builder.buildSauce("Tomato");       // Step 4: Add sauce
        System.out.println("Making Margherita Pizza");
    }
     // Predefined configuration 2 - Pepperoni
    public void makePepperoni() {
        builder.reset();                    // Step 1: Reset
        builder.buildSize("Medium");        // Step 2: Set size
        builder.buildCheese();              // Step 3: Add cheese
        builder.buildPepperoni();           // Step 4: Add pepperoni
        builder.buildSauce("BBQ");          // Step 5: Add sauce
        System.out.println("Making Pepperoni Pizza");
    }
    // Custom make method - like make(type) in diagram
    public void make(String type, String size, boolean cheese, boolean pepperoni, 
                     boolean mushroom, boolean olive, String sauce) {
        builder.reset();                    // Reset first
        builder.buildSize(size);            // Build size
        // Add toppings based on parameters
        if (cheese) builder.buildCheese();
        if (pepperoni) builder.buildPepperoni();
        if (mushroom) builder.buildMushroom();
        if (olive) builder.buildOlive();
        if (sauce != null) builder.buildSauce(sauce);
        
        System.out.println("Making " + type + " Pizza");
    } 
    // Get final product
    public Object getResult() {
        return builder.getResult();
    }
}