class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        int length = asteroids.length;
        stk.push(asteroids[0]);
        for(int i = 1; i < length; i++){
            if(!stk.isEmpty() && willCollide(asteroids[i], stk.peek())){
                while(!stk.isEmpty() && willCollide(asteroids[i], stk.peek()) && Math.abs(asteroids[i]) > Math.abs(stk.peek())){
                    stk.pop();
                }
                // seperate case for equal size because the asteroid[i] would not be able to colide with others after this         
                if(stk.isEmpty()){
                    stk.push(asteroids[i]);
                } else if(Math.abs(asteroids[i]) == Math.abs(stk.peek()) && willCollide(asteroids[i], stk.peek())){
                    stk.pop();
                } else if(!willCollide(asteroids[i], stk.peek())){
                    stk.push(asteroids[i]);
                }
            } else{
                stk.push(asteroids[i]);
            }
        }
        int n = stk.size();
        int[] arr = new int[n];
        while(n > 0){
            arr[n-1] = stk.pop();
            n--;
        }
        return arr;
    }
    public boolean willCollide(int x, int y){
        if(x < 0 && y > 0){
            return true;
        } else{
            return false;
        }
    }
}