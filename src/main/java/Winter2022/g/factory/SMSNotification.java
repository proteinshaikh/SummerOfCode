package Winter2022.g.factory;

public class SMSNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("sms noti");
    }
}
