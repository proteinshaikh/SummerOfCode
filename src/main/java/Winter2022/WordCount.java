package Winter2022;
/*
* Write a program that counts the duplicate words in a string and store count in Map. Sort the map by
* ValuesString str = "Hello World, Hello Welcome to EPAM";
OP = Hello - 2, World -1 , Welcome -1 , to -1 , Epam - 1
* */


import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) {

        getWordCount("Hello World, Hello Welcome to EPAM");

    }

    static void getWordCount(String str) {
        String[] strings = str.split("\\s+");

        Map<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedcount = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        for (Map.Entry<String, Integer> m : sortedcount) {
            System.out.println(m.getKey() + " : " + m.getValue());
        }
    }
}
