class Solution {
    public int minOperations(int[] nums) {
        int operations = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                int temp = nums[i];
                while(!isPrime(temp)){
                    temp++;
                }
                operations += temp - nums[i];
            }else{
                if(isPrime(nums[i])){
                    if(nums[i] == 2) {
                        operations += 2;
                        continue;
                    }
                    operations++;
                }
            }
        }
        return operations;
    }
    public boolean isPrime(int x){
        if(x < 2) return false;
        if(x == 2 || x == 3) return true;
        if(x % 2 == 0 || x % 3 == 0) return false;
        for(int i = 5; i * i <= x; i += 6){
            if(x % i == 0 || x % (i + 2) == 0) return false; 
        }
        return true;
    }
}