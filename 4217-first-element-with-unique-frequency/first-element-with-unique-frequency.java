class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>(); 
        for(int n : nums){
            map1.put(n, map1.getOrDefault(n, 0) + 1);
        }
        for(int val : map1.values()){
            map2.put(val, map2.getOrDefault(val, 0) + 1);
        }
        // int uniqueFreq = 0;
        // for(int key : map2.keySet()){
        //     if(map2.get(key) == 1){
        //         uniqueFreq = key;
        //         break;
        //     }
        // }
        // int ans = -1;
        // if(uniqueFreq == 0) return -1;
        // for(int key : map1.keySet()){
        //     if(map1.get(key) == uniqueFreq){
        //         ans = key;
        //     }
        // }

        /* Because HashMap does not guarantee order, when i loop through map2.keySet() */

        for(int n : nums){
            int currentFreq = map1.get(n);
            if(map2.get(currentFreq) == 1){
                return n; 
            }
        }
        return -1;
    }
}