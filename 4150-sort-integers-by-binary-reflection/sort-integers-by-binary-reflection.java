class Solution {
    public int[] sortByReflection(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0])
                           : Integer.compare(a[1], b[1])
        );

        for(int i = 0; i < nums.length; i++){
            String bin = Integer.toBinaryString(nums[i]);
            String rev = new StringBuilder(bin).reverse().toString();
            int n = Integer.parseInt(rev, 2);
            pq.add(new int[]{n, nums[i]});
        }
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = pq.poll()[1];
        }
        return arr;
    }
}