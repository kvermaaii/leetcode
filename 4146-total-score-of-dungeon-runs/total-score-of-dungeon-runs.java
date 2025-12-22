class Solution {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        long score = 0;
        // damagePref[i] = sum of damage[0..i-1] (damage BEFORE entering room i)
        long[] damagePref = new long[n + 1];
        for(int i = 0; i < n; i++){
            damagePref[i + 1] = damagePref[i] + damage[i];
        }
        
        for(int j = 0; j < n; j++){
            // Find how many starting positions i (where i <= j) earn a point at room j
            // Condition: damagePref[i] >= damagePref[j+1] - hp + requirement[j]
            long threshold = damagePref[j + 1] - hp + requirement[j];
            
            // Binary search for smallest index where damagePref[i] >= threshold
            int left = 0, right = j + 1;
            int result = j + 1; // default: no valid starting position
        
            while(left < right){
                int mid = left + (right - left) / 2;
                if(damagePref[mid] >= threshold){
                    result = mid;
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            
            // All starting positions from result to j earn a point at room j
            score += (j + 1) - result;
        }
        
        return score;
    }
}