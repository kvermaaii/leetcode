class Solution {
    public int characterReplacement(String s, int k) {
        //lets maintain a max variable which will store the max frequency in the curent window of any element and then we will count the no of distinct alphabets excluding that 
        int begin = 0;
        int end = 0;
        int ans = 0;
        int maxFreq = 0;
        int size = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(end < s.length()){
            char curr = s.charAt(end);
            map.put(curr, map.getOrDefault(curr,0)+1);
            maxFreq = Math.max(maxFreq, map.get(curr));
            size++;
            while(size - maxFreq > k){
                char remove = s.charAt(begin);
                map.put(remove, map.get(remove) - 1);
                begin++;
                size--;
                for(int val : map.values()){
                    maxFreq = Math.max(maxFreq, val);
                }
            }
            ans = Math.max(maxFreq, size);
            end++;
        }
        return ans;
    }
}