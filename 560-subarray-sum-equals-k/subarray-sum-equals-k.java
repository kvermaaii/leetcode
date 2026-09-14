class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return k == nums[0]? 1:0;
        int[] ps = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        ps[0] = nums[0];
        for(int i = 1; i < n; i++){
            ps[i] = ps[i-1] + nums[i];
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(ps[i] == k) ans++;
            ans += map.getOrDefault(ps[i] - k,0); 
            map.put(ps[i],map.getOrDefault(ps[i],0)+1);
        }
        // int ans = 0;
        // for(int i = 0; i < n ;i++){
        //     for(int j = i; j < n; j++){
        //         int sum;
        //         if(i == 0){
        //             sum = ps[j];
        //         }else{
        //             sum = ps[j] - ps[i-1];
        //         }
        //         if(sum == k) ans++;
        //     }
        // }
        return ans;
    }
}