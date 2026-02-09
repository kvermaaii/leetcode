class Solution {
    public int lengthOfLongestSubstring(String s) {
        int begin = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int currLength = 0;
        while(end < s.length()){
            char currChar = s.charAt(end);
            int lastOccur = map.getOrDefault(currChar,-1);
            while(begin <= lastOccur){
                begin++;
                currLength--;
            }
            map.put(currChar,end);
            currLength++;
            maxLength = Math.max(maxLength, currLength);
            end++;
        }
        return maxLength;
    }
}