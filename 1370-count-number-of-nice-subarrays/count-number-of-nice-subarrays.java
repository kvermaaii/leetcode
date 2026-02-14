class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int begin = 0;
        int end = 0;
        int oddCount = 0;
        int noOfSubarray = 0;
        int last = -1;
        Deque<Integer> pq = new ArrayDeque<>();
        while(end < nums.length){
            int curr = nums[end];
            if(curr % 2 == 1){
                last = end;
                pq.addLast(end);
                oddCount++;
            }
            while(oddCount > k){
                if(nums[begin] % 2 == 1){
                    oddCount--;
                    pq.removeFirst();
                }
                begin++;
            }
            if(oddCount == k && !pq.isEmpty()){
                noOfSubarray += pq.peekFirst() - begin + 1;
            }
            end++;
        }
        return noOfSubarray;
    }
}