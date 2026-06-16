import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

class TreeType {
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.println(
            "Drawing " + name +
            " tree at (" + x + ", " + y + ")" +
            " Color: " + color +
            ", Texture: " + texture
        );
    }
}

class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}



class TreeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(
            String name,
            String color,
            String texture) {

        String key = name + "-" + color + "-" + texture;

        if (!treeTypes.containsKey(key)) {
            treeTypes.put(
                key,
                new TreeType(name, color, texture)
            );
            System.out.println("Creating TreeType: " + key);
        }

        return treeTypes.get(key);
    }

    public static int getTreeTypeCount() {
        return treeTypes.size();
    }
}



class Forest {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(
            int x,
            int y,
            String name,
            String color,
            String texture) {

        TreeType type =
            TreeFactory.getTreeType(name, color, texture);

        trees.add(new Tree(x, y, type));
    }

    public void draw() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }
}

public class FlyweightForestDemo {
    public static void main(String[] args) {

        Forest forest = new Forest();

        // Plant many trees
        for (int i = 0; i < 1000000; i++) {
            forest.plantTree(
                i,
                i + 10,
                "Oak",
                "Green",
                "OakTexture.png"
            );
        }

        for (int i = 0; i < 1000000; i++) {
            forest.plantTree(
                i,
                i + 20,
                "Pine",
                "Dark Green",
                "PineTexture.png"
            );
        }

        System.out.println(
            "\nNumber of TreeType objects created: "
            + TreeFactory.getTreeTypeCount()
        );
    }
}