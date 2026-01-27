class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(words);
        int n = words.length;
        for(int i = 0; i < n; i++){
            String top= words[i];
            for(int j = 0; j < n; j++) {
                String left = words[j];
                if(j != i && top.charAt(0) == left.charAt(0)){
                    for(int k = 0; k < n; k++){
                        String right = words[k];
                        if(k != j && k != i && top.charAt(3) == right.charAt(0)) {
                            for(int l = 0; l < n; l++){
                                String bottom = words[l];
                                if(l != k && l != j && l != i && 
                                    bottom.charAt(0) == left.charAt(3) && 
                                        bottom.charAt(3) == right.charAt(3)){
                                            result.add(Arrays.asList(top, left, right, bottom));
                                }
                            }
                        }
                    }
                }
                
            }
        }
        return result;
    }
}