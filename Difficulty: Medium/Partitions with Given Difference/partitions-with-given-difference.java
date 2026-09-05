class Solution {
    public int countPartitions(int[] arr, int diff) {
        // code here
         // this problem is equivalent to subset sum equal (S + diff)/2
         int Sum = 0;
         for(int num : arr){
             Sum += num;
         }
         int n = arr.length;
         if((Sum + diff) % 2 == 1) return 0;
         int K = (Sum + diff)/2;
         int[][] dp = new int[n+1][K+1];
         dp[0][0] = 1;
         for(int i = 0; i <= n; i++){
            for(int j = 0; j <= K; j++){
                if(i == 0 && j == 0) continue;
                int pick = 0;
                int pickNot = 0;
                if(i != 0 && j >= arr[i-1]) pick = dp[i - 1][j- arr[i-1]];
                if(i != 0) pickNot = dp[i-1][j];
                dp[i][j] = (pick + pickNot) % (int) (1e9 + 7);
            }
        }
         return dp[n][K] % (int) (1e9 + 7);
    }
}
