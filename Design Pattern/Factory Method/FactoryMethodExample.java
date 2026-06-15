abstract class Pizza {
    String name;

    void prepare() {
        System.out.println("Preparing " + name);
    }

    void bake() {
        System.out.println("Baking " + name + " at 400 degrees for 20 minutes");
    }

    void box() {
        System.out.println("Boxing " + name + " in official franchise box");
    }
}

// 2. Concrete Products

class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "NY Style Thin Crust Cheese Pizza";
    }
}

class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
    }

    
    @Override
    void box() {
        System.out.println("Boxing " + name + " in a special deep-dish box");
    }
}


abstract class Pizzeria {
    
    // THE FACTORY METHOD
    
    protected abstract Pizza createPizza();

    public Pizza orderPizza() {
        
        
        Pizza pizza = createPizza();

        System.out.println("--- Processing order for " + pizza.name + " ---");
        pizza.prepare();
        pizza.bake();
        pizza.box();

        return pizza;
    }
}

// 4. Concrete Creators

class NYPizzeria extends Pizzeria {
    @Override
    protected Pizza createPizza() {
        return new NYStyleCheesePizza();
    }
}

class ChicagoPizzeria extends Pizzeria {
    @Override
    protected Pizza createPizza() {
        return new ChicagoStyleCheesePizza();
    }
}

// --- Main Execution ---
public class FactoryMethodExample {
    public static void main(String[] args) {
        
        Pizzeria nyStore = new NYPizzeria();
        Pizzeria chicagoStore = new ChicagoPizzeria();

        
    
        Pizza pizza1 = nyStore.orderPizza();
        System.out.println("Customer 1 ordered a " + pizza1.name + "\n");

        
        
        Pizza pizza2 = chicagoStore.orderPizza();
        System.out.println("Customer 2 ordered a " + pizza2.name + "\n");
    }
}