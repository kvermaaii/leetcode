class Solution {
    public int maxSubArray(int[] nums) {
        /*
        2 
        -2 3 = -1 
        risk  - risking value
        max - macimum value
        */
        int n=nums.length;
        int risk=0;
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            risk+=nums[i];
            System.out.print(risk + " ");
            mx=Math.max(mx,risk);

            if(risk<0){
                risk=0;
            }
        }
        return mx;

    }
}