package Summer2023.a;

import java.util.List;
import java.util.function.Predicate;

public class MyPredicate {

    public static <T> List<T> getData(Predicate<T> predicate, List<T> list) {
        return list.stream().filter(predicate).toList();
    }

    public static void main(String[] args) {
        class Card {
            private final String dateOfTx;

            public Card(String dateOfTx) {
                this.dateOfTx = dateOfTx;
            }

            public String getDateOfTx() {
                return this.dateOfTx;
            }
        }
        List<Card> al = List.of(new Card("01-01-2023"), new Card("01-01-2024"));

        Predicate<Card> predicate = x -> x.getDateOfTx().compareTo("01-01-2025") > 0;
        List<Card> result = getData(predicate, al);
        result.forEach(card -> System.out.println(card.getDateOfTx()));
    }
}
