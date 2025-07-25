class Solution {
    static int[][] memo;
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        memo = new int[n][W+1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return knapsack(wt, val, n-1, W);
    }
    private static int knapsack(int[] wt, int[] val, int n, int W){
        if(n < 0 || W == 0) return 0;
        if(memo[n][W] != -1) return memo[n][W];
        if(wt[n] <=  W){
            return memo[n][W] = Math.max(
                        val[n] + knapsack(wt, val, n-1, W - wt[n]),
                        knapsack(wt, val, n-1, W));
        } else {
            return memo[n][W] =  knapsack(wt, val, n-1, W);
        }
    }
}
