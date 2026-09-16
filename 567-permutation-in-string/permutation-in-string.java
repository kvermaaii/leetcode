class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s1.length(); i++){
            set.add(s1.charAt(i));
        }
        if(s2.length() < set.size()) return false;
        int begin = 0;
        int end = 0;
        int[] freq = new int[26];
        for(int i = 0; i < s1.length(); i++){
            freq[s1.charAt(i) - 'a']++;
        }
        int[] temp = new int[26];
        int size = 0;
        while(end < s2.length()){
            char curr = s2.charAt(end);
            temp[curr - 'a']++;
            size++;
            if(!set.contains(curr)){
                begin = end+1;
                Arrays.fill(temp,0);
                size = 0;
            }
            while(size > s1.length()){
                temp[s2.charAt(begin) - 'a']--;
                begin++;
                size--;
            }
            if(size == s1.length()){
                boolean pal = true;
                for(int j = 0; j < 26; j++){
                    if(freq[j] != temp[j]){
                        pal = false;
                        break;
                    }
                }
                if(pal) return true;
            }
            end++;
        }
        return false;
    }
}