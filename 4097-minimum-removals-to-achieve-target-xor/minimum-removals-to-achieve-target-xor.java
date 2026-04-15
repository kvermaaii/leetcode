class Solution {
    int[][] memo;
    public int minRemovals(int[] nums, int target) {
        /*->The golden rule for sizing a DP array is: The size of each dimension must be equal to the maximum possible value of that parameter, plus one.
        -> In bitwise math, XORing numbers together can never exceed the next highest power of 2.
The next power of 2 after 10,000 is 16,384.
         */
        memo = new int[nums.length][16384];
        for(int i = 0; i < nums.length ; i++){
            Arrays.fill(memo[i],-1);
        }
        int result =  rec(nums, target, 0,0);
        return (result >= 41)? -1 : result;
    }
    public int rec(int[] nums, int target, int xor, int i){
        if(i >= nums.length) {
            if(xor == target){
                return 0;
            }else{
                return 41;
            }
        }
        if(memo[i][xor] != -1) return memo[i][xor];
        int keep = rec(nums, target, xor^nums[i], i+1);
        int remove = 1 + rec(nums, target, xor, i+1);
        memo[i][xor] = Math.min(keep, remove);
        return memo[i][xor];

        /*        
        ->Dynamic Programming: Never put the thing you are trying to count into your state parameters.
The Accumulator Trap
Right now, you are using removals as an accumulator. You are carrying it down to the bottom of the recursion tree, checking if it's the minimum, and storing it in a global variable.

If we include removals in our cache state, our cache becomes highly inefficient. We might visit index 3 with an XOR of 5 having made 1 removal, and then later visit index 3 with an XOR of 5 having made 2 removals. The computer treats these as completely different states and calculates the whole remaining array twice! */
    }
}