class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        getAllSubset(0,nums,result,new ArrayList<>());
        return result;
    }

    public void getAllSubset(int i, int[] nums, List<List<Integer>> result, List<Integer> list){
        if(i == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        getAllSubset(i+1,nums,result,list);
        list.remove(list.size()-1);
        getAllSubset(i+1,nums,result,list);
    }
}