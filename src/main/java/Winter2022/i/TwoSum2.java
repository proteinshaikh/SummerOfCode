package Winter2022.i;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TwoSum2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};

        for(int a: Objects.requireNonNull(getIndex(arr))){
            System.out.printf(String.valueOf(a));
        }
        System.out.print("");
    }


    static int[] getIndex(int[] arr){
        Map <Integer, Integer> map = new HashMap<>();


        for(int i=0; i< arr.length; i++){
            int complement = 7 - arr[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i );
        }
        return null;
    }

}
