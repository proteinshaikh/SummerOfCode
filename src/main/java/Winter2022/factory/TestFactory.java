package Winter2022.factory;

public class TestFactory {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification("SMS");
        notification.notifyUser();
        Notification notification1 = notificationFactory.createNotification("PUSH");
        notification1.notifyUser();
    }
}
