package Winter2022.factory;

public class MailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("mail notification");
    }
}
