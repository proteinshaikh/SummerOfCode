package winter2024;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AsyncFeignExample {

    public static void main(String[] args) {
        // Mock implementation of FClient
        FClient fClient = new FClientImpl();

        AsyncService asyncService = new AsyncService();
        asyncService.setFClient(fClient);
        asyncService.execute();

        // Wait for the asynchronous execution to complete
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Execution finished! Check results.");
    }
}

// The AsyncService class handles the asynchronous execution
class AsyncService {

    @Autowired
    private FClient fClient;

    public void setFClient(FClient fClient) {
        this.fClient = fClient;
    }

    public void execute() {
        Executor executor = Executors.newFixedThreadPool(2);

        CompletableFuture<Card> cardCompletableFuture = CompletableFuture.supplyAsync(fClient::getCard, executor);
        CompletableFuture<Account> accountCompletableFuture = CompletableFuture.supplyAsync(fClient::getAccount, executor);

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(cardCompletableFuture, accountCompletableFuture);
        completableFuture.thenRun(() -> {
            Card card = cardCompletableFuture.join();
            Account account = accountCompletableFuture.join();

            // Process the card and account objects
            System.out.println("Card: " + card);
            System.out.println("Account: " + account);
        });
    }
}

// The FClient interface representing the client
interface FClient {
    Card getCard();
    Account getAccount();
}

// Implementation of the FClient interface
class FClientImpl implements FClient {
    @Override
    public Card getCard() {
        return Card.builder().cardNumber("123").cardName("myCard").build();
    }

    @Override
    public Account getAccount() {
        return Account.builder().AccountNumber("555").accountName("myAccount").build();
    }
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

