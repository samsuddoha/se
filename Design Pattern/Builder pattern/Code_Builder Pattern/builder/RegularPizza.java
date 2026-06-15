// PRODUCT 1 - Regular Pizza (First product type)
public class RegularPizza {
    // Private fields
    private String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushroom;
    private boolean olive;
    private String sauce;
    
    // Setter methods
    public void setSize(String size) { this.size = size; }
    public void setCheese(boolean cheese) { this.cheese = cheese; }
    public void setPepperoni(boolean pepperoni) { this.pepperoni = pepperoni; }
    public void setMushroom(boolean mushroom) { this.mushroom = mushroom; }
    public void setOlive(boolean olive) { this.olive = olive; }
    public void setSauce(String sauce) { this.sauce = sauce; }
    
    // Display product details
    public void show() {
        System.out.println("Regular Pizza: " + size + 
                         ", Cheese:" + cheese + 
                         ", Pepperoni:" + pepperoni +
                         ", Mushroom:" + mushroom +
                         ", Olive:" + olive +
                         ", Sauce:" + sauce);
    }
}