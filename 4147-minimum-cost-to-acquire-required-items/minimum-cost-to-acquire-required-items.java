class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if(costBoth < cost1 + cost2){
            long totalCost = 0;
            if(need1 < need2){
                totalCost = (long)need1 * costBoth;
                if(cost2 > costBoth){
                    totalCost += (long)(need2 - need1) * costBoth;
                } else{
                    totalCost += (long)(need2 - need1) * cost2;
                }
            }else{
                totalCost = (long)need2 * costBoth;
                if(cost1 > costBoth){
                    totalCost += (long)(need1 - need2) * costBoth;
                } else{
                    totalCost += (long)(need1 - need2) * cost1;
                }
            }
            return totalCost;
        }else {
            return (long)cost1*need1 + (long)cost2*need2;
        }
    }
}