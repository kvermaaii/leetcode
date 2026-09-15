class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //this solution is in constant memory
        int n = nums.length;
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < n-2; i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int start = i+1; 
            int end = nums.length - 1;
            System.out.println(nums[i]);
            while(start < end){
                if(start != i+1 && nums[start] == nums[start-1]){
                    start++;
                    continue;
                }
                int n1 = nums[start];
                int n2 = target - n1;
                while(start + 1 < end && nums[end] > n2){
                    end--;
                }
                if(nums[end] == n2){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    answer.add(list);
                }
                start++;
            } 
        }
        return answer;
    }
}