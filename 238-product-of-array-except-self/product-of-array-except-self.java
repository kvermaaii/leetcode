class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = nums[0];
        suffix[n-1] = nums[n-1];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1]*nums[i];
        }
        for(int j = n-2; j >= 0; j--){
            suffix[j] = suffix[j+1]*nums[j];
        }
        int[] ans = new int[n];
        for(int i = 0 ; i < n; i++){
            int suf = 1;
            int pre = 1;
            if(i != 0) pre = prefix[i-1];
            if(i != n-1) suf = suffix[i+1];
            ans[i] = pre*suf;
        }
        return ans;
    }
}