class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];

        int pro = 1;
        // Left to right pass
        for (int i = 0; i < n; i++) {
            pro *= nums[i];
            max = Math.max(max, pro);
            if (pro == 0) pro = 1;
        }

        pro = 1;
        // Right to left pass
        for (int i = n - 1; i >= 0; i--) {
            pro *= nums[i];
            max = Math.max(max, pro);
            if (pro == 0) pro = 1;
        }

        return max;
    }
}