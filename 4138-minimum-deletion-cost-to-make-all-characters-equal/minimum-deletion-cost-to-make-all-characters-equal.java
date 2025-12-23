class Solution {
    public long minCost(String s, int[] cost) {
        Map<Character, Long> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int n = cost.length;
        long sumOfCosts = 0;
        for(int i = 0; i < n; i++){
            map.put(charArray[i], map.getOrDefault(charArray[i], 0L) + cost[i]);
            sumOfCosts += cost[i];
        }
        long minCost = Long.MAX_VALUE;
        for (long x : map.values()) {
            minCost = Math.min(minCost, sumOfCosts - x);
        }
        return minCost;
    }
}