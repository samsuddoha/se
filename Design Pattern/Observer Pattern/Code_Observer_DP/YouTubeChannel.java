import java.util.*;
public class YouTubeChannel {

    private List<Observer> subscribers = new ArrayList<>();
    // ------Add observer
    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }
    // __________Notify all observers
    public void notifySubscribers(String videoTitle) {

        for (Observer observer : subscribers) {
            observer.update(videoTitle);
        }
    }
}