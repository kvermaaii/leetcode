class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length <= k){
            int max = Integer.MIN_VALUE;
            for(int i=0; i<nums.length; i++){
                max = Math.max(max,nums[i]);
            }
            int[] r = {max};
            return r;
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length+1-k];
        int l=0;
        for(int i=0; i < nums.length; i++){
            while(!deque.isEmpty() && deque.peekLast()<nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            if(i>=k-1 && !deque.isEmpty()){
                result[l++] = deque.peekFirst();
                if(deque.peekFirst() == nums[i+1-k]){
                    deque.removeFirst();
                }
            }
        }
        return result;
    }
}