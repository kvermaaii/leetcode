class LRUCache {
    int capacity;
    int size;
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            if (node != tail) {
                // Remove node from current position
                if (node == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else {
                    node.prev.next = node.next;
                    if (node.next != null) node.next.prev = node.prev;
                }
                tail.next = node;
                node.prev = tail;
                node.next = null;
                tail = node;
            }
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode delete = map.get(key);
            delete.val = value; // Update value
            if (delete != tail) {
                // Remove node from current position
                if (delete == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else {
                    delete.prev.next = delete.next;
                    if (delete.next != null) delete.next.prev = delete.prev;
                }
                tail.next = delete;
                delete.prev = tail;
                delete.next = null;
                tail = delete;
            }
            return;
        }

        if (size == capacity) {
            // Remove head
            map.remove(head.key);
            if (head == tail) {
                head = tail = null; // List becomes empty
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
        }

        ListNode newNode = new ListNode(key, value);
        if (tail == null) { // If the list is empty
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        map.put(key, newNode);
        size++;
    }
}

class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
