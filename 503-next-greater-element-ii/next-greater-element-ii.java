class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        if (n == 1) return new int[]{-1};
        int[] arr = new int[n];
        Stack<Integer> stk = new Stack();
        int i = n - 2;
        stk.add(nums[n-1]);
        int no = 0;
        while(no < 2*n){
            no++; //if no is greater then n and then we ar adding an element we break out of loop
            while(!stk.isEmpty() && nums[i] >= stk.peek()){
                stk.pop();
            }
            if(stk.isEmpty()){
                arr[i] = -1;
            }else{
                arr[i] = stk.peek();
            }
            stk.add(nums[i]);
            i = ( i- 1 + n) % n;
        }
        return arr;
    }
}