class Solution {
    public int minOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int ind = -1;
        for(int i = n - 1; i >= 0; i--){
            if(set.contains(nums[i])){
                ind = i;
                break;
            } else{
                set.add(nums[i]);
            }
        }
        if(ind == -1) return 0;
        ind++;
        int swaps = (ind + 2)/3;  // ceiling value
        return swaps;
    }
}