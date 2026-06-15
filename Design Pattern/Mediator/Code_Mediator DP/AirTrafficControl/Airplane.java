class Airplane {

    String name;
    ATC atc;

    Airplane(String name, ATC atc) {
        this.name = name;
        this.atc = atc;
    }

    void requestLanding() {
        System.out.println(name + " wants to LAND");
        atc.landingRequest(name);
    }

    void requestTakeoff() {
        System.out.println(name + " wants to TAKE OFF");
        atc.takeoffRequest(name);
    }

    void finish() {
        atc.runwayFree();
    }
}
