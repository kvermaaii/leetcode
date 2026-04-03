class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int p = 0;
        while(p < nums.length && nums[p] == 0){
            p++;
        }
        int minDiff = Integer.MAX_VALUE;
        for(int i = p+1; i < nums.length; i++){
            if(nums[i] != nums[p] && nums[i] != 0){
                minDiff = Math.min(minDiff, i-p);
                p = i;
            }
            if(nums[i] != 0) p = i;
        }
        return minDiff == Integer.MAX_VALUE? -1 : minDiff;
    }
}