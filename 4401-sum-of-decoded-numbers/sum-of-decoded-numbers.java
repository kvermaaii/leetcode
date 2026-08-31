class Solution {
    public int sumDecoded(long[] nums) {
        int n = nums.length;
        
        long ans = 0;
        long MOD = 1_000_000_007;
        for(int i = 0; i< n; i++){
            
            int width = (int) (nums[i] % 10);
            long d = nums[i]/10;
            long temp = d;
            int len = 0;
            while(temp != 0){
                len++;
                temp /= 10;
            }
            int dsize = len - width;
            long pow10 = 1;
            for(int k = 0; k < dsize; k++){
                pow10 *= 10;
            }
            long x = d / pow10;
            long y = d % pow10;
            ans = (ans + rec(x,y, MOD)) % MOD;
        }
        return (int) ans;
    }
    long rec(long x, long n, long mod){
         if(n == 0){
            return 1;
        }
        if(n % 2 == 1){
            return (x*(rec(x*x % mod, (n-1)/2, mod)) % mod) % mod;
        } else{
            return (rec(x*x % mod, n/2, mod)) % mod;
        }       
    }
}