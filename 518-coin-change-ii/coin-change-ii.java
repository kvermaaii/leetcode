class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= amount; j++){
                int take = 0;
                int nottake = 0;
                if(j >= coins[i]){
                    take = dp[i][j - coins[i]];
                }
                if(i > 0){
                    nottake = dp[i-1][j];
                }
                dp[i][j] = take + nottake;
            }
        }
        return dp[n-1][amount];
    }
    public int rec(int i , int[] c, int amount){
        if(amount == 0) return 1;
        if(i == c.length || amount < 0) return 0;
        return rec(i+1,c,amount) + rec(i,c,amount-c[i]);
    }
}