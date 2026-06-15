public class Main {
    public static void main(String[] args) {

        Light light = new Light();
        Alarm alarm = new Alarm();
        Notification notification = new Notification();

        HomeController controller = new HomeController(light, alarm, notification);

        MotionSensor sensor = new MotionSensor("Motion Sensor", controller);

        sensor.detectMotion();
    }
}
