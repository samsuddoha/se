class HomeController {

    Light light;
    Alarm alarm;
    Notification notification;

    HomeController(Light light, Alarm alarm, Notification notification) {
        this.light = light;
        this.alarm = alarm;
        this.notification = notification;
    }

    public void motionDetected(String sensorName) {

        System.out.println(sensorName + " detected motion.");

        light.turnOn();
        alarm.start();
        notification.send();
    }
}
