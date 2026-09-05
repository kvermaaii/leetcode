class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int begin = 0;
        int end = 0;
        int maxLength = 0;
        int currLength = 0;
        while(begin <= end && end < n){
            char curr = s.charAt(end);
            map.put(curr, map.getOrDefault(curr,0) + 1);
            currLength++;
            while(map.size() > k){
                char ch = s.charAt(begin);
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch) - 1);
                }
                begin++;
                currLength--;
            }
            maxLength = Math.max(maxLength, currLength);
            end++;
        }
        return maxLength;
    }
}