class Solution {

    class Pair {
        int balance;
        int index;
        int distance;

        Pair(int balance, int index, int distance) {
            this.balance = balance;
            this.index = index;
            this. distance = distance;
        }
    }


    public long minMoves(int[] balance) {
        long Sum = 0;
        boolean flag = true;
        for(int nums: balance){
            Sum += nums;
            if(nums < 0) flag = false;
        }
        if(flag) return 0;
        if(Sum < 0) return -1;
        long totalSteps = 0;
        int n = balance.length;
        for(int i = 0; i < n; i++){
            if(balance[i] < 0){
                long steps = 0;
                List<Pair> list = new ArrayList<>();
                int left = (i - 1 + n) % n;
                int right = (i + 1) % n;
                long sum = 0;
                int visited = 0;
                while(sum < -balance[i] && visited < n){
                    sum += balance[left];
                    int dist = Math.min(Math.abs(i - left), n - Math.abs(i - left));
                    list.add(new Pair(balance[left], left, dist));
                    sum += balance[right];
                    dist = Math.min(Math.abs(right - i), n - Math.abs(right - i));
                    list.add(new Pair(balance[right], right, dist));
                    left = (left - 1 + n) % n;
                    right = (right + 1) % n;
                    visited +=2;
                }
                int m = -balance[i];
                for(int j = 0; j < list.size(); j++){
                    int v = list.get(j).balance;
                    if(v <= 0) continue;
                    if(v <= m){
                        m -= v;
                        steps += (long)v*list.get(j).distance;
                        balance[list.get(j).index] = 0;
                    } else{
                        int d = v - m;
                        steps += (long)m*list.get(j).distance;
                        balance[list.get(j).index] = d;
                        m = 0;
                        break;
                    }
                }
                totalSteps += steps;
                balance[i] = 0;
            }
            /* 
            This is a locally optimal choice:

“Take supply from the closest position to minimize steps.”

That looks correct — but it ignores global interactions.
Your greedy rule minimizes distance per move,
but does not minimize total cost across all deficits.

Key flaw

You may use up a nearby positive balance that is:

much more useful for a larger deficit later

forcing a later deficit to pull from farther positions

This increases total cost.
            */ 
        }
        return totalSteps;
    }
}


// public long minMoves(int[] balance) {
//         int Sum = 0;
//         boolean flag = true;
//         for(int nums: balance){
//             Sum += nums;
//             if(nums < 0) flag = false;
//         }
//         if(Sum < 0) return -1;
//         if(flag) return 0;
//         int totalSteps = 0;
//         int n = balance.length;
//         for(int i = 0; i < n; i++){
//             if(balance[i] < 0){
//                 int steps = 0;
//                 List<Pair> list = new ArrayList<>();
//                 int left = (i - 1 + n) % n;
//                 int right = (i + 1) % n;
//                 int sum = 0;
//                 int visited = 0;
//                 while(sum < -balance[i] && visited < n){
//                     sum += balance[left];
//                     int dist = Math.min(Math.abs(i - left), n - Math.abs(i - left));
//                     list.add(new Pair(balance[left], left, dist));
//                     sum += balance[right];
//                     dist = Math.min(Math.abs(right - i), n - Math.abs(right - i));
//                     list.add(new Pair(balance[right], right, dist));
//                     left = (left - 1 + n) % n;
//                     right = (right + 1) % n;
//                     visited +=2;
//                 }
//                 int m = -balance[i];
//                 for(int j = 0; j < list.size(); j++){
//                     int v = list.get(j).balance;
//                     if(v <= 0) continue;
//                     if(v <= m){
//                         m -= v;
//                         steps += v*list.get(j).distance;
//                         balance[list.get(j).index] = 0;
//                     } else{
//                         int d = v - m;
//                         steps += d*list.get(j).distance;
//                         balance[list.get(j).index] = d;
//                         m = 0;
//                         break;
//                     }
//                 }
//                 totalSteps += steps;
//                 balance[i] = 0;
//             }
//             /* 
//             This is a locally optimal choice:

// “Take supply from the closest position to minimize steps.”

// That looks correct — but it ignores global interactions.
// Your greedy rule minimizes distance per move,
// but does not minimize total cost across all deficits.

// Key flaw

// You may use up a nearby positive balance that is:

// much more useful for a larger deficit later

// forcing a later deficit to pull from farther positions

// This increases total cost.
//             */ 
//         }
//         return totalSteps;
//     }