package Winter2022;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Maps8 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "test");
        map.put(2, "zee");
        map.put(3, "sdsd");
        map.put(4, "tesdsdst");
        System.out.println(getMaps(map));
        iterateMap(map);
        iterateMapUsingStreams(map);

    }

    static Optional getMaps(Map<Integer, String> map) {
        return map.entrySet().stream().filter(x -> 1 == x.getKey())
                .map(Map.Entry::getKey)
                .findFirst();


    }

    //using java 7
    static void iterateMap(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> maps : map.entrySet()) {
            System.out.println(maps.getKey() + " : " + maps.getValue());
        }
    }

    //using java 8
    static void iterateMapUsingStreams(Map<Integer, String> maps) {
        maps.entrySet().stream().filter(x -> x.getKey().equals(4))
                .forEach(System.out::println);

    }
}
