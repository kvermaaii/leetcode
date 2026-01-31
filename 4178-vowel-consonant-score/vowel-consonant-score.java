class Solution {
    public int vowelConsonantScore(String s) {
        String s2 = s.replaceAll("[0-9\\s]", "");
        int n = s2.length();
        int v = 0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for(int i = 0; i < n; i++){
            if(vowels.contains(s2.charAt(i))){
                v++;
            }
        }
        if(v == n) return 0;
        return v/(n-v);
    }
}