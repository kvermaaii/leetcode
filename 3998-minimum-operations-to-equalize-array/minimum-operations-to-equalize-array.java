class Solution {
    public int minOperations(int[] nums) {
        int x = nums[0];
        boolean flag = true;
        for(int j = 1; j < nums.length; j++){
            if(nums[j] != x){
                flag = false;
                break;
            }
        }
        if(flag){
            return 0;
        } else{
            return 1;
        }
    }
}