package CoreJava;

import java.util.*;

public class Collections {
    public static void main(String[] a) {
        ArrayList<String> arrayList = new ArrayList<String>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        LinkedHashMap<Integer, String> linkedhashmap = new LinkedHashMap<Integer, String>();
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();


        //hashmap
        System.out.println("This is Hashmap");
        hashMap.put(1, "zeeshan");
        hashMap.put(2, "shaikh");
        hashMap.put(0, "");
        hashMap.put(1, "");
        for (Map.Entry<Integer, String> es : hashMap.entrySet()) {
            int key = es.getKey();
            String value = es.getValue();
            System.out.println(key + " : " + value);
        }
        //Linkedhashmap
        System.out.println("This is linkedHashmap");
        linkedhashmap.put(1, "zeeshan");
        linkedhashmap.put(2, "shaikh");
        linkedhashmap.put(0, "");
        linkedhashmap.put(1, "");

        for (Map.Entry<Integer, String> lhmap : linkedhashmap.entrySet()) {
            int key = lhmap.getKey();
            String value = lhmap.getValue();
            System.out.println(key + " : " + value);
        }
        //TreeMap
        System.out.println("This is TreeMap");
        treeMap.put(1, "zeeshan");
        treeMap.put(2, "shaikh");
        treeMap.put(0, "");
        treeMap.put(1, "");

        for (Map.Entry<Integer, String> tmap : treeMap.entrySet()) {
            int key = tmap.getKey();
            String value = tmap.getValue();
            System.out.println(key + " : " + value);
        }


    }

}
