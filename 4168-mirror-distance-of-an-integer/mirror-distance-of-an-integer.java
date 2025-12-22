class Solution {
    public int mirrorDistance(int n) {
        String str = Integer.toString(n);
        String rev = new StringBuilder(str).reverse().toString();
        int mirror = Integer.parseInt(rev);
        return Math.abs(n - mirror);
    }
}