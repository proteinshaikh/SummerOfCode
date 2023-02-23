package Winter2022;

import java.util.HashMap;
import java.util.Map;

public class IterateHashMap {
    public static void main(String[] args) {
        getNames();
    }

    static void getNames(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "zee");
        map.put(2, "zee");
        map.put(3, "zee");

        for(Map.Entry<Integer, String> itrMap: map.entrySet()){
            System.out.println(itrMap.getKey()+itrMap.getValue());
        }
    }
}
