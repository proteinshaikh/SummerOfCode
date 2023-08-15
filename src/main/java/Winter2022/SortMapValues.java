
package Winter2022;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class SortMapValues {
    public static void main(String[] args) {
        String str = "my name is zeeshan";

        char[] chars = str.toCharArray();
        List<char[]> charactersList = Arrays.asList(chars);
        List<char[]> res = charactersList.stream().distinct().collect(Collectors.toList());
    }

    Map<String, Integer> sortedByValue = new LinkedHashMap<>();

    static List sortByValue(Map<String, Integer> playerScores) {
        List<Map.Entry<String, Integer>> list = playerScores.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        return list;
    }
}

