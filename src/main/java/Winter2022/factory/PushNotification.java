package Winter2022.factory;

public class PushNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("push Notification");
    }
}
