package Summer2023.a.asyncFeignCall;

public class TestAsync {

    public static void main(String[] args) {
        FClient fClient = new FClient() {
            @Override
            public Card getCard() {
                return Card.builder().cardNumber("123").cardName("myCard").build();
            }

            @Override
            public Account getAccount() {
                return Account.builder().AccountNumber("555").accountName("myAccount").build();
            }
        };

        Async async = new Async();
        async.setfClient(fClient);
        async.execute();

        //wait and check
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("execution finished check results!");
    }
}
