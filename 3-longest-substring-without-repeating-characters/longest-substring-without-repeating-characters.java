class Solution {
    public int lengthOfLongestSubstring(String s) {
        int begin = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int size = 0;
        while(end < s.length()){
            char curr = s.charAt(end);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            size++;
            while(begin < end && map.get(curr) != 1){
                char remove = s.charAt(begin);
                map.put(remove, map.get(remove)-1);
                begin++;
                size--;
            }
            ans = Math.max(ans, size);
            end++;
        }
        return ans;
    }
}   
