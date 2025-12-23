class Solution {
    public long minCost(String s, int[] cost) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int n = cost.length;
        long sumOfCosts = 0;
        for(int i = 0; i < n; i++){
            if(!map.containsKey(charArray[i])){
                map.put(charArray[i], new ArrayList<>());
                map.get(charArray[i]).add(i);
            } else{
                map.get(charArray[i]).add(i);
            }
            sumOfCosts += cost[i];
        }
        long minCost = Long.MAX_VALUE;
        for (List<Integer> indexes : map.values()) {
            long sum = sumOfCosts;
            for(int x : indexes){
                sum -= cost[x];
            }
            minCost = Math.min(minCost, sum);
        }
        return minCost;
    }
}