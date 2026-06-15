//Constructor Explosion Problem
class Pizza {
    String size;
    boolean cheese;
    boolean pepperoni;
    boolean mushroom;
    boolean olive;
    String sauce;

    // Constructor 1
    Pizza(String size) {
        this(size, false, false, false, false, null);
    }

    // Constructor 2
    Pizza(String size, boolean cheese) {
        this(size, cheese, false, false, false, null);
    }

    // Constructor 3
    Pizza(String size, boolean cheese, boolean pepperoni) {
        this(size, cheese, pepperoni, false, false, null);
    }

    // Constructor 4
    Pizza(String size, boolean cheese, boolean pepperoni, boolean mushroom) {
        this(size, cheese, pepperoni, mushroom, false, null);
    }

    // Constructor 5
    Pizza(String size, boolean cheese, boolean pepperoni, boolean mushroom, boolean olive) {
        this(size, cheese, pepperoni, mushroom, olive, null);
    }

    // Main Constructor (Very Ugly!)
    Pizza(String size, boolean cheese, boolean pepperoni, boolean mushroom, boolean olive, String sauce) {
        this.size = size;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.mushroom = mushroom;
        this.olive = olive;
        this.sauce = sauce;
    }

   void show() {
    System.out.println("Pizza: " + size);           
    System.out.println("Cheese: " + cheese);        
    System.out.println("Pepperoni: " + pepperoni);  
    System.out.println("Mushroom: " + mushroom);    
    System.out.println("Olive: " + olive);          
    System.out.println("Sauce: " + sauce+ "\n");          
}
}

public class Problem1 {
    public static void main(String[] args) {

         System.out.println("First pizza!!");
        // Want only cheese and pepperoni, but must pass all parameters
        Pizza p1 = new Pizza("Large", true, true, false, false, null);
        p1.show();
        System.out.println("Second pizza!!");
        // What is true? cheese? pepperoni? No one knows!
        Pizza p2 = new Pizza("Medium", true, false, true, false, "Tomato");
        p2.show();

    }
}