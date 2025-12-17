import java.util.*;

class Solution {
    public int largestPrime(int n) {
        if(n == 1) return 0;
        List<Integer> li = new ArrayList<>();
        li.add(2);
        for (int i = 3; i <= n; i++) {
            if (isPrime(i)) li.add(i + li.get(li.size() - 1));
            if(li.get(li.size()-1) > n){
                if (!li.isEmpty()) {
                    li.remove(li.size() - 1);
                }
                break;
            }
            if(li.get(li.size()-1) == n){
                break;
            }
        }
        for(int i = li.size()-1; i >= 0; i--){
            if(isPrime(li.get(i))) return li.get(i);
        }
        return 0;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
