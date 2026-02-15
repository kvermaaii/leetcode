class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return findSubarrays(nums, k) - findSubarrays(nums, k - 1);
    }
    private int findSubarrays(int[] nums, int k){
        int begin = 0;
        int end = 0;
        int oddCount = 0;
        int noOfSubarray = 0;
        while(end < nums.length){
            int curr = nums[end];
            if(curr % 2 == 1){
                oddCount++;
            }
            while(oddCount > k){
                if(nums[begin] % 2 == 1){
                    oddCount--;
                }
                begin++;
            }
            noOfSubarray += end - begin + 1;
            end++;
        }
        return noOfSubarray;
    }
}