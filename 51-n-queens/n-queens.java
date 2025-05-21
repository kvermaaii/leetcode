class Solution {
    public List<List<String>> solveNQueens(int n) {
        //create a n*n matrix
        String[][] board = new String[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = ".";
            }
        }
        List<List<String>> result = new ArrayList<>();
        NQueens(0,n,board,result, new ArrayList<>());
        return result;
    }

    public void NQueens(int i, int n,String[][] board, List<List<String>> result, List<String> list){
        if(i==n){
            //add the matrix to the resullt
            for(int p=0; p<i; p++){
                StringBuilder sb = new StringBuilder();
                for(int q=0; q<n; q++){
                    sb.append(board[p][q]);
                }
                list.add(sb.toString());
            }
            result.add(new ArrayList<>(list));
            list.clear();
            return;
        }


        
        for(int k=0; k<n; k++){
            if(canFill(k,i,n,board)){
                board[k][i] = "Q";
                NQueens(i+1,n,board,result,list);
            }
            board[k][i] = ".";
        }
    }

    public boolean canFill(int row, int col,int n,String[][] board){

        for (int c = 0; c < col; c++) {
            if (board[row][c].equals("Q")) {
                return false;
            }
        }

        int r = row - 1, c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board[r][c].equals("Q")) {
                return false;
            }
            r--;
            c--;
        }

        r = row + 1;
        c = col - 1;
        while (r < n && c >= 0) {
            if (board[r][c].equals("Q")) {
                return false;
            }
            r++;
            c--;
        }

        return true;
    }
}