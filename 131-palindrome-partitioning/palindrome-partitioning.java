class Solution {
    List<List<String>> ans;  
    void help(String s, int idx, List<List<String>> ans, List<String> list)
    {
        if(idx == s.length())
        {
            ans.add(new ArrayList<>(list));
            return;
        }


        for(int i = idx; i < s.length(); i++)  
        {
            if(ispal(s, idx, i))
            {
                list.add(s.substring(idx, i + 1)); 
                help(s, i + 1, ans, list);
                list.remove(list.size() - 1); 
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();  
        List<String> list = new ArrayList<>(); 
        help(s, 0, ans, list); 
        return ans;
    }
  
    public boolean ispal(String s, int st, int end){
        while(st < end)
        {
            if(s.charAt(st) != s.charAt(end)) return false;
            st++;
            end--;
        }
        return true;
    }
}