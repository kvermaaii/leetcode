class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalClr = image[sr][sc];
        if (originalClr == color) return image;
        int noOfRows = image.length;
        int noOfColl = image[0].length;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(sr, sc));
        while(!q.isEmpty()){
            Pair<Integer, Integer> pr = q.poll();
            int row = pr.getKey();
            int col = pr.getValue();
            image[row][col] = color;
            if(row < (noOfRows - 1) && image[row+1][col] == originalClr){
                q.add(new Pair<>(row+1,col));
            }
            if(row > 0 && image[row-1][col] == originalClr){
                q.add(new Pair<>(row-1,col));
            }
            if(col < (noOfColl - 1) && image[row][col+1] == originalClr){
                q.add(new Pair<>(row,col+1));
            }
            if(col > 0 && image[row][col-1] == originalClr){
                q.add(new Pair<>(row,col-1));
            }
        }
        return image;
    }
}