class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int l = nums.length;
        int[] arr = Arrays.copyOf(nums, l);;
        int start = 0;
        int end = nums.length - 1;
        for(int i = 0; i< l; i++){
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