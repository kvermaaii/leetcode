class Solution {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int prefSum = 0;
        for(int i = 0; i< length; i++){
            prefSum += nums[i];
            int toFind = prefSum - k;
            if(map.containsKey(toFind)){
                count += map.get(toFind);
            }
            if(map.containsKey(prefSum)){
                int x = map.get(prefSum);
                map.put(prefSum,x+1);
            } else{
                map.put(prefSum,1);
            }
        }
        return count;
    }
}