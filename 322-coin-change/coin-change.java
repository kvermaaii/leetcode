class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        
        // Initialize with sentinel value
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= amount; j++){
                dp[i][j] = (int) 1e9;
            }
        }
        
        // Set base case - amount 0 requires 0 coins
        for(int i = 0; i < n; i++){
            dp[i][0] = 0;
        }
        
        // Fill DP table (START FROM j=1 TO PRESERVE BASE CASE)
        for(int i = 0; i < n; i++){
            for(int j = 1; j < amount + 1; j++){  // Changed from j=0 to j=1
                int pick = (int) 1e9;
                int pickNot = (int) 1e9;
                
                // Pick current coin (can reuse from SAME row)
                if(j >= coins[i]) {
                    pick = 1 + dp[i][j - coins[i]];
                }
                
                // Don't pick: only valid when there's a previous row
                if(i > 0) {
                    pickNot = dp[i-1][j];
                }
                
                dp[i][j] = Math.min(pick, pickNot);
            }
        }
        
        // Return result or -1 if impossible
        return dp[n-1][amount] >= (int)1e9 ? -1 : dp[n-1][amount];
    }
}