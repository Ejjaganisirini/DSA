class Solution {
    public long flowerGame(int n, int m) {
        long oddN = (n + 1) / 2;   // odd numbers in [1..n]
        long evenN = n / 2;        // even numbers in [1..n]
        long oddM = (m + 1) / 2;   // odd numbers in [1..m]
        long evenM = m / 2;        // even numbers in [1..m]

        // Alice wins when x + y is odd
        return oddN * evenM + evenN * oddM;
    }
}