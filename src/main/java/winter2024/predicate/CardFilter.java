package winter2024.predicate;

import lombok.Getter;

import java.util.List;
import java.util.function.Predicate;

public class CardFilter {

    public static <T> List<T> filterData(Predicate<T> condition, List<T> items) {
        return items.stream().filter(condition).toList();
    }

    public static void main(String[] args) {
        List<Card> cards = List.of(
                new Card("01-01-2023"),
                new Card("01-01-2024")
        );

        Predicate<Card> isTransactionBefore2025 = card -> card.getTransactionDate().compareTo("01-01-2025") < 0;

        List<Card> filteredCards = filterData(isTransactionBefore2025, cards);

        filteredCards.forEach(card -> System.out.println("Transaction Date: " + card.getTransactionDate()));
    }

    @Getter
    static class Card {
        private final String transactionDate;

        public Card(String transactionDate) {
            this.transactionDate = transactionDate;
        }
    }
}

