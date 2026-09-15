class Solution {
    public boolean isPalindrome(String s) {
        String clean = s.replaceAll("[^a-zA-Z0-9]","");
        clean = clean.toLowerCase();
        // System.out.println(clean);
        int start= 0;
        int end = clean.length() - 1;
        while(start <= end){
            if(clean.charAt(start) != clean.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}