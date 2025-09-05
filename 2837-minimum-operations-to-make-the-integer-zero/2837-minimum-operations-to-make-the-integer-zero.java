class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        // Try operations count k from 1 up to 60 (safe upper bound)
        for (int k = 1; k <= 60; k++) {
            long val = (long) num1 - (long) k * num2; // must be >= 0
            if (val < 0) continue;

            int popcount = Long.bitCount(val); // number of set bits
            if (popcount <= k && k <= val) {
                return k; // minimum operations found
            }
        }
        return -1;
    }
}
