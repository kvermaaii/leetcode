class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row-1).size();
        int[][] dp = new int[row][col];
        for(int i = 0; i < col; i++){
            dp[row-1][i] = triangle.get(row-1).get(i);
        }
        for(int i = row-2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                int c1 = dp[i+1][j];
                int c2 = dp[i+1][j+1];
                dp[i][j] = triangle.get(i).get(j) + Math.min(c1,c2);
            }
        }
        return dp[0][0];
    }
    // int rec(List<List<Integer>> t, int i, int j){
    //     if(i == t.size()-1){
    //         return t.get(i).get(j);
    //     }
    //     if (i >= t.size()) return 0;
    //     if(t == null) return 0;
    //     int c1 = t.get(i).get(j) + rec(t, i+1, j);
    //     int c2 = t.get(i).get(j) + rec(t, i+1, j+1);
    //     return Math.min(c1, c2);
    // }
}