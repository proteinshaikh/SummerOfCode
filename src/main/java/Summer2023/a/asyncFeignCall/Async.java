package Summer2023.a.asyncFeignCall;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Async {

    public void setfClient(FClient fClient) {
        this.fClient = fClient;
    }

    @Autowired
    private FClient fClient;

    public void execute() {

        Executor executor = Executors.newFixedThreadPool(2);

        CompletableFuture<Card> cardCompletableFuture = CompletableFuture.supplyAsync(fClient::getCard, executor);
        CompletableFuture<Account> accountCompletableFuture = CompletableFuture.supplyAsync(fClient::getAccount, executor);

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(cardCompletableFuture, accountCompletableFuture);
        completableFuture.thenRun(() -> {
                    Card card = cardCompletableFuture.join();
                    Account account = accountCompletableFuture.join();


                }
        );
    }
}
