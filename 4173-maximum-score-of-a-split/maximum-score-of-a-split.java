// class Solution {
//     public long maximumScore(int[] nums) {
//         int n = nums.length;
//         Queue<Integer> pq = new PriorityQueue<>();
//         List<Integer> li = new ArrayList<>();
//         for(int i = n-1; i > 0; i--){
//             pq.add(nums[i]);
//             li.add(pq.peek());
//         }
//         for(int i = 1; i < n; i++){
//             nums[i] += nums[i-1];
//         }
//         long maxScore = Long.MIN_VALUE;
//         for(int i = 0; i < n-1 ; i++){
//             maxScore = Math.max(maxScore, nums[i] - li.remove(li.size() - 1) );
//         }
//         return maxScore;
//     }
// }

class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
                int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }
        
        long maxScore = Long.MIN_VALUE;
        long prefixSum = 0;
        
        for(int i = 0; i < n - 1; i++){
            prefixSum += nums[i];
            long score = prefixSum - suffixMin[i + 1];
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }
}