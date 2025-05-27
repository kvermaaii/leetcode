class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stk1 = new Stack<Integer>();
        Stack<Integer> stk2 = new Stack<Integer>();
        int[] result = new int[nums1.length];
        for(int i=0; i<nums2.length; i++){
            stk1.push(nums2[i]);
        }
        for(int j=0; j<nums1.length; j++){
            while(stk1.peek() != nums1[j]){
                stk2.add(stk1.pop());
            }
            // stk1.pop();
            int max =-1;
            boolean f = true;
            while(!stk2.isEmpty()){
                if(stk2.peek()>nums1[j] && f){
                    max = stk2.peek();
                    f =false;
                }
                stk1.add(stk2.pop());
            }
            result[j] =max;
        }
        return result;
    }
}