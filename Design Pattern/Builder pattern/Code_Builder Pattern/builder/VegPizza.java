// PRODUCT 2 - Veg Pizza (Different product, different hierarchy)
public class VegPizza {
    // Private fields (no pepperoni - different from RegularPizza)
    private String size;
    private boolean cheese;
    private boolean mushroom;
    private boolean olive;
    private String sauce;
    
    // Setter methods
    public void setSize(String size) { this.size = size; }
    public void setCheese(boolean cheese) { this.cheese = cheese; }
    public void setMushroom(boolean mushroom) { this.mushroom = mushroom; }
    public void setOlive(boolean olive) { this.olive = olive; }
    public void setSauce(String sauce) { this.sauce = sauce; }
    
    // Display product details
    public void show() {
        System.out.println("Veg Pizza: " + size + 
                         ", Cheese:" + cheese + 
                         ", Mushroom:" + mushroom +
                         ", Olive:" + olive +
                         ", Sauce:" + sauce);
    }
}