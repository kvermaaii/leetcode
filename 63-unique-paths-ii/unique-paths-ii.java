class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = 1;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0 && j == 0) continue;
                if(obstacleGrid[i][j] == 1) continue;
                int up = 0;
                int left = 0;
                if(i != 0) up = dp[i-1][j];
                if(j != 0) left = dp[i][j-1];
                dp[i][j] = up + left;
            }
        }
        return dp[row-1][col-1];
    }
    // int rec(int[][] g, int i, int j){
    //     if(i == 0 && j == 0) return 1;
    //     if(i < 0 || j < 0) return 0;
    //     if(g[i][j] == 1) return 0;
    //     int up = rec(g, i-1, j);
    //     int left = rec(g, i, j-1);
    //     return up + left;
    // }
}