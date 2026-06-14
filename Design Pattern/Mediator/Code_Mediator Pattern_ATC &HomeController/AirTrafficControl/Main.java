public class Main {
    public static void main(String[] args) {

        ATC atc = new ATC();

        Airplane planeA = new Airplane("Plane A", atc);
        Airplane planeB = new Airplane("Plane B", atc);

        planeA.requestLanding();
        planeB.requestTakeoff();
        planeA.finish();
        planeB.requestTakeoff();
    }
}
