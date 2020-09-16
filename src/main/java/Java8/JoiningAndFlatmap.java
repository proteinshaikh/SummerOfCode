package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningAndFlatmap {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("Spring", "Spring Boot", "Docker", "Zuul");

        System.out.println(str.stream().collect(Collectors.joining(" ")));

        /* Output
         * Spring Spring Boot Docker Zuul
         * */
        System.out.println(str.stream().collect(Collectors.joining(",")));
        /*
         * Spring,Spring Boot,Docker,Zuul
         * */
        //flatmap
        System.out.println(str.stream().map(st -> st.split("")).flatMap(Arrays::stream)
                .distinct().collect(Collectors.toList()));
        /*
         * [S, p, r, i, n, g,  , B, o, t, D, c, k, e, Z, u, l]
         * */

        //Combine 2 Lists
        List<String> str2 = Arrays.asList("Spring", "Spring Boot", "Docker", "Zuul");
        System.out.println(str.stream().flatMap(st -> str2.stream().map(st2 -> Arrays.asList(st, str2)))
                .collect(Collectors.toList()));

        //Combine 2 Lists with filter
        System.out.println(str.stream().flatMap(st -> str2.stream().map(st2 -> Arrays.asList(st, str2)))
                .filter(list -> !list.get(0).equals(list.get(1)))
                .collect(Collectors.toList()));


    }
}
