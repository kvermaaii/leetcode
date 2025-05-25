class Solution {
    public int findKthLargest(int[] nums, int k) {
        int minV = Integer.MAX_VALUE;
        int maxV = Integer.MIN_VALUE;
        for(int n: nums){
            maxV = Math.max(maxV,n);
            minV = Math.min(minV,n);
        }
        int[] freq = new int[maxV+1-minV];
        // int[] sortedArr = new int[nums.length];
        for(int n: nums){
            freq[n-minV]++;
        }
        int index =0;
        for(int i =0; i<freq.length; i++){
            while(freq[i] !=0){
                freq[i]--;
                nums[index++] = i+minV;
            }
        }
        return nums[nums.length-k];
    }
}