class Solution {
    HashMap<String,Integer> dp = new HashMap<>();
    public int countSequences(int[] nums, long k) {
        dp.clear();
        return rec(nums,0,k,1,1);
    }
    public int rec(int[] arr, int i, long k, long num, long den){
        if(i >= arr.length){
            return (num == k*den) ? 1 : 0;
        }
        String st = num + "_" + den + "_" + i;
        if(dp.containsKey(st)) return dp.get(st);
        int count = 0;
        count += rec(arr, i+1, k, arr[i]*num, den);
        count += rec(arr, i+1, k, num, den*arr[i]);
        count += rec(arr, i+1, k, num, den);
        dp.put(st,count);
        return count;
    }
    // Helper method to calculate Greatest Common Divisor
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
