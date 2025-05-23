
int binarySearchRotated(int arr[],int start,int end ,int value) {
    if (start> end) {
        return -1; 
    }
    int mid=start + (end-start)/2; 
    if (arr[mid]==value) {
        return mid;
    }
    if (arr[start]<= arr[mid]) { 
        if (arr[start]<= value && value <=arr[mid]) {
            return binarySearchRotated(arr, start, mid - 1, value);
        } else {
            return binarySearchRotated(arr, mid + 1, end, value);
        }
    } else {
        if (arr[mid]<=value && value<= arr[end]) {
            return binarySearchRotated(arr, mid + 1, end, value);
        } else {
            return binarySearchRotated(arr, start, mid - 1, value);
        }
    }
}

int search(int* nums, int numsSize, int target) {
    return binarySearchRotated(nums,0,numsSize-1,target);
}


