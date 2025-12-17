class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        if(words.length == 1) return s;
        int count = 0;
        Set<Character> set = Set.of('a','e','i','o','u');
        for(int i = 0 ; i < words[0].length(); i++){
            if(set.contains(words[0].charAt(i))) count++; 
        }
        for(int i = 1; i < words.length; i++){
            int c = 0;
            for(int j = 0; j < words[i].length(); j++){
                if(set.contains(words[i].charAt(j))) c++;
                if(c > count) break;
            }
            if(c == count){
                //reverse the string
                char[] a = words[i].toCharArray();
                for (int l = 0, r = a.length - 1; l < r; l++, r--) {
                    char tmp = a[l];
                    a[l] = a[r];
                    a[r] = tmp;
                }
                words[i] = new String(a);
                // for(int k = 0; k < words[i].length/2; k++){
                //     char temp = words[i].charAt(k);
                //     words[i].charAt(k) = words[i].charAt(words[i].length -1 - k);
                //     words[i].charAt(words[i].length -1 - k) = temp;
                // }
            }
        }
        //convert arr to one string with space added
        String result = String.join(" ", words);
        return result;
    }
}