import java.util.*;
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int b : basket1) freq.put(b, freq.getOrDefault(b, 0) + 1);
        for (int b : basket2) freq.put(b, freq.getOrDefault(b, 0) + 1);
        for (int count : freq.values()) {
            if (count % 2 != 0) return -1;
        }
        Map<Integer, Integer> count1 = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();
        for (int b : basket1) count1.put(b, count1.getOrDefault(b, 0) + 1);
        for (int b : basket2) count2.put(b, count2.getOrDefault(b, 0) + 1);
        List<Integer> toSwap = new ArrayList<>();
        int minVal = Integer.MAX_VALUE;
        for (int key : freq.keySet()) {
            int total = freq.get(key) / 2;
            int c1 = count1.getOrDefault(key, 0);
            int c2 = count2.getOrDefault(key, 0);
            if (c1 > total) {
                for (int i = 0; i < c1 - total; i++) {
                    toSwap.add(key);
                }
            } else if (c2 > total) {
                for (int i = 0; i < c2 - total; i++) {
                    toSwap.add(key);
                }
            }
            minVal = Math.min(minVal, key);
        }
        Collections.sort(toSwap);
        long cost = 0;
        int half = toSwap.size() / 2;
        for (int i = 0; i < half; i++) {
            cost += Math.min(toSwap.get(i), 2 * minVal);
        }
        return cost;
    }
}