class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] height = new int[m][n];
        
        // Build histogram heights for each row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    height[i][j] = (i == 0 ? 1 : height[i-1][j] + 1);
                }
            }
        }
        
        int result = 0;
        // For each row, count submatrices using histogram method
        for (int i = 0; i < m; i++) {
            result += countFromHistogram(height[i]);
        }
        
        return result;
    }
    
    private int countFromHistogram(int[] heights) {
        int n = heights.length;
        int[] sum = new int[n];
        int res = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        
        for (int j = 0; j < n; j++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[j]) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                int prev = stack.peek();
                sum[j] = sum[prev] + heights[j] * (j - prev);
            } else {
                sum[j] = heights[j] * (j + 1);
            }
            
            stack.push(j);
            res += sum[j];
        }
        return res;
    }
}