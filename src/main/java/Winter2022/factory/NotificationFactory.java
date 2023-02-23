package Winter2022.factory;

public class NotificationFactory {

    public Notification createNotification(String str) {
        if (str == null || str.isEmpty())
            return null;
        switch (str) {
            case "SMS":
                return new SMSNotification();
            case "MAIL":
                return new MailNotification();
            case "PUSH":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("unknown channel " + str);
        }

    }
}
