package Winter2022.g.factory;

public class MailNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("mail noti");
    }
}
