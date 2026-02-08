class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int begin = 0;
        int end = 0;
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>(); 
        while(end < s.length()){
            char currChar = s.charAt(end);
            while(end - begin + 1 > 10){
                // dq.removeFirst();
                sb.deleteCharAt(0);
                begin++;
            }
            // dq.addLast(currChar);
            sb.append(currChar);
            if(end - begin + 1 == 10){
                // StringBuilder sb = new StringBuilder();
                // for(char ch : dq){
                //     sb.append(ch);
                // }
                String str = sb.toString();
                int cnt = map.getOrDefault(str, 0);
                if(cnt == 1) result.add(str);
                map.put(str, cnt + 1);

            }
            end++;
        }
        return result;
    }
}