class StockSpanner {
    Stack<int[]> stk;
    public StockSpanner() {
        stk = new Stack<>();
    }
    
    public int next(int price) {
        if(stk.isEmpty()){
            stk.push(new int[]{price,-1,0});
            return 1;
        }
        if(stk.peek()[0]>price){
            stk.push(new int[]{price,stk.peek()[0],stk.peek()[2]+1});
            return 1;
        }
        int index = stk.peek()[2]+1;
        while(!stk.isEmpty() && !(stk.peek()[0]>price)){
            stk.pop();
        }
        if(stk.isEmpty()){
            stk.push(new int[]{price,-1,index});
            return index+1;
        }
        int noOfDays = index-stk.peek()[2];
        stk.push(new int[]{price,stk.peek()[0],index});
        return noOfDays;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */