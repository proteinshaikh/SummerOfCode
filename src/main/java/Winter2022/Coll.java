package Winter2022;

import java.util.HashMap;
import java.util.Map;

public class Coll {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "zee");
        map.put(2, "zee");
        map.put(3, "zee");
        map.put(null, "test");
        map.put(null, "zee"); map.put(03, "jhgjh");


        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }
}
