class Solution {
    public boolean partitionArray(int[] nums, int k) {
        if(nums.length % k != 0){
            return false;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            } else{
                map.put(nums[i],1);
            }
        }
        int duplicate = Integer.MIN_VALUE;
        for(Integer key : map.keySet()){
            duplicate = Math.max(duplicate,map.get(key));
        }
        int noOfGrps = 0;
        if(nums.length % k == 0){
            noOfGrps = nums.length/k;
        } else{
            return false;
        }
        if(noOfGrps < duplicate){
            return false;
        }
        return true;
    }
}