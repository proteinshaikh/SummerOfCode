package Summer2023.a.asyncFeignCall;

public class FClientImpl implements FClient {
    @Override
    public Card getCard() {
        return Card.builder().cardNumber("123").cardName("myCard").build();
    }

    @Override
    public Account getAccount() {
        return Account.builder().AccountNumber("555").accountName("myAccount").build();
    }
}
