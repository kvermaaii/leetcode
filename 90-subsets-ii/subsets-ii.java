class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        uniqueSubset(0,nums,result,new ArrayList<>());
        return result;
    }

    public void uniqueSubset(int i,int[] nums,List<List<Integer>> result, List<Integer> list){
        
        result.add(new ArrayList<>(list));
 
        for(int k=i; k<nums.length; k++){
            if(k > i && nums[k] == nums[k-1]){
                continue;
            }
            list.add(nums[k]);
            uniqueSubset(k+1,nums,result,list);
            list.remove(list.size()-1);
        }
    }
}