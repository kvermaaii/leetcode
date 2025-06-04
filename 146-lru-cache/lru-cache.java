class LRUCache {
    int capacity;
    Map<Integer,Integer> map;
    List<Integer> list;
    public LRUCache(int capacity) {
        list = new LinkedList<>();
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            list.remove((Integer)key);
            list.addLast(key);
            return map.get(key);
        } else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            list.remove((Integer)key);
        }
        if(list.size()==capacity){
            int x = list.removeFirst();
            map.remove(x);
        }
        list.addLast(key);
        map.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */