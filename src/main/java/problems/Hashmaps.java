package problems;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Hashmaps {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("key1", "some value");
        hashMap.put("key4", "some value");
        hashMap.put("key3", "some value");
        hashMap.put("key2", "some value");
        Set set = hashMap.keySet();
        set = new TreeSet(set);
        System.out.println(set);
    }
}
