package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class FuzzyFinderTest  {

    @Test
    @DisplayName("Linear search finds gold in sorted list")
    void linear_on_sorted_finds_gold() {
        FuzzyListGenerator gen = new FuzzyListGenerator();
        ArrayList<Fuzzy> sorted = gen.sortedRainbowFuzzies();
        FuzzyFinder finder = new FuzzyFinder();

        int idx = finder.linearSearch(sorted);
        assertTrue(idx >= 0, "Linear search should find gold in sorted list");
        assertEquals("gold", sorted.get(idx).color.toLowerCase(), "Index must point to a gold fuzzy");
    }

    @Test
    @DisplayName("Binary search finds gold in sorted list")
    void binary_on_sorted_finds_gold() {
        FuzzyListGenerator gen = new FuzzyListGenerator();
        ArrayList<Fuzzy> sorted = gen.sortedRainbowFuzzies();
        FuzzyFinder finder = new FuzzyFinder();

        int idx = finder.binarySearch(sorted);
        assertTrue(idx >= 0, "Binary search should find gold in sorted list");
        assertEquals("gold", sorted.get(idx).color.toLowerCase(), "Index must point to a gold fuzzy");
    }

    @Test
    @DisplayName("Linear search finds gold in randomized list")
    void linear_on_random_finds_gold() {
        FuzzyListGenerator gen = new FuzzyListGenerator();
        ArrayList<Fuzzy> random = gen.randomizedRainbowFuzzies();
        FuzzyFinder finder = new FuzzyFinder();

        int idx = finder.linearSearch(random);
        assertTrue(idx >= 0, "Linear search should find gold in random list");
        assertEquals("gold", random.get(idx).color.toLowerCase(), "Index must point to a gold fuzzy");
    }

    @Test
    @DisplayName("Binary search on random list: throws due to unsorted input")
    void binary_on_random_throws() {
        FuzzyListGenerator gen = new FuzzyListGenerator();
        ArrayList<Fuzzy> random = gen.randomizedRainbowFuzzies();
        FuzzyFinder finder = new FuzzyFinder();

        assertThrows(IllegalArgumentException.class, () -> finder.binarySearch(random),
                "Binary search should reject unsorted input");
    }
}
