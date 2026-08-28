class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }
        int n = nums.length;
        if(totalSum % 2 == 1) return false;
        totalSum /= 2;
        boolean[][] dp = new boolean[n+1][totalSum+1]; // i = 0 means we are not picking anything null subset thats why dp size is n+1  and also the current itration will be wit i-1
        //base case
        //if totalSum > 0 && subset is null value will bea false only dp[0][0] = true;
        dp[0][0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= totalSum; j++){
                boolean pick = false;
                if(j >= nums[i-1]) pick = dp[i-1][j-nums[i-1]];
                boolean pickNot = dp[i-1][j]; 
                dp[i][j] = pick || pickNot;
            }
        }
        return dp[n][totalSum];
    }
}