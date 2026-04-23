class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 2) return false;
        return n > 0 && (n & (n - 1)) == 0 && (Math.log(n) / Math.log(2) % 2 == 0.0);
    }
}