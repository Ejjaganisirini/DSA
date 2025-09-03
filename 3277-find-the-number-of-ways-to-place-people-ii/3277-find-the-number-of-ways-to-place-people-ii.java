import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int result = 0;
        
        // Sort by x, then by y
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Alice = points[i], Bob = points[j]
                int ax = points[i][0], ay = points[i][1];
                int bx = points[j][0], by = points[j][1];
                
                // Check if Alice can be upper-left of Bob
                if (ax <= bx && ay >= by) {
                    boolean valid = true;
                    
                    for (int k = i + 1; k < j; k++) {
                        int x = points[k][0], y = points[k][1];
                        if (x >= ax && x <= bx && y <= ay && y >= by) {
                            valid = false;
                            break;
                        }
                    }
                    
                    if (valid) result++;
                }
            }
        }
        
        return result;
    }
}