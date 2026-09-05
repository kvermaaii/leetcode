class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        dp[0][0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= amount; j++){
                if(i == 0 && j == 0) continue;
                int pick = 0;
                int pickNot = 0;
                if(j >= coins[i]) pick = dp[i][j-coins[i]];
                if(i != 0) pickNot = dp[i-1][j];
                dp[i][j] = pick + pickNot;
            }
        }
        return dp[n-1][amount];
    }
}