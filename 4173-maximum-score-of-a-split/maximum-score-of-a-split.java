class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        
        int[] suffixMin = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = n - 1; i >= 0; i--){
            pq.add(nums[i]);
            suffixMin[i] = pq.peek();
        }
        
        long prefixSum = 0;
        long maxScore = Long.MIN_VALUE;
        
        for(int i = 0; i < n - 1; i++){
            prefixSum += nums[i];  
            maxScore = Math.max(maxScore, prefixSum - suffixMin[i + 1]);
        }
        
        return maxScore;
    }
}

