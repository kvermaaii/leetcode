class Solution {
    public int repeatedStringMatch(String a, String b) {
        int c = 1;
        String text = a;
        while(text.length() < b.length()){
            text += a;
            c++;
        }
        if(kmp(b,text)){
            return c;
        }
        text += a;
        c++;
        if(kmp(b,text)){
            return c;
        } else{
            return -1;
        }
    }
    public boolean kmp(String pattern, String text){
        int[] h = new int[pattern.length()];
        h[0] = 0;
        for (int i = 1; i < pattern.length(); i++) {
            int k = h[i - 1];
            while (k > 0 && pattern.charAt(k) != pattern.charAt(i)) {
                k = h[k - 1];
            }
            if (pattern.charAt(k) == pattern.charAt(i)) {
                k++;
            }
            h[i] = k;
        }
        int k = 0;
        int i = 0;
        while(k < text.length()){
            if(pattern.charAt(i) == text.charAt(k)){
                i++;
                k++;
                if(i == pattern.length()){
                    return true;
                }
            } else if(i > 0){
                i = h[i-1];
            } else{
                k++;
            }
        }
        return false;
    }
}