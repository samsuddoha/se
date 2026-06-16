public class Demo {
    public static void main(String[] args) {
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        
        if (osName.contains("win")) {
            factory = new WinFactory();
        } else {
            factory = new MacFactory();
        }
        
        Application app = new Application(factory);
        app.paint();
    }
}