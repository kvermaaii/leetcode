class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int begin = 0;
        int end = 0;
        long maxSum = 0;
        long saSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(end < nums.length){
            int currNum = nums[end];
            int lastOccur = map.getOrDefault(currNum,-1);
            while(begin <= lastOccur || end - begin + 1 > k){
                saSum -= nums[begin];
                begin++;
            }
            map.put(currNum, end);
            saSum += currNum;
            if(end - begin + 1 == k){
                maxSum = Math.max(maxSum,saSum);
            }
            end++;
        }
        return maxSum;
    }
}