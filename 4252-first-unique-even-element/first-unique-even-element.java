class Solution {
    public int firstUniqueEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i]%2 == 0) map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int num : nums){
            if(num % 2 == 0 && map.get(num) == 1){
                return num;
            }
        }
        return -1;
    }
}