class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int totalsum = 0;
        for(int num : nums){
            totalsum += num;
        }
        if(totalsum % k != 0) return false;
        totalsum /= k;
        boolean[] used = new boolean[n];
        return backtrack(0, totalsum, 0, used, nums, k);
    }
    public boolean backtrack(int i, int target, int sum, boolean[] used, int[] nums, int k){
        if(k == 0) return true;
        if(sum == target) return backtrack(0, target, 0, used, nums, k-1);
        if(i >= nums.length) return false;
        for(int j = i; j < nums.length; j++){
            if(nums[j] + sum <= target && !used[j]){
                used[j] = true;
                if( backtrack(j+1, target, sum + nums[j], used, nums, k) ){
                    return true;
                }
                used[j] = false;
            }
        }
        return false;
    }
}