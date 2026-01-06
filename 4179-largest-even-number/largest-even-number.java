class Solution {
    public String largestEven(String s) {
        int n = s.length();
        int last = -1;
        for(int i = n - 1; i >= 0; i--) {
            if(s.charAt(i) == '2') {
                last = i;
                break;
            }
        }
        if(last == -1) return "";
        return s.substring(0,last + 1);
    }
}