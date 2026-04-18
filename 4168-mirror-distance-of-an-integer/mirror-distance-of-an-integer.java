class Solution {
    public int mirrorDistance(int n) {
        int temp = n;
        int reversed = 0;
        while(temp != 0){
            reversed = reversed * 10 + (temp % 10);
            temp /= 10;
        }
        return Math.abs(n - reversed);
    }
}