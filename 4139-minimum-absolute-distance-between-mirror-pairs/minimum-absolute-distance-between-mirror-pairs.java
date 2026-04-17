class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int minDist = Integer.MAX_VALUE;
        map.put(reverse(nums[0]), 0);
        for(int i = 1; i < n; i++){
            if(map.containsKey(nums[i])){
                minDist = Math.min(Math.abs(map.get(nums[i]) - i) , minDist);
            }
            map.put(reverse(nums[i]), i);
        }
        return (minDist != Integer.MAX_VALUE) ? minDist : -1;
    }
    // public int reverse(int x){
    //     StringBuilder sb = new StringBuilder();
    //     while(x != 0){
    //         int dig = x % 10;
    //         sb.append(dig);
    //         x /= 10;
    //     }
    //     return Integer.parseInt(sb.toString());
    // }

    public int reverse(int x) {
    int reversed = 0;
    
    while (x > 0) {
        int lastDigit = x % 10;
        
        // Shift existing digits left, and add the new digit to the empty slot
        reversed = (reversed * 10) + lastDigit; 
        
        x /= 10;
    }
    
    return reversed;
}
}