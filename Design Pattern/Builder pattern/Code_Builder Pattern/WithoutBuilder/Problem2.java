//Readability Problems
class Laptop {
    String cpu;
    int ram;
    int storage;
    boolean hasSSD;
    boolean hasGraphicsCard;
    String color;

    // Constructor with many parameters
    Laptop(String cpu, int ram, int storage, boolean hasSSD, boolean hasGraphicsCard, String color) {
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.hasSSD = hasSSD;
        this.hasGraphicsCard = hasGraphicsCard;
        this.color = color;
    }

    void show() {
        System.out.println("Laptop: " + cpu + ", " + ram + "GB, " + storage + "GB, SSD:" + hasSSD);
    }
}

public class Problem2 {
    public static void main(String[] args) {

        // Difficult to understand the meaning of each parameter
        Laptop l1 = new Laptop(16,"i7" , 512, true, false, "Black");

        // true/false values are confusing and parameter order is hard to remember
        Laptop l2 = new Laptop("i5", 8, 256, false, true, "Silver");
        //Laptop l3 = new Laptop(8,"i5", 256, false, true, "Silver");

        l1.show();
        l2.show();
    }
}
