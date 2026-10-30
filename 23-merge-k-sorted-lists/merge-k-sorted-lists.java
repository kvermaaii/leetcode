/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        int k = lists.length;
        ListNode head = new ListNode();
        ListNode ptr = head;
        for(int i = 0; i < k; i++){
            if(lists[i] != null){
                heap.add(lists[i]);
            }
        }
        while(!heap.isEmpty()){
            ListNode temp = heap.poll();
            if(temp.next != null){
                heap.add(temp.next);
            }
            ptr.next = temp;
            ptr = ptr.next;
        }
        return head.next;
    }
}