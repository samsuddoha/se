public class Main {
    public static void main(String[] args) {
     // ---Create Subject
        YouTubeChannel channel = new YouTubeChannel();
        // -_______Create Observers
        Subscriber user1 = new Subscriber("ALice");
        Subscriber user2 = new Subscriber("Bob");
        Subscriber user3 = new Subscriber("Polycarp ");
        Subscriber user4 = new Subscriber("Monocarp");
        // _____________Subscribe observers
        channel.subscribe(user1);
        channel.subscribe(user2);
        channel.subscribe(user3);
        channel.subscribe(user4);
        // __________________Send notification
        channel.notifySubscribers("New Java Tutorial Uploaded!");
    }
}