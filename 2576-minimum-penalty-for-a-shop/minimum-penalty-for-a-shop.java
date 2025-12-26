class Solution {
    public int bestClosingTime(String customers) {
        int totalPenalty = 0;
        int n = customers.length();
        char[] arr = customers.toCharArray();
        for(int i = 0; i < n; i++){
            if(arr[i] == 'Y') totalPenalty++;
        }
        int ind = 0;
        int minPenalty = totalPenalty;
        for(int i = 0; i < n; i++){
            if(arr[i] == 'N') {
                totalPenalty++;
            }else {
                totalPenalty--;
            }
            if(totalPenalty < minPenalty) {
                minPenalty = totalPenalty;
                ind = i+1;
            }
        }
        return ind;
    }
}