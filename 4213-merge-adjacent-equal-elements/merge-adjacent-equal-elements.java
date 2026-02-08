class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        int n = nums.length;
        Stack<Long> stk = new Stack<>();
        for(int i = 0; i < n; i++){
            long c = nums[i];
            while(!stk.isEmpty() && stk.peek() == c){
                c += c;
                stk.pop();
            }
            stk.push(c);
        }
        List<Long> li = new ArrayList<>(stk);
        return li;
    }
}