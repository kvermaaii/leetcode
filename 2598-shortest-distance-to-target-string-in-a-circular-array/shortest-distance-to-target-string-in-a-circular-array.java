class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        if(target.equals(words[startIndex])) return 0;
        int n = words.length;
        int left = (startIndex - 1 + n) % n;
        int right = (startIndex + 1) % n;
        int steps = 1;
        boolean found = false;
        while(steps < n){
            if(words[right].equals(target) || words[left].equals(target)){
                found = true;
                break;
            } 
            right = (right + 1) % n;
            left = (left - 1 + n) % n;
            steps++;
        }
        if(found){
            return steps;
        }else{
            return -1;
        }  
    }
}