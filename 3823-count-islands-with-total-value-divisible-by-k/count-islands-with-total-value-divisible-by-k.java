class Solution {
    public int countIslands(int[][] grid, int k) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] > 0){
                    int x = totalValue(grid,i,j);
                    if(x % k == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public int totalValue(int[][] grid, int row, int col){
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(row,col));
        int sum = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        sum += grid[row][col];
        grid[row][col] = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = { 0, 0,-1, 1}; 
        while(!q.isEmpty()){
            Pair<Integer, Integer> p = q.poll();
            int i = p.getKey();
            int j = p.getValue();
            for(int d = 0; d < 4; d++) {
                int ni = i + dr[d];
                int nj = j + dc[d];
                if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && grid[ni][nj] > 0) {
                    sum += grid[ni][nj];
                    q.add(new Pair<>(ni, nj));
                    grid[ni][nj] = 0;
                }
            }          
        }
        return sum;
    }
}