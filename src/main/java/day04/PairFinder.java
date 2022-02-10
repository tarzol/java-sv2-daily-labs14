package day04;

import java.util.Map;
import java.util.TreeMap;

public class PairFinder {

    public int findPairs(int[] arr) {
        Map<Integer, Integer> pairs = new TreeMap<>();
        int numberOfPairs = 0;
        for (Integer actual : arr) {
            if (pairs.containsKey(actual)) {
                pairs.put(actual, pairs.get(actual)+1);
            } else {
                pairs.put(actual, 1);
            }
        }
        for ( Map.Entry<Integer, Integer> actual : pairs.entrySet()) {
            numberOfPairs += actual.getValue() / 2;
            //System.out.println(actual.getKey()+" "+actual.getValue());
        }
        return numberOfPairs;
    }

    public static void main(String[] args) {
        PairFinder finder = new PairFinder();
        System.out.println("Number Of pairs: "+finder.findPairs(new int[] {5, 1, 4, 5}));
        System.out.println("Number Of pairs: "+finder.findPairs(new int[] {7, 1, 5, 7, 3, 3, 5, 7, 6, 7, 7}));
    }
}
