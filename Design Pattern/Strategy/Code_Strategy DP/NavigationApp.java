import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// ─── Strategy Interface ───────────────────────────────────────────────────────

interface RouteStrategy {
    List<String> buildRoute(String origin, String destination);
}

// ─── Concrete Strategies ──────────────────────────────────────────────────────

class CarRouteStrategy implements RouteStrategy {
    public List<String> buildRoute(String origin, String destination) {
        System.out.println("  [Car]     Building fastest road route...");
        return Arrays.asList(origin, "Express Highway", "City Flyover", destination);
    }
}

class WalkingRouteStrategy implements RouteStrategy {
    public List<String> buildRoute(String origin, String destination) {
        System.out.println("  [Walking] Building pedestrian-friendly route...");
        return Arrays.asList(origin, "Central Park", "River Walk", destination);
    }
}

class PublicTransitRouteStrategy implements RouteStrategy {
    public List<String> buildRoute(String origin, String destination) {
        System.out.println("  [Transit] Building public transport route...");
        return Arrays.asList(origin, "Bus Stop", "Metro Station", destination);
    }
}

class CyclingRouteStrategy implements RouteStrategy {
    public List<String> buildRoute(String origin, String destination) {
        System.out.println("  [Cycling] Building bike-friendly route...");
        return Arrays.asList(origin, "Cycle Track", "Green Lane", destination);
    }
}

class TouristRouteStrategy implements RouteStrategy {
    public List<String> buildRoute(String origin, String destination) {
        System.out.println("  [Tourist] Building scenic route...");
        return Arrays.asList(origin, "City Museum", "Historic Bridge", "View Point", destination);
    }
}

// ─── Context ──────────────────────────────────────────────────────────────────

class Navigator {

    private RouteStrategy strategy;

    public Navigator(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void navigate(String origin, String destination) {
        System.out.println("\n  From : " + origin);
        System.out.println("  To   : " + destination);
        List<String> route = strategy.buildRoute(origin, destination);
        System.out.println("  Route: " + String.join(" -> ", route));
        System.out.println("  " + "-".repeat(50));
    }
}



public class NavigationApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] places = {
            "Hotel Central",
            "Airport",
            "University",
            "City Mall"
        };

        System.out.println("=".repeat(55));
        System.out.println("        NAVIGATOR APP - Strategy Pattern");
        System.out.println("=".repeat(55));

        System.out.println("\nChoose Starting Point:");
        for (int i = 0; i < places.length; i++) {
            System.out.println((i + 1) + ". " + places[i]);
        }
        System.out.print("\nEnter choice: ");
        int start = input.nextInt();

        System.out.println("\nChoose Destination:");
        for (int i = 0; i < places.length; i++) {
            System.out.println((i + 1) + ". " + places[i]);
        }
        System.out.print("\nEnter choice: ");
        int end = input.nextInt();

        String from = places[start - 1];
        String to   = places[end - 1];

        System.out.println("\nChoose Travel Mode:");
        System.out.println("1. Car       - fastest road route");
        System.out.println("2. Walking   - pedestrian-friendly");
        System.out.println("3. Transit   - public transport");
        System.out.println("4. Cycling   - bike-friendly");
        System.out.println("5. Tourist   - scenic route");
        System.out.print("\nEnter choice: ");
        int modeChoice = input.nextInt();

        RouteStrategy strategy;
        switch (modeChoice) {
            case 1: strategy = new CarRouteStrategy();          break;
            case 2: strategy = new WalkingRouteStrategy();      break;
            case 3: strategy = new PublicTransitRouteStrategy(); break;
            case 4: strategy = new CyclingRouteStrategy();      break;
            case 5: strategy = new TouristRouteStrategy();      break;
            default:
                System.out.println("Invalid choice. Defaulting to Car.");
                strategy = new CarRouteStrategy();
        }

        // ── Navigate ──
        Navigator navigator = new Navigator(strategy);

        System.out.println("=".repeat(55));
        navigator.navigate(from, to);
        System.out.println("=".repeat(55));

        input.close();
    }
}