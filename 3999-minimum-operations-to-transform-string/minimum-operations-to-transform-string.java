class Solution {
    public int minOperations(String s) {
        char[] arr = s.toCharArray();
        if(arr.length < 2 && arr[0] == 'a') return 0;
        Arrays.sort(arr);
        int j = 0;
        if(arr[0] == 'a'){
            j = 1;
            while(arr[j] == 'a' && j < arr.length){
                j++;
            }
        }
        if(j == arr.length) return 0;
        if(j == arr.length - 1){
            int r = 'z' - arr[j];
            return r+1;
        }
        int minOp = 0;
        char f = arr[j];
        for(int i = j; i < arr.length; i++){
            int diff = arr[i] - f;
            if(diff > 0){
                minOp += diff;
                f = (char)(f + diff);
            }
        }// so now all the elements in s must be equal
        int d = 'z' - f;
        minOp += d;
        return minOp + 1;
    }
}