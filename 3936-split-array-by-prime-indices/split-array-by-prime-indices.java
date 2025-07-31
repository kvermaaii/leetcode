class Solution {
public long splitArray(int[] nums) {
    long Sum = 0;
    long totalSum = 0;
    int length = nums.length;
    for(int i = 0; i < length; i++){
        totalSum += nums[i];     // long += int is fine
        if(isPrime(i)){
            Sum += nums[i];
        }
    }
    return Math.abs(totalSum - 2*Sum);
}
    private boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}