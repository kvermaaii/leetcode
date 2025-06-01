class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<int[]> stk = new Stack<>();
        for(int i=nums2.length-1; i>=0; i--){
            while(!stk.isEmpty() && !(stk.peek()[0]>nums2[i])){
                stk.pop();
            }
            int nge;
            if(stk.isEmpty()){
                nge =-1;
            } else{
                nge= stk.peek()[0];
            }
            map.put(nums2[i],nge);
            stk.push(new int[]{nums2[i],nge});
        }
        int[] result = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}