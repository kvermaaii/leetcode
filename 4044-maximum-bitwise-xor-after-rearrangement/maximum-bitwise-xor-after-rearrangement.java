class Solution {
    public String maximumXor(String s, String t) {
        int zeroCount = 0;
        int oneCount = 0;
        char arr[] = t.toCharArray();
        char arr2[] = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '0') zeroCount++;
        }
        oneCount = arr.length - zeroCount;
        int k = 0;
        while(zeroCount > 0 && oneCount > 0){
            if(arr2[k] == '0'){
                oneCount--;
            }else{
                zeroCount--;
            }
            k++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < k ; i++){
            sb.append('1');
        }
        if(zeroCount == 0){
            for(int j = k; j < arr.length; j++){
                // If we are XORing with 1, we just flip the bit
                sb.append(arr2[j] == '0' ? '1' : '0');
            }
        }else{
            for(int j = k; j < arr.length; j++){
                // If we are XORing with 0, the bit stays the same
                sb.append(arr2[j]);
            }
        }
        return sb.toString();
    }
}