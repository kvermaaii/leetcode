class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // int[] k ={0} if using recrsion
        int minutes =0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            boolean orangeGotRotten=false;
            for(int i=0; i<size; i++){
                int[] coord = q.poll();
                int row =coord[0];
                int col =coord[1];
                if(row !=m-1 && grid[row+1][col] == 1){
                    grid[row+1][col] =2;
                    q.add(new int[]{row+1,col});
                    orangeGotRotten =true;
                }
                if(col !=n-1 && grid[row][col+1] == 1){
                    grid[row][col+1] =2;
                    q.add(new int[]{row,col+1});
                    orangeGotRotten =true;
                }
                if(row !=0 && grid[row-1][col] ==1){
                    grid[row-1][col] =2;
                    q.add(new int[]{row-1,col});
                    orangeGotRotten =true;
                }
                if(col != 0 && grid[row][col-1] == 1){
                    grid[row][col-1] =2;
                    q.add(new int[]{row,col-1});
                    orangeGotRotten =true;
                }
            }
            if(orangeGotRotten){
                minutes++;
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return minutes;
    }
}