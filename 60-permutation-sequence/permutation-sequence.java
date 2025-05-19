class Solution {
    public String getPermutation(int n, int k) {
         // Create an array containing numbers from 1 to n
        int[] partn = new int[n];
        for (int i = 0; i < n; i++) {
            partn[i] = i + 1;
        }
        int[] KthPermutation = {1};

        // Call the `swap` function and store the result
        int[] result = swap(0, n, k, partn, KthPermutation);
        
        // Concatenate all numbers in `result` to form the final string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num);
        }
        
        return sb.toString();
    }

    public int[] swap(int i, int n, int k, int[] partn, int[] KthPermutation) {
        // System.out.println(KthPermutation[0]);
        // for(int p=0; p<partn.length; p++){
        //     System.out.print(partn[p]);
        // }
        // System.out.println();

        if (KthPermutation[0] == k) {
            return partn;
        }
        if( i == n){
            KthPermutation[0]++;
            return null;
        }
        for (int l = i; l < partn.length; l++) {
            // Swap elements at index `i` and `l`
            int temp = partn[i];
            partn[i] = partn[l];
            partn[l] = temp;

            // Arrays.sort(partn, i + 1, partn.length);
            int[] sortedPartn = Arrays.copyOf(partn, partn.length);
            Arrays.sort(sortedPartn, i + 1, sortedPartn.length);

            // Increment the KthPermutation counter
            // Recursive call
            int[] result = swap(i + 1, n, k, sortedPartn, KthPermutation);
            if (result != null) {
                return result;
            }
            
            // // Backtrack by undoing the swap
            temp = partn[i];
            partn[i] = partn[l];
            partn[l] = temp;
        }
        return null; // Return null if no valid permutation is found
    }

}