class Solution {
    public int minDays(int n) {
        //define a 1D dp which stores minimum number of days needed to reach a score i
        
        /* now lets break it into subproblems if we are on 6th day and we need to reach a target of 30 so we can try all the possible score until 6 using k(k+1)/s where k is from 6 to 1 
        or we can skip that day and keep the score same as the previous index which would make our steps until then 1 more than the current score step */
        
        // but there is one condition the score should not exceed the current score so k(k+1)/2 should be less than  or equal to current score 
        
        //after trying all the k we also need to add the steps already been taken so we need to add the steps from the previous score too 
        if(n == 2) return 3;
        if(n == 1) return 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp,1_000_000_0);
        dp[0] = 0;
        for(int i = 0; i <= n; i++){
            for(int k = 0; k < i; k++){
                int pts = k*(k+1)/2;
                int steps = (int) 1e7;
                if(i - pts < 0) break;
                if(i == pts){
                    steps = k;
                }else{
                    steps = dp[i - pts] + 1 + k;
                }
                // dp[i] = Math.min(dp[i] + 1, steps);// but since we are already adding a skip day into the steps as +1 we dont need to also add it separately while taking the minimum between if we take the k stps or we keep the previous score . so although when we are taking the ith score same as the current score meanswe are skipping but that will be handled when a step will be taken after that and esentially its a 1D dp and adding the +1 will esentially update that index which is wrong.
                dp[i] = Math.min(dp[i], steps);
            }
        }
        return dp[n];
    }
    // public int rec(int t, int days, int i, int n){
    //     if(t == 0){
    //         return 0;
    //     }
    //     if(t < 0){
    //         return (int) 1e7;
    //     }
    //     if(i > n) return (int) 1e7;
    //     int take = rec(t - (days+1), days+1, i+1, n) + 1;
    //     int notTake = 1 + rec(t, 0, i+1, n);
    //     return Math.min(take, notTake);
    // }
}