class Solution {
    public int countMonobit(int n) {
        double ans = Math.log(n+1)/Math.log(2);
        int monobit = (int)Math.floor(ans);
        return monobit+1;
    }
}