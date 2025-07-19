class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = nums.length;
        if(l == 0) return 0;
        int maxCount = 0;
        for(int i = 0; i< l; i++){
            int c = 0;
            while(i < l && nums[i] == 1){
                i++;
                c++;
            }  
            maxCount = Math.max(c,maxCount);
        }
        return maxCount;
    }
}