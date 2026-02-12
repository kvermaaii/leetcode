class Solution {
    Integer[][][] dp;

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        dp = new Integer[n][2][2];
        return rec(nums, 0, false, false);
    }

    public int rec(int[] nums, int i, boolean prev, boolean first) {
        if (i >= nums.length) {
            return 0;
        }

        int p = prev ? 1 : 0;
        int f = first ? 1 : 0;

        if (dp[i][p][f] != null) {
            return dp[i][p][f];
        }

        int best;

        if (!prev) {
            // skip
            int skip = rec(nums, i + 1, false, first);

            // rob (if allowed)
            int rob = 0;
            if (!(i == nums.length - 1 && first)) {
                boolean newFirst = first;
                if (i == 0) newFirst = true;
                rob = nums[i] + rec(nums, i + 1, true, newFirst);
            }

            best = Math.max(skip, rob);
        } else {
            // must skip
            best = rec(nums, i + 1, false, first);
        }

        dp[i][p][f] = best;
        return best;
    }
}
