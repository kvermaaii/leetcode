class Solution {
    public int singleNonDuplicate(int[] nums) {
        int[] result = {0};
        findSingleElement(nums,0,nums.length-1,result);
        return result[0];
    }

    public void findSingleElement(int[] arr, int start, int end, int[] result){
        if(start == end){
            result[0] = arr[start];
            return;
        }
        int mid = (start+end)/2;
        // if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
        //     result[0] = arr[mid];
        //     return;
        // }
        if ((mid == 0 || arr[mid] != arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] != arr[mid + 1])) {
            result[0] = arr[mid];
            return;
        }
        if((arr[mid+1] == arr[mid] && mid%2 ==1) || (arr[mid-1] == arr[mid] && mid%2 ==0)){//case where single element will be on the left side
            findSingleElement(arr,start,mid-1,result);
        }else{
            findSingleElement(arr,mid+1,end,result);
        }
    }
}