package Summer2023.a;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Coforge {

    /*
    * int a[]= {1,2,4,4,2,5};
2=2
4=2
    * */

    public static void main(String[] args) {
        Coforge.getDuplicateOccurrencesStreams(new int[]{1, 2, 4, 4, 2, 5});
        Coforge.getDuplicateOccurrencesOfStringsUsingStream();

    }

    static void getDuplicateOccurrencesStreams(int[] arr) {
        Map<Integer, Long> map = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        map.forEach((k, v) -> System.out.println(k + " = " + v));
    }


    static void getDuplicateOccurrencesOfStringsUsingStream() {
        System.out.println("string array");
        String[] strings = new String[]{"zeeshan", "akram", "shaikh", "zeeshan"};

      Arrays.stream(strings)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getKey().equals("zeeshan"))
                .filter(x -> x.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((k, v) -> System.out.println(k + " = " + v));

        List<String> stringList = Arrays.asList("test", "akram", "shaikh", "test", "shaikh", "test");

        System.out.println("list of strings");

        stringList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((k, v) -> System.out.println(k + " = " + v));

    }

}
