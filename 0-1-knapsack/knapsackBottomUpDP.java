class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j< W+1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }//similar to base condition
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j< W+1; j++){
                if(wt[i-1] <= j){// same if condition as that of recursive solution
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j - wt[i-1]], dp[i-1][j]);
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }// equation are similar to that of recursion n,W are just rplaced by i,j inside the loop.
        return dp[n][W];
    }
}
