package CoreJava.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IterateMap {
    public static void main(String[] args) {
        Map<Integer, String> bookMap = new HashMap<>();
        bookMap.put(1, "a thousand splendid suns");
        bookMap.put(2, "and the mountains echoed");
        bookMap.put(3, "half the night is gone");
        bookMap.put(4, "beef");
        bookMap.put(5, "incredible india");

        Iterator<Map.Entry<Integer, String>> itr = bookMap.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry<Integer, String> iterateBooks = itr.next();
            System.out.println("BookNum = " + iterateBooks.getKey() + "  " + "Book name = " + iterateBooks.getValue());

        }

        System.out.println("\n\n");
        System.out.println("using java 8 : \n");
        bookMap.forEach((k, v) -> System.out.println("BookNum = " + k + "  " + "Book name = " + v));
    }
}
