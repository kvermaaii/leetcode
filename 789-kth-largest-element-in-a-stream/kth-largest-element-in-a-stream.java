class KthLargest {
    int kth;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        kth = k;
        minHeap = new PriorityQueue<>(kth);
        for(int num: nums){
            if(minHeap.size() < kth){
                minHeap.add(num);
            } else if(num > minHeap.peek()) {
                minHeap.add(num);
                if(minHeap.size() > kth){
                    minHeap.poll();
                }
            }
        }
    }
    
    public int add(int val) {
        if(minHeap.size() < kth){
            minHeap.add(val);
        } else if(val > minHeap.peek()) {
            minHeap.add(val);
            if(minHeap.size() > kth){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */