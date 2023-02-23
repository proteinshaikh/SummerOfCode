package Winter2022;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filters {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        getEvenNos(list);
        for(Integer integer:getEvenNos(list)){
            System.out.println(integer);
        }
    }


    static List<Integer> getEvenNos(List<Integer> integers) {
        return integers.stream().filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

    }

}
