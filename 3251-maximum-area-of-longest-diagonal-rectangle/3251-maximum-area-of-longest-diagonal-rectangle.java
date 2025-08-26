class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiag = -1;
        int maxArea = -1;
        
        for (int[] rect : dimensions) {
            int l = rect[0], w = rect[1];
            int diagSq = l * l + w * w;  // squared diagonal
            int area = l * w;
            
            if (diagSq > maxDiag) {
                maxDiag = diagSq;
                maxArea = area;
            } else if (diagSq == maxDiag) {
                maxArea = Math.max(maxArea, area);
            }
        }
        
        return maxArea;
    }
}