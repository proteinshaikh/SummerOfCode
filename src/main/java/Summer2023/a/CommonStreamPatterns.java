package Summer2023.a;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class, CommonStreamPatterns, serves as a reference for commonly-used Java Stream API patterns.
 *
 * <p>It provides a collection of methods, each showcasing a different operation or transformation
 * typically performed with streams. Each method is documented with its purpose and expected usage.
 * This class can be used as a quick guide to understanding and applying various Stream operations
 * in real-world scenarios.</p>
 *
 * <p>From counting words to flattening lists, the class covers a wide range of stream-related tasks.</p>
 *
 * @author zeeshan shaikh
 * @version 1.0
 * @since 2023-08-18
 */
public class CommonStreamPatterns {

    /**
     * Counting Words in a sentence.
     *
     * @param sentence The input sentence.
     * @return A map with each word and its count.
     */
    public Map<String, Long> countWords(String sentence) {
        return Arrays.stream(sentence.toLowerCase().split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * Counting Characters in a string.
     *
     * @param string The input string.
     * @return A map with each character and its count.
     */
    public Map<Character, Long> countCharacters(String string) {
        return string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * Reversing a string.
     *
     * @param str The input string.
     * @return The reversed string.
     */
    public String reverseString(String str) {
        return IntStream.rangeClosed(1, str.length())
                .mapToObj(i -> str.charAt(str.length() - i))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    /**
     * Counting occurrences of an element in a map.
     *
     * @param maps The map to check.
     * @param a    The element to count.
     */
    public void countOccurrences(Map<Object, Integer> maps, Object a) {
        if (maps.containsKey(a)) {
            maps.put(a, maps.getOrDefault(a, 0) + 1);
        } else {
            maps.put(a, 1);
        }
    }

    /**
     * Finding unique elements in a list.
     *
     * @param list The input list.
     * @return A list of unique elements.
     */
    public List<String> uniqueElements(List<String> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    /**
     * Filtering non-empty elements from a list.
     *
     * @param list The input list.
     * @return A filtered list.
     */
    public List<String> filterNonEmpty(List<String> list) {
        return list.stream().filter(element -> !element.isEmpty()).collect(Collectors.toList());
    }

    /**
     * Squaring each element in a list.
     *
     * @param numbers The list of numbers.
     * @return A list with each element squared.
     */
    public List<Integer> squareElements(List<Integer> numbers) {
        return numbers.stream().map(n -> n * n).collect(Collectors.toList());
    }

    /**
     * Flattening a list of lists into a single list.
     *
     * @param listOfLists A list where each element is also a list of strings.
     * @return A flattened list of strings.
     */
    public List<String> flattenListOfLists(List<List<String>> listOfLists) {
        return listOfLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    /**
     * Finds and returns a map of duplicated elements and their occurrences in the given array.
     *
     * @param arr The input array of integers.
     * @return A map where the keys are the duplicated integers and the values are their counts.
     */
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
