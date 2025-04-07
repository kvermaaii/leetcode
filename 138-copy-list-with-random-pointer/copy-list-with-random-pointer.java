/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> addressMap = new HashMap<>();
        Node copy = new Node(-1);
        Node copyHead = copy;
        Node ptr = head;
        addressMap.put(ptr, copy);
        while(ptr != null){
            copy.next = new Node(ptr.val);
            copy = copy.next;
            addressMap.put(ptr, copy);
            ptr = ptr.next;
        }
        Node copyPtr = copyHead.next;// ptr for copied list

/*        for (Node key : addressMap.keySet()) {
            Node dummy = addressMap.get(key.random);//getting the val at thiskey
            copyPtr.random = dummy;
            copyPtr = copyPtr.next;
        } But HashMap does not preserve the order of nodes so it wwould not iterate acc to list*/
        Node original = head;
        while (original != null) {
            copyPtr.random = addressMap.get(original.random);
            original = original.next;
            copyPtr = copyPtr.next;
         }
        return copyHead.next;
    }
}