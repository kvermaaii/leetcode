class LFUCache {
    int capacity;
    int size;
    int minFreq;
    Map<Integer, ListNode> freq;
    Map<Integer, ListNode> keyMap;

    public LFUCache(int capacity) {
        freq = new HashMap<>();
        keyMap = new HashMap<>();
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        if (keyMap.containsKey(key)) {
            ListNode node = keyMap.get(key);
            int value = node.val;

            // Update node frequency
            deleteNode(node, node.cnt);
            node.cnt++;
            addToFreq(node);

            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyMap.containsKey(key)) {
            ListNode node = keyMap.get(key);
            node.val = value;

            // Update node frequency
            deleteNode(node, node.cnt);
            node.cnt++;
            addToFreq(node);

        } else {
            if (size == capacity) {
                // Remove least frequently used node
                ListNode head = freq.get(minFreq);
                deleteHead(head);
                keyMap.remove(head.key);
                size--;
            }

            // Add new node
            ListNode newNode = new ListNode(key, value, 1);
            keyMap.put(key, newNode);
            addToFreq(newNode);
            minFreq = 1;
            size++;
        }
    }

    private void deleteHead(ListNode head) {
        if(head == null || head.next == null){  //although head will never be null
            freq.remove(head.cnt);
            return;
        }
        head.next.prev = null;
        freq.put(head.cnt, head.next);
        return;
    }

private void deleteNode(ListNode node, int freqKey) {
    if (node.prev == null && node.next == null) {
        freq.remove(freqKey);
        if (minFreq == freqKey) {
            minFreq++; // Increment minFreq if its list becomes empty
        }
    } else if (node.prev == null) {
        freq.put(freqKey, node.next);
        node.next.prev = null;
    } else if (node.next == null) {
        node.prev.next = null;
    } else {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

    private void addToFreq(ListNode node) {
        int cnt = node.cnt;
        if (freq.containsKey(cnt)) {
            ListNode listHead = freq.get(cnt);
            while (listHead.next != null) {
                listHead = listHead.next;
            }
            listHead.next = node;
            node.prev = listHead;
            node.next = null;
        } else {
            node.prev = null;
            node.next = null;
            freq.put(cnt, node);
        }
    }
}

class ListNode {
    int key;
    int val;
    int cnt;
    ListNode next;
    ListNode prev;

    ListNode(int key, int val, int cnt) {
        this.key = key;
        this.val = val;
        this.cnt = cnt;
    }
}
