package org.example;

// Don't change this file!

import java.util.ArrayList;
import java.util.Collections;

public class FuzzyListGenerator {
  int iterations;

  public FuzzyListGenerator() {
    this.iterations = 1000;
  }

  public FuzzyListGenerator(int iterations) {
    this.iterations = iterations;
  }

  public ArrayList<Fuzzy> randomizedRainbowFuzzies() {
    ArrayList<Fuzzy> fuzzies = new ArrayList<>();
    for (int i = 0; i < this.iterations; i++) {
      fuzzies.add(new Fuzzy("red"));
      fuzzies.add(new Fuzzy("orange"));
      fuzzies.add(new Fuzzy("yellow"));
      fuzzies.add(new Fuzzy("green"));
      fuzzies.add(new Fuzzy("blue"));
      fuzzies.add(new Fuzzy("indigo"));
      fuzzies.add(new Fuzzy("violet"));
    }
    fuzzies.add(new Fuzzy("gold"));

    Collections.shuffle(fuzzies);
    return fuzzies;
  };

  public ArrayList<Fuzzy> sortedRainbowFuzzies() {
    ArrayList<Fuzzy> fuzzies = new ArrayList<>();
    for (int i = 0; i < this.iterations; i++) {
      fuzzies.add(new Fuzzy("red"));
      fuzzies.add(new Fuzzy("orange"));
      fuzzies.add(new Fuzzy("yellow"));
      fuzzies.add(new Fuzzy("green"));
      fuzzies.add(new Fuzzy("blue"));
      fuzzies.add(new Fuzzy("indigo"));
      fuzzies.add(new Fuzzy("violet"));
    }
    fuzzies.add(new Fuzzy("gold"));

    fuzzies.sort((f1, f2) -> f1.color.compareTo(f2.color));
    return fuzzies;
  };
}
