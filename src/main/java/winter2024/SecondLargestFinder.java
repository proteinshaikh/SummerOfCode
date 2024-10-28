package winter2024;

import java.util.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.Random;
import java.util.stream.LongStream;

import java.util.Random;
import java.util.stream.LongStream;

public class SecondLargestFinder {

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        // Find the second largest number in a stream of 1 billion random integers
        long secondLargest = findSecondLargest(1_000_000);
        long endTime = System.nanoTime();
        System.out.println("The second largest number is: " + secondLargest);
        double elapsedTimeInSeconds = (endTime - startTime) / 1_000_000.0;
        System.out.println("Time taken."+elapsedTimeInSeconds);
    }

    public static long findSecondLargest(long count) {
        Random random = new Random();

        // Use an array to hold the first and second largest values
        long[] largest = {Long.MIN_VALUE, Long.MIN_VALUE}; // largest[0] = first, largest[1] = second

        // Stream of random numbers limited to `count` elements
        LongStream.generate(() -> random.nextLong(Long.MAX_VALUE))
                .limit(count)
                .forEach(num -> {
                    if (num > largest[0]) {
                        largest[1] = largest[0]; // Update the second largest
                        largest[0] = num;        // Update the largest
                    } else if (num > largest[1] && num != largest[0]) {
                        largest[1] = num; // Update the second largest only
                    }
                });

        return largest[1];
    }
}




