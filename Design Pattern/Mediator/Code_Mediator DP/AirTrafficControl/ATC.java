class ATC {

    private boolean runwayFree = true;

    public void landingRequest(String planeName) {

        if (runwayFree) {
            runwayFree = false;
            System.out.println("ATC: " + planeName + " can LAND now.");
        } else {
            System.out.println("ATC: Runway busy. " + planeName + " cannot land.");
        }
    }

    public void takeoffRequest(String planeName) {

        if (runwayFree) {
            runwayFree = false;
            System.out.println("ATC: " + planeName + " can TAKE OFF now.");
        } else {
            System.out.println("ATC: Runway busy. " + planeName + " cannot take off.");
        }
    }

    public void runwayFree() {
        runwayFree = true;
        System.out.println("ATC: Runway is now free.");
    }
}
