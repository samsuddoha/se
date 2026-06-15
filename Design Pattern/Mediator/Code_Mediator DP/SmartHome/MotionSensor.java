class MotionSensor {

    String name;
    HomeController controller;

    MotionSensor(String name, HomeController controller) {
        this.name = name;
        this.controller = controller;
    }

    void detectMotion() {
        System.out.println(name + " detects motion.");
        controller.motionDetected(name);
    }
}
