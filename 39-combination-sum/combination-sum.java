class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>(); 
        /*list is an interface so cant make object of that as  it only defines the behavior (methods) that
        it only defines the behavior (methods) that any implementation of List should provide.
        */
        combnSum(0, candidates.length, candidates, target, list, result);
        return result;
    }

    public void combnSum(int i, int l, int[] arr, int sum, List<Integer> list, List<List<Integer>> result){
        if(sum == 0){
            /* result.add(list); note this add the list refernce itself and hence any changes in the lis twill
             reflect in the result
             */
            // create new copy of the current list 
            List<Integer> li = new ArrayList<>(list);
            result.add(li);
            return;
        }
        if(sum < 0 || i>=l){
            return;
        }
        list.add(arr[i]);
        combnSum(i, l, arr, sum - arr[i], list, result);
        list.remove(list.size() -1);
        combnSum(i + 1, l, arr, sum, list, result);
    }
}