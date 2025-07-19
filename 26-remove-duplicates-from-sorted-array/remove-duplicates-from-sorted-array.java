class Solution {
    public int removeDuplicates(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);;
        int start = 0;
        int end = nums.length - 1;
        for(int i = 0; i< nums.length; i++){
            if(i == 0){
                nums[start] = arr[0];
                start++;
            } else{
                if(arr[i-1] == arr[i]){
                    nums[end] = -101;
                    end--;
                } else{
                    nums[start] = arr[i];
                    start++;
                }
            }
        }
        return start;
    }
}