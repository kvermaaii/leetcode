class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>(); 
        combnSum(0, candidates.length, candidates, target, list, result);
        return result;
    }

    public void combnSum(int i, int l, int[] arr, int sum, List<Integer> list, List<List<Integer>> result){
        if(sum == 0){ 
            List<Integer> li = new ArrayList<>(list);
            result.add(li);
            return;
        }
        // if(sum < 0 || i>=l){
        //     return;
        //  } because we added the optimization arr[i] > sum
        for(int k = i; k < l; k++){
            if(k > i && arr[k] == arr[k-1]) continue;
            if(arr[k] > sum) break;
            list.add(arr[k]);
            combnSum(k + 1, l, arr, sum - arr[k], list, result);
            list.remove(list.size() -1);
        }
    }
}