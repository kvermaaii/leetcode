class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length; 
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0 && j == 0) continue;
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if(i != 0) up = dp[i-1][j];
                if(j != 0) left = dp[i][j-1];
                dp[i][j] = grid[i][j] + Math.min(up, left);
            }
        }
        return dp[row-1][col-1];
    }
    // public long rec(int[][] grid, int i , int j){
    //     if( i == 0 && j == 0) return grid[i][j];
    //     if(i < 0 || j < 0) return Integer.MAX_VALUE;
    //     long up = rec(grid, i -1, j) + grid[i][j];
    //     long left = rec(grid, i, j -1) + grid[i][j];
    //     return Math.min(up, left);
    // }
}