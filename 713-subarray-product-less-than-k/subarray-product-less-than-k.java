class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int begin = 0;
        int end = 0;
        int count = 0;
        int product = 1;
        while(end < nums.length){
            product *= nums[end];
            while(begin < end && product >= k){
                product /= nums[begin];
                begin++;
            }
            if(product < k){
                count += end - begin + 1; //when we add a new element in an array the no of subarray increases by the no of element in the array here from begin to end the product is les then k so for sure all the subarray product will also be less then k
            }
            end++;
        }
        return count;
    }
}