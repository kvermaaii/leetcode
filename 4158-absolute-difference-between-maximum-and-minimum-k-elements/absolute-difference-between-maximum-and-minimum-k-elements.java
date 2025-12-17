class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int sum1 = 0;
        int sum2 = 0;
        int length = nums.length;
        while(k > 0){
            sum1 += nums[k-1];
            sum2 += nums[length - k];
            k--;
        }
        return Math.abs(sum1-sum2);
    }
}