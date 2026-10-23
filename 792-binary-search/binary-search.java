class Solution {
    public int search(int[] nums, int target) {
        return bs(0, nums.length-1, target, nums);
    }
    public int bs(int first, int last, int target, int[] nums){
        if(first > last) return -1;
        int mid = first + (last - first) / 2;
        if(nums[mid] == target) return mid;
        if(nums[mid] > target){
            return bs(first, mid-1, target, nums);
        }else{
            return bs(mid+1, last, target, nums);
        }
    }
}