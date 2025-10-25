package org.example;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
        FuzzyListGenerator generator = new FuzzyListGenerator();
        FuzzyFinder finder = new FuzzyFinder();

        ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
        ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();

        // Run all four tests
        int testOne = finder.linearSearch(sortedFuzzies);
        int testTwo = finder.binarySearch(sortedFuzzies);
        int testThree = finder.linearSearch(randomFuzzies);

        System.out.println("\n==== Fuzzy Finder Results ====");
        System.out.println("Linear Search (sorted): index " + testOne);
        System.out.println("Binary Search (sorted): index " + testTwo);
        System.out.println("Linear Search (random): index " + testThree);

        try {
            int testFour = finder.binarySearch(randomFuzzies);
            System.out.println("Binary Search (random): index " + testFour);
        } catch (IllegalArgumentException e) {
            System.out.println("Binary Search (random): failed → " + e.getMessage());
        }

        System.out.println("==============================\n");
    }
}
