class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i< n; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        List<List<Integer>> buckets = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            buckets.add(new ArrayList<>());
        }
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(buckets.get(freq) != null){
                buckets.get(freq).add(key);
            }else{
                List<Integer> li = new ArrayList<>();
                li.add(key);
                buckets.set(freq,li);
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = n; i >= 0; i--){
            if(buckets.get(i) != null){
                for(int no : buckets.get(i)){
                    result.add(no);
                }
            }
        } 
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = result.get(i);
        }
        return ans;
    }
}