class Solution {
    public long maximumScore(int[] nums, String s) {
        int n = nums.length;
        int c = 0;
        int lastOne = -1;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1'){
                c++;
                lastOne = i;
            }
        }
        if(lastOne == -1) return 0;
        // i can make a priority queue from index 0 of nums till where 1 appears for the first time and poll the pq then continue till the next 1 and so on.
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        long score = 0;
        for(int i = 0; i < n; i++){
            pq.add(nums[i]);
            if(s.charAt(i) == '1'){
                score += pq.poll();
            }
        }
        return score;
    }
}