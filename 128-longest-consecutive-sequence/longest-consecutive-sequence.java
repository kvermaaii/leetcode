class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1) return n;
        int curr = 1;
        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }
        Set<Integer> start = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(!set.contains(nums[i] - 1)){
                start.add(nums[i]);
            }
        }
        for(int has : start){
            while(set.contains(has+1)){
                curr++;
                has++;
            }
            longest = Math.max(longest,curr);
            curr = 1;
        }
        return longest;
    }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            