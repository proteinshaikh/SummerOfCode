package Winter2022.g;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DeleteHashMapEntries {
    public static void main(String[] args) {
        deleteEntryInHashMap();

    }

    static void deleteEntryInHashMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("zee", 1);
        map.put("sh", 2);
        map.put("ak", 3);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
            if (entry.getValue() == 2) {
                map.remove(entry.getKey());// this will throw ConcurrentModificationException
            }
        }
    }

    static Object deleteEntrySafe() {
        Map<String, Integer> map = new HashMap<>();
        map.put("zee", 1);
        map.put("sh", 2);
        map.put("ak", 3);

        Iterator<Map.Entry<String, Integer>> itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            if (entry.getValue() == 2) {
                itr.remove(); //safely delete entry
            }
        }
        return null;
    }
}




