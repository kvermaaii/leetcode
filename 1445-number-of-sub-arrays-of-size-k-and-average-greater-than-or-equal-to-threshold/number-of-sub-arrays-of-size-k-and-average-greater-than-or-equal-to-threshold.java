class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int begin = 0;
        int end = 0;
        int sum = 0;
        int count = 0;
        while(end < arr.length){
            int currNum = arr[end];
            while(end - begin + 1 > k){
                sum -= arr[begin];
                begin++;
            }
            sum += currNum;
            if(end - begin + 1 == k && (sum/k) >= threshold){
                count++;
            }
            end++;
        }
        return count;
    }
}