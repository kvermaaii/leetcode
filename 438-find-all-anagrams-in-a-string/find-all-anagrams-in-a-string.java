class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int start = 0, end = 0;
        int n = p.length();
        int m = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0)+1);
        }
        List<Integer> list = new ArrayList<>();
        while(end < m){
            char curr = s.charAt(end);
            map.put(curr, map.getOrDefault(curr,0)-1);
            while(start <= end && map.get(curr) < 0){
                char ch = s.charAt(start);
                map.put(ch, map.get(ch) + 1);
                start++;
            }
            boolean anagram = true;
            for(int val : map.values()){
                if(val != 0){
                    anagram = false;
                    break;
                }
            }
            if(anagram){
                list.add(start);
            }
            end++;
        }
        return list;
    }
}