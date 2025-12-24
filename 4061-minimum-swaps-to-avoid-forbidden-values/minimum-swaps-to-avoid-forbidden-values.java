class Solution {
    public int minSwaps(int[] nums, int[] forbidden) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(); 
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);  
            map.put(forbidden[i], map.getOrDefault(forbidden[i], 0) + 1);          
        }
        for(int v : map.values()){
            if(v > n) return -1;
        }
        map.clear();  
        int k = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == forbidden[i]){
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);  
                k++;
            }
        }
        k = (k + 1)/2;
        int Fmax = Integer.MIN_VALUE;
        for(int v : map.values()){
            Fmax = Math.max(Fmax, v);
        }
        return Math.max(Fmax, k);
    }
}