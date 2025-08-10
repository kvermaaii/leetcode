class Solution {
    int[][] dp;
    public int cutRod(int[] price) {
        int n = price.length;
        int[] length = new int[n];
        for(int i = 0; i< n; i++){
            length[i] = i+1;
        }
        dp = new int[n+1][n+1];
        for(int i = 0; i < n; i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= n; j++){
                if(length[i-1] <= j){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j - length[i-1]], dp[i-1][j]);
                } else{
                    dp[i][j] =  dp[i-1][j];
                }
            }
        }
        return dp[n][n];
    }
    
    // Integer[][] memo;
    // public int cutRod(int[] price) {
    //     int n = price.length;
    //     memo = new Integer[n + 1][n + 1];
    //     int[] length = new int[n];
    //     for(int i = 0; i< n; i++){
    //         length[i] = i+1;
    //     }
    //     return cutRod(price, length, n, n);
    // }
    
    // private int cutRod(int[] price, int[] length, int n, int l){
    //     if(n <= 0 || l ==0) return 0;
    //     if (memo[n][l] != null) return memo[n][l];
    //     if(length[n-1] <= l){
    //         return memo[n][l] =  Math.max(price[n-1] + cutRod(price,length,n,l - length[n-1]),
    //             cutRod(price,length,n-1,l));
    //     } else{
    //         return memo[n][l] =  cutRod(price,length,n-1,l);
    //     }
    // }
}

