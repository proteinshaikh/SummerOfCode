package Winter2022.g.factory;


public class NotificationFactory {

    public Notification createNotification(String str) {
        if (str == null || str.isEmpty()) return null;
        switch (str) {
            case "SMS":
                return new SMSNotification();
            case "mail":
                return new MailNotification();
            default:
                throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification("SMS");
        notification.notifyUser();

    }

}
