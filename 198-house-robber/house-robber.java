class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rec(nums,nums.length-1);
    }
    public int rec(int[] nums, int i){
        if(i < 0) return 0;
        if(memo[i] != -1) return memo[i];
        int pick = nums[i] + rec(nums, i - 2);
        int noPick = rec(nums, i - 1);
        return memo[i] = Math.max(pick, noPick);
    }
}