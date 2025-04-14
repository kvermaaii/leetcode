class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int lengthG = g.length; 
        int lengthS = s.length;
        Arrays.sort(s);
        Arrays.sort(g);
        int contentChilds=0;
        int j=0;
        while(contentChilds<lengthG && j<lengthS){
            if(g[contentChilds] <= s[j]){
                j++;
                contentChilds++;
            } else{
                j++;
            }
        }
        return contentChilds;
    }
    // public void sort(int[] x, int n1, int n2) {// exceeding time limit last testcase
    // int k = n2 - n1;
    // if (k < 2) { // Base case: If there's one or no element, it's already sorted.
    //     return;
    // }
    
    // int pivot = x[n1];
    // int temp;
    // int i = n1 + 1;
    // int pivotPos = n1; // Keep track of pivot's final position
    
    // // Partition loop - keeping your original logic
    // for (; i < n1 + k; i++) {
    //     if (x[i] > pivot) {
    //         temp = x[n1 + k - 1]; // Swap x[i] with the last unpartitioned element
    //         x[n1 + k - 1] = x[i];
    //         x[i] = temp;
    //         k--; // Reduce the size of the unpartitioned section
    //         i--; // Recheck the current position
    //     } else {
    //         x[i - 1] = x[i]; // Shift smaller elements to the left
    //         pivotPos = i; // Update pivot position
    //     }
    // }
    
    // // Place the pivot in its final position
    // x[pivotPos] = pivot;
    
    // // Recursive calls with guaranteed smaller partitions
    // if (pivotPos > n1) {
    //     sort(x, n1, pivotPos); // Sort elements before pivot
    // }
    // if (pivotPos + 1 < n2) {
    //     sort(x, pivotPos + 1, n2); // Sort elements after pivot
    // }
    // }

    // public void sort(int[] x,int n1,int n2){ incorrect
    //     int k =n2-n1;
    //     if(k<2){
    //         return;
    //     }
    //     int temp;
    //     int pivot = x[n1];
    //     int i= 0;
    //     for(i =n1+1; i<k; i++){
    //         if(x[i]>pivot){
    //             temp = x[k-1];
    //             x[k-1] = x[i];
    //             x[i] = temp;
    //             k--;
    //             i--;
    //         } else{
    //             x[i-1] = x[i];
    //             x[i] = pivot;
    //         }
    //     }
    //     sort(x,n1,i); stackoverflow error here.
    //     sort(x,i,n2);
    // }
}