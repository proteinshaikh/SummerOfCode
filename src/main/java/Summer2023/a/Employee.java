package Summer2023.a;

import lombok.Builder;
import lombok.Data;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@Builder
public class Employee implements Comparable<Employee> {

    private final int id;
    private final String name;
    private final BigDecimal salary;

    // Comparators
    public static final Comparator<Employee> SALARY_COMPARATOR = Comparator.comparing(Employee::getSalary);
    public static final Comparator<Employee> NAME_COMPARATOR = Comparator.comparing(Employee::getName);

    public Employee(int id, String name, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee e) {
        return Comparator.comparing(Employee::getSalary)
                .thenComparing(Employee::getName)
                .compare(this, e);
    }

    // Question: Implement a Singleton Pattern with Double-Checked Locking
    static class MySingleton {
        private static volatile MySingleton instance;

        private MySingleton() {}

        public static MySingleton getInstance() {
            if (instance == null) {
                synchronized (MySingleton.class) {
                    if (instance == null) {
                        instance = new MySingleton();
                    }
                }
            }
            return instance;
        }
    }

    // Question: Implement a Singleton using an Enum
    public enum Singleton {
        INSTANCE;

        public void doSomething() {
            System.out.println("Singleton enum action performed!");
        }
    }

    // Question: Find two indices in an array such that their values add up to a target
    static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return null;
    }

    // Question: Count words in a sentence using Streams
    static void countWordsUsingStreams(String sentence) {
        Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " = " + v));
    }

    // Question: Calculate factorial using recursion
    static int factorial(int num) {
        return num <= 1 ? 1 : num * factorial(num - 1);
    }

    // Question: Rotate an array to the left
    static int[] rotateArrayLeft(int[] arr, int d) {
        int length = arr.length;
        int[] rotated = new int[length];
        for (int i = 0; i < length; i++) {
            rotated[i] = arr[(i + d) % length];
        }
        return rotated;
    }

    // Question: Rotate an array to the right
    static int[] rotateArrayRight(int[] arr, int d) {
        int length = arr.length;
        int[] rotated = new int[length];
        for (int i = 0; i < length; i++) {
            rotated[(i + d) % length] = arr[i];
        }
        return rotated;
    }

    // Question: Reverse a string without using a temporary variable
    static String reverseStringWithoutTemp(String sentence) {
        char[] chars = sentence.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            chars[left] = (char) (chars[left] ^ chars[right]);
            chars[right] = (char) (chars[left] ^ chars[right]);
            chars[left] = (char) (chars[left] ^ chars[right]);
            left++;
            right--;
        }
        return new String(chars);
    }

    // Question: Find common elements between two arrays
    static Set<Integer> commonElements(int[] arr1, int[] arr2) {
        Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        return Arrays.stream(arr2)
                .filter(set1::contains)
                .boxed()
                .collect(Collectors.toSet());
    }

    // Question: Write data to an Excel file using Apache POI
    static void apachePoi() throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("SampleSheet");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("id");
            header.createCell(1).setCellValue("name");
            Row data = sheet.createRow(1);
            data.createCell(0).setCellValue("1");
            data.createCell(1).setCellValue("zeeshan");

            try (FileOutputStream outputStream = new FileOutputStream("SampleSheet.xlsx")) {
                workbook.write(outputStream);
            }
        }
    }

    // Other questions follow similar structuring...

    public static void main(String[] args) throws IOException {
        // Example usage of methods for revision:
        System.out.println("Example: Reverse a String Without Temporary Variable");
        System.out.println(reverseStringWithoutTemp("hello"));

        System.out.println("Example: Count Words in a Sentence Using Streams");
        countWordsUsingStreams("please count these words");

        System.out.println("Example: Rotate Array Left");
        int[] rotatedArray = rotateArrayLeft(new int[]{1, 2, 3, 4, 5}, 2);
        System.out.println(Arrays.toString(rotatedArray));

    }
}
