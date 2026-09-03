class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int n = 0;
        int temp = x;
        while(temp != 0){
            temp /= 10;
            n++;
        }
        Stack<Integer> stk = new Stack<>();
        if(n%2 == 1){
            int odd = x;
            int i;
            for(i = n-1; i > n/2; i--){
                stk.add(odd % 10);
                odd /= 10;
            }
            i--;
            odd /= 10;
            for(int k = i; k >= 0; k--){
                if(odd % 10 != stk.pop()) return false;
                odd /= 10;
            }
        }else{
            int even = x;
            int i;
            for(i = n-1; i >= n/2; i--){
                stk.add(even % 10);
                even /= 10;
            }
            for(int k = i; k >= 0; k--){
                if(even % 10 != stk.pop()) return false;
                even /= 10;
            }
        }
        return true;
    }
}