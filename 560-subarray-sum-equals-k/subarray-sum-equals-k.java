class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] ps = new int[n];
        ps[0] = nums[0];
        for(int i = 1; i < n; i++){
            ps[i] = ps[i-1] + nums[i];
        }
        int ans = 0;
        for(int i = 0; i < n ;i++){
            for(int j = i; j < n; j++){
                int sum;
                if(i == 0){
                    sum = ps[j];
                }else{
                    sum = ps[j] - ps[i-1];
                }
                if(sum == k) ans++;
            }
        }
        return ans;
    }
}