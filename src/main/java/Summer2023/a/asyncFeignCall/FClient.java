package Summer2023.a.asyncFeignCall;

import lombok.Builder;
import lombok.Data;

public interface FClient {

    Card getCard();

    Account getAccount();
}

@Builder
@Data
class Card {
    private String cardNumber;
    private String cardName;
}

@Builder
@Data
class Account {
    private String AccountNumber;
    private String accountName;
}

