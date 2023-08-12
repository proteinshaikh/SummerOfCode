package Winter2022.i;

import java.util.HashMap;
import java.util.Map;

public class MostCommonElement {
    public static void main(String[] args) {
        
    }
    
    Object getMostCommonElement(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int a: arr){
            if(map.containsKey(a)){
                map.put(a, map.getOrDefault(a, 0)+ 1);
            }
        }
        return null;
        
    }
}
