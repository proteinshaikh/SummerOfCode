package Winter2022.comparator4;


import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestMinisterComparator {
    public static void main(String[] args) throws HttpClientErrorException.NotFound {
        List<Minister> ministers = new ArrayList<>();

        ministers.add(new Minister(1, "zee"));
        ministers.add(new Minister(2, "zee"));
        ministers.add(new Minister(3, "zee"));

        Collections.sort(ministers, new NameComparator());

        for (Minister minister : ministers) {
            System.out.println(minister.getId() + minister.getName());
        }
        System.out.println("using streams");
        //comparator using streams
        List<Minister> getMinisters = ministers.stream().sorted(Comparator.comparingInt(Minister::getId)).collect(Collectors.toList());
        for (Minister minister : getMinisters) {
            System.out.println(minister.getId() + minister.getName());
        }
        System.out.println("max id");
        //find max id
        System.out.println(ministers.stream().mapToInt(x -> x.getId()).max().orElseThrow(NoClassDefFoundError::new));


    }
}
