class Solution {
    public int maximumSum(int[] nums) {
        Queue<Integer> pq0 = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Queue<Integer> pq1 = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int r = nums[i] % 3;
            if(r == 0) {
                pq0.add(nums[i]);
            }else if(r == 1) {
                pq1.add(nums[i]);
            }else {
                pq2.add(nums[i]);
            }
        }
        int maxSum = Integer.MIN_VALUE;
        if(!pq2.isEmpty() && !pq1.isEmpty() && !pq0.isEmpty()){
            int s1 = pq2.peek() + pq1.peek() + pq0.peek();
            maxSum = Math.max(maxSum,s1);
        }
        if(pq2.size() > 2){
            int s2 = pq2.poll() + pq2.poll() + pq2.poll();
            maxSum = Math.max(maxSum,s2);
        }
        if(pq1.size() > 2){
            int s3 = pq1.poll() + pq1.poll() + pq1.poll();
            maxSum = Math.max(maxSum,s3);
        }
        if(pq0.size() > 2){
            int s4 = pq0.poll() + pq0.poll() + pq0.poll();
            maxSum = Math.max(maxSum,s4);
        }
        return (maxSum == Integer.MIN_VALUE)? 0:maxSum;
    }
}