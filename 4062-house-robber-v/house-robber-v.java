class Solution {
    long[][] memo;
    public long rob(int[] nums, int[] colors) {
        memo = new long[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return rec(nums,nums.length-1, colors, 0);
    }
    public long rec(int[] nums, int i, int[] color, int f){
        if(i < 0) return 0;
        if(memo[i][f] != -1) return memo[i][f];
        long pick = 0;
        boolean canPick = true;
        if(f == 1 && i < nums.length-1 && color[i] == color[i+1]){
            canPick = false;
        }
        if(canPick){
            pick = nums[i] + rec(nums,i-1,color, 1);
        }
        long noPick =  rec(nums,i-1,color, 0);
        return memo[i][f] = Math.max(pick,noPick);
    }
}