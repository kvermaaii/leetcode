class Solution {
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        for(int i = 1; i < n+1; i++){
            for(int j = 0; j <  target+1; j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j - nums[i-1]] + dp[i-1][j];
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
    // private int perfectSum(int[] nums, int target, int n){
    //     if (n == 0) {
    //         return (target == 0) ? 1 : 0;
    //     }
    //     if(nums[n-1] <= target){
    //         return perfectSum(nums,target - nums[n-1],n-1) + perfectSum(nums,target,n-1);
    //     } else{
    //         return perfectSum(nums,target,n-1);
    //     }
    // }
}

