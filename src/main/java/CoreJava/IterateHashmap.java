package CoreJava;

import java.util.HashMap;
import java.util.Map;

public class IterateHashmap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        try {
            map.put(1, "Zeeshan");
            map.put(2, "Zeeshan");
            map.put(3, "Zeeshan");
            map.put(4, "Zeeshan");
            map.put(5, "Zeeshan");
            map.put(null, "Zeeshan");
            map.put(null, "Zeeshan");
        } catch (Exception e) {
            System.out.println("Exception while adding key values in hashmap " + e);
        }

        //iterate over keys
        try {
            for (Integer integer : map.keySet()) {
                int key = integer;
                System.out.println(key);
            }
        } catch (Exception e) {
            System.out.println("Exception initerate over keys " + e);
        }

        //iterate over values
        try {
            for (String val : map.values()) {
                System.out.println(val);
            }
        } catch (Exception e) {
            System.out.println("Exception initerate over values " + e);
        }

        //Iterate over hashmap
        try {
            for (Map.Entry<Integer, String> maps : map.entrySet()) {
                int key = maps.getKey();
                String value = maps.getValue();
                System.out.println(key + " : " + value);
            }
        } catch (Exception e) {
            System.out.println("Exception initerate over hashmap " + e);
        }

        for (Map.Entry<Integer, String> maps : map.entrySet()) {
            int key = maps.getKey();
            String value = maps.getValue();
            System.out.println(key + " " + value);
        }

    }
}
