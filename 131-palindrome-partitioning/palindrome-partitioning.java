class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        makePartition(0,s.length(),s,new ArrayList<>(),result);
        return result;
    }

    public void makePartition(int i, int l,String s, List<String> list, List<List<String>> result){
        if(i == l){
            result.add(new ArrayList<>(list));
        }
        for(int k=1; k<=s.length() -i ; k++){
            String str = s.substring(i,i+k); 
            if(isPalindrome( str , 0 , str.length() -1)){
                list.add(str);
                makePartition(i+k,l,s,list,result);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        if(start == end){
            return true;
        }
        while(start<end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}