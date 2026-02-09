class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int begin = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int currLength = 0;
        int sum = 0;
        while(end < nums.length){
            sum += nums[end];
            currLength++;
            while(sum >= target){
                minLength = Math.min(minLength, currLength);
                sum -= nums[begin];
                begin++;
                currLength--;
            }
            end++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}