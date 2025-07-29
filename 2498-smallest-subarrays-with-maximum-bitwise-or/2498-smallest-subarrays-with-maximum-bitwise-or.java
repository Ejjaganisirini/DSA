class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] last = new int[32]; 

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 32; j++) {
                if ((nums[i] & (1 << j)) != 0) {
                    last[j] = i;
                }
            }

            int maxReach = i;
            for (int j = 0; j < 32; j++) {
                maxReach = Math.max(maxReach, last[j]);
            }

            result[i] = maxReach - i + 1;
        }

        return result;
    }
}