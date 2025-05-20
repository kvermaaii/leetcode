class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        swap(0, nums, result);
        return result; 
    }

    public void swap(int i, int[] nums, List<List<Integer>> result) {
        if (i == nums.length) {
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : nums) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }

        for (int k = i; k < nums.length; k++) {
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;

            swap(i + 1, nums, result);

            temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
    }
}
