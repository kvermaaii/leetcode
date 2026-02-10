class Solution {
    public int longestOnes(int[] nums, int k) {
        int begin = 0;
        int end = 0;
        int oneCount = 0;
        int zeroCount = 0;
        int maxConsOne = 0;
        while(end < nums.length){
            int currNum = nums[end];
            oneCount += currNum;
            if(currNum == 0) zeroCount++;
            while(begin <= end && zeroCount > k){
                if(nums[begin] == 0){
                    zeroCount--;
                }else{
                    oneCount--;
                }
                begin++;
            }
            end++;
            maxConsOne = Math.max(maxConsOne,oneCount + zeroCount);//added this here bacause whenever zeroCount is getting more thenthe allowed value we are decreasing it 
        }
        return maxConsOne;
    }
}