class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int minV = Integer.MAX_VALUE;
        int maxV = Integer.MIN_VALUE;
        for(int n: nums){
            minV = Math.min(minV,n);
            maxV = Math.max(maxV,n);
        }
        int[] freq = new int[maxV+1-minV];
        for(int n: nums){
            freq[n-minV]++;
        }
        int index=0;
        int[] arr = new int[k];
        while(k > 0){
            int maxFreq = -1; // Reset maxFreq for each iteration
            for (int i = 0; i < maxV + 1 - minV; i++) {
                if (freq[i] > maxFreq) {
                    maxFreq = freq[i];
                    index = i;
                }
            }
            k--;
            arr[k] = index+minV;
            freq[index] = Integer.MIN_VALUE;
        }
        return arr;
    }
}