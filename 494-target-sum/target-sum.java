class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int length = nums.length;
        int sum = 0;
        for(int i = 0; i < length; i++){
            sum += nums[i];
        }
        if((sum + target) % 2 != 0){
            return 0;
        }
        int x = (sum + target)/2;
        return findTargetSum(nums, length, x);
    }
    public int findTargetSum(int[] nums, int n, int W){
        if (n == 0) return W == 0 ? 1 : 0;
        if(nums[n-1] <= W){
            return findTargetSum(nums, n-1, W - nums[n-1]) + findTargetSum(nums, n-1, W);
        } else{
            return findTargetSum(nums, n-1, W);
        }
    }
}