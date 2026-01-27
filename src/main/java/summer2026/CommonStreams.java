package summer2026;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CommonStreams {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 2, 3, 4, 4, 5, 5, 5};
    Map<Integer, Long> duplicates = getDuplicates(arr);
    System.out.println(duplicates); // Output: {2=2, 3=2, 4=3, 5=4}
  }

  static Map<Integer, Long> getDuplicates(int[] arr) {
    return Arrays.stream(arr)
        .boxed()
        .collect((Collectors.groupingBy(Function.identity(), Collectors.counting())))
        .entrySet()
        .stream()
        .filter(e -> e.getValue() > 1)
        .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
  }
}
