class Solution {
    public String getPermutation(int n, int k) {
        /*
        n -> n*(n-1)!
        among n! no., first (n-1)! starts with 1 so if k<(n-1)! it starts with 1
        so first we need to find a value p such that k is between p(n-1)! to p+1(n-1)! then do k = k-p(n-1)!
        swaping with which index will depend on p, if p=1 swap with 1 index and sort the remainnig array.
        now again find a vaulue p such that p(n-2)! <k < p+1(n-1)! and repeat the same thing until k converges to a single value and that permutaion will be returned 
         */

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        int[] factorial = new int[n + 1]; // Make factorial array of size n + 1
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // Step 3: Adjust k to be zero-based
        k--;

        // Step 4: Build the permutation string
        StringBuilder result = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i];
            result.append(numbers.get(index));
            numbers.remove(index);

            k %= factorial[i];
        }

        return result.toString();
    }
}