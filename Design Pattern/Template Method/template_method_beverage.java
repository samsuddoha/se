// 1. The Abstract Class defining the Template Method
abstract class CaffeineBeverage {

    // THE TEMPLATE METHOD
    // Declared as 'final' so subclasses cannot override and change the recipe's core sequence
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Common methods shared by all subclasses
    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Abstract methods that subclasses MUST implement themselves
    abstract void brew();
    abstract void addCondiments();
}

// 2. Concrete Class for Tea
class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Steeping the tea leaves");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding a slice of lemon");
    }
}

// 3. Concrete Class for Coffee
class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Dripping coffee through the filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

// --- Main Execution ---
public class TemplateMethodExample {
    public static void main(String[] args) {
        CaffeineBeverage myTea = new Tea();
        CaffeineBeverage myCoffee = new Coffee();

        System.out.println("--- Making Tea ---");
        // We call the template method, which executes the predefined sequence
        myTea.prepareRecipe();

        System.out.println("\n--- Making Coffee ---");
        // The core sequence is the same, but the specific brew/condiment steps change
        myCoffee.prepareRecipe();
    }
}