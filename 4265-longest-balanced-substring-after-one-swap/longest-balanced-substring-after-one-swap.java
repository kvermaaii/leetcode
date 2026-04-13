import java.util.*;

class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int totalOnes = 0;
        int[] chr = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
                chr[i] = 1;
            } else {
                chr[i] = -1;
            }
        }
        int totalZeros = n - totalOnes;
        
        // Map now stores a list of indices (max size 2)
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>(Arrays.asList(-1)));
        
        int maxLength = 0;
        int prefixSum = 0;
        
        for (int i = 0; i < n; i++) {
            prefixSum += chr[i];
            
            // Scenario 1: Perfectly balanced without swaps
            if (map.containsKey(prefixSum)) {
                maxLength = Math.max(maxLength, i - map.get(prefixSum).get(0));
            }
            
            // Scenario 2: Window sum is -2 (needs to swap a 0 out for a 1 in)
            if (map.containsKey(prefixSum + 2)) {
                // Check up to the first two stored indices
                for (int index : map.get(prefixSum + 2)) {
                    int length = i - index;
                    int onesInside = (length - 2) / 2;
                    
                    if (onesInside < totalOnes) {
                        maxLength = Math.max(maxLength, length);
                        break; // First valid index gives max length, so break
                    }
                }
            }
            
            // Scenario 3: Window sum is +2 (needs to swap a 1 out for a 0 in)
            if (map.containsKey(prefixSum - 2)) {
                // Check up to the first two stored indices
                for (int index : map.get(prefixSum - 2)) {
                    int length = i - index;
                    int zerosInside = (length - 2) / 2;
                    
                    if (zerosInside < totalZeros) {
                        maxLength = Math.max(maxLength, length);
                        break; // First valid index gives max length, so break
                    }
                }
            }
            
            // 4. Store up to the first TWO occurrences of the prefix sum
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, new ArrayList<>());
            }
            if (map.get(prefixSum).size() < 2) {
                map.get(prefixSum).add(i);
            }
        }
        
        return maxLength;
    }
}
// class Solution {
//     public int longestBalanced(String s) {
//         int n = s.length();
//         int totalOnes = 0;
//         int[] chr = new int[n];
//         int p = 0;
//         for(char c : s.toCharArray()){
//             if(c == '1') {
//                 totalOnes++;
//                 chr[p] = 1;
//             }else{
//                 chr[p] = -1;
//             }
//             p++;
//         }
//         int totalZeros = n - totalOnes;
//         Map<Integer, Integer> map = new HashMap<>();
//         map.put(0,-1);
//         int maxLength = Integer.MIN_VALUE;
//         int prefixSum = 0;
//         for(int i = 0; i < n; i++){
//             prefixSum += chr[i];
//             if(map.containsKey(prefixSum)){
//                 int index = map.get(prefixSum);
//                 maxLength = Math.max(maxLength,i - index);
//             }else if(map.containsKey(prefixSum + 2)){
//                 int index = map.get(prefixSum);
//                 //calculate the no of ones and zero in this window
//                 int length = i - index;
//                 int ones = (length - 2)/2;
//                 if(ones < totalOnes){
//                     maxLength = Math.max(maxLength,i - index);
//                 }
//                 map.put(prefixSum,i);
//             }else if(map.containsKey(prefixSum - 2)){
//                 //calculate the no of ones and zero in this window
//                 int length = i - index;
//                 int zeros = (length + 2)/2;
//                 if(zeros < totalZeros){
//                     maxLength = Math.max(maxLength,i - index);
//                 }
//                 map.put(prefixSum,i);
//             }else{
//                 map.put(prefixSum,i);
//             }
//         }
//         return maxLength;
//     }
// }

