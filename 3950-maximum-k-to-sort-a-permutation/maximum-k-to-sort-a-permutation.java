class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(nums[i] != i){
                min = min & nums[i];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}