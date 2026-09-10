class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> map = new HashMap<>();   
        int n = strs.length;
        for(int i = 0; i < n; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String ind = new String(arr);   
            if(map.containsKey(ind)){
                map.get(ind).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(ind, list);   
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(String s : map.keySet()){
            List<String> li = new ArrayList<>();
            for(int i : map.get(s)){
                li.add(strs[i]);
            }
            result.add(li);
        }
        return result;
    }
}