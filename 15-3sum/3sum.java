class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int l = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i =0; i < l - 2; i++){
            for(int j = i+1; j< l - 1; j++){
                int target = - (nums[i] + nums[j]);
                int f = find(nums, target, j + 1, l - 1);
                if(f != -1){
                    set.add(Arrays.asList(nums[i], nums[j], nums[f]));
                }
            }
        }
        return new ArrayList<>(set);
    }
    public int find(int[] nums, int target, int start, int end){
        if(start > end) return -1;
        int mid = start + (end - start)/2;
        if(target > nums[mid]){
            return find(nums,target,mid+1,end);
        } else if(target < nums[mid]){
            return find(nums,target,start,mid-1);
        } else{
            return mid;
        }
    }
}