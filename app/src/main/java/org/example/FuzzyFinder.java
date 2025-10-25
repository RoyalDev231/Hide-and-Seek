package org.example;
import java.util.ArrayList;

public class FuzzyFinder {

    private static final String TARGET = "gold";

  
    public int linearSearch(ArrayList<Fuzzy> fuzzies) {
        if (fuzzies == null) return -1;
        for (int i = 0; i < fuzzies.size(); i++) {
            Fuzzy f = fuzzies.get(i);
            if (f != null && f.color != null && TARGET.equalsIgnoreCase(f.color)) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(ArrayList<Fuzzy> fuzzies) {
        if (fuzzies == null || fuzzies.isEmpty()) return -1;

        if (!isSortedByColor(fuzzies)) {
            throw new IllegalArgumentException("List must be sorted ascending by color to use binarySearch.");
        }

        int lo = 0, hi = fuzzies.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            String midColor = fuzzies.get(mid).color;
            int cmp = compareColor(midColor, TARGET);

            if (cmp == 0) return mid;
            if (cmp < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    // --- helpers ---

    private static boolean isSortedByColor(ArrayList<Fuzzy> fuzzies) {
        String prev = null;
        for (Fuzzy f : fuzzies) {
            String c = (f == null) ? null : f.color;
            if (c == null) return false; 
            if (prev != null && compareColor(prev, c) > 0) return false;
            prev = c;
        }
        return true;
    }

    private static int compareColor(String a, String b) {
        if (a == null && b == null) return 0;
        if (a == null) return -1;
        if (b == null) return 1;
        return a.compareToIgnoreCase(b);
    }
}
