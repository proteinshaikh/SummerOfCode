package winter2024;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CommonStreams {

    public static void main(String[] args) {
        // Example usage of each method for testing and demonstration purposes

        // 1. Count words in a sentence
        System.out.println("Word Count: " + new CommonStreams().countWords("Hello world hello"));

        // 2. Count characters in a string
        System.out.println("Character Count: " + new CommonStreams().countCharacters("Hello"));

        // 3. Reverse a string
        System.out.println("Reversed String: " + new CommonStreams().reverseString("Hello"));

        // 4. Count occurrences of an element in a map
        Map<Object, Integer> map = Map.ofEntries(Map.entry("apple", 1), Map.entry("banana", 2));
        System.out.println("Count Occurrences in Map: " + map);

        // 5. Find unique elements in a list
        System.out.println("Unique Elements: " + new CommonStreams().uniqueElements(Arrays.asList("apple", "banana", "apple")));

        // 6. Filter non-empty elements from a list
        System.out.println("Filtered Non-Empty: " + new CommonStreams().filterNonEmpty(Arrays.asList("apple", "", "banana")));

        // 7. Square each element in a list
        System.out.println("Squared Elements: " + new CommonStreams().squareElements(Arrays.asList(1, 2, 3, 4)));

        // 8. Flatten a list of lists into a single list
        List<List<String>> listOfLists = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("c", "d"));
        System.out.println("Flattened List: " + new CommonStreams().flattenListOfLists(listOfLists));

        // 9. Find and return duplicates in an array
        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        System.out.println("Duplicates in Array: " + CommonStreams.findDuplicates(arr));
    }

    public Map<String, Long> countWords(String sentence) {
        return Arrays.stream(sentence.toLowerCase().split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Map<Character, Long> countCharacters(String string) {
        return string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public String reverseString(String str) {
        return IntStream.rangeClosed(1, str.length())
                .mapToObj(i -> str.charAt(str.length() - i))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public void countOccurrences(Map<Object, Integer> maps, Object a) {
        if (maps.containsKey(a)) {
            maps.put(a, maps.getOrDefault(a, 0) + 1);
        } else {
            maps.put(a, 1);
        }
    }

    public List<String> uniqueElements(List<String> list) {
        return list.stream().distinct().toList();
    }

    public List<String> filterNonEmpty(List<String> list) {
        return list.stream().filter(element -> !element.isEmpty()).toList();
    }

    public List<Integer> squareElements(List<Integer> numbers) {
        return numbers.stream().map(n -> n * n).toList();
    }

    public List<String> flattenListOfLists(List<List<String>> listOfLists) {
        return listOfLists.stream()
                .flatMap(Collection::stream)
                .toList();
    }

    public static Map<Integer, Long> findDuplicates(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}

