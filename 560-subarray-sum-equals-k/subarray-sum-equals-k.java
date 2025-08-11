class Solution {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int sum = 0;
        int count = 0;
        for(int i = 0; i < length ; i++){
            sum = 0;
            for(int j = i; j < length; j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }
}