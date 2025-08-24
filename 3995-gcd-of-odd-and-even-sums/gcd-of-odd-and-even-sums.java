class Solution {
    public int gcdOfOddEvenSums(int n) {
        if(n == 1) return 1;
        int sumOdd = (n*(2 + (n-1)*2))/2;
        int sumEven = (n*(4 + (n-1)*2))/2;
        // int sumOdd = n*n;
        // int sumEven = n*(n+1);
        return GCD(sumEven, sumOdd);
    }
    public int GCD(int a, int b){
        if(b == 0) return a;
        return GCD(b, a % b);
    }
}