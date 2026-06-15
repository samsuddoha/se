
        
        // Using different builder (ConcreteBuilder2)
        // Client can change builder at runtime
        VegPizzaBuilder builder2 = new VegPizzaBuilder();
        director.changeBuilder(builder2);
        director.makePepperoni();
        VegPizza pizza2 = (VegPizza) director.getResult();
        pizza2.show();
        
        System.out.println("\n========== PROBLEM SOLVED! ==========");
        System.out.println("✓ Only ONE constructor needed!");
        System.out.println("✓ No constructor explosion!");
        System.out.println("✓ Director controls construction order");
        System.out.println("✓ Different builders = different products");
        System.out.println("✓ Code follows the Builder Pattern structure");
    }
}