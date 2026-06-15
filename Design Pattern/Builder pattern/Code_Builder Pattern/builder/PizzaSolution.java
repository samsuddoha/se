// CLIENT - Attaches builder to director (as shown in diagram)
public class PizzaSolution {
    public static void main(String[] args) {
        System.out.println("=== BUILDER PATTERN - CONSTRUCTOR EXPLOSION SOLVED ===\n");
        

        // Client creates concrete builder
        RegularPizzaBuilder builder1 = new RegularPizzaBuilder();
        
       
        // Client attaches builder to director via constructor
        PizzaDirector director = new PizzaDirector(builder1);
        
       
        // Director constructs the product
        director.makeMargherita();
        
        
        // Client gets result from builder
        RegularPizza pizza1 = (RegularPizza) director.getResult();
        pizza1.show();
        
        System.out.println();
        
        
        // Client can change builder at runtime
        VegPizzaBuilder builder2 = new VegPizzaBuilder();
        director.changeBuilder(builder2);
        director.makePepperoni();
        VegPizza pizza2 = (VegPizza) director.getResult();
        pizza2.show();
        
        System.out.println("\n========== PROBLEM SOLVED! ==========");
        System.out.println(" Only ONE constructor needed!");
        System.out.println(" No constructor explosion!");
        System.out.println(" Director controls construction order");
        System.out.println(" Different builders = different products");
        System.out.println(" Code follows the Builder Pattern structure");
    }
}

