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
    public void reorderList(ListNode head) {
        ListNode start = head;
        int size = 0;
        while(start != null){
            start = start.next;
            size++;
        }
        int k = (size+1)/2;
        start = head;
        while(k != 1){
            start = start.next;
            k--;
        }
        ListNode list2 = start.next;
        start.next = null;
        Stack<ListNode> stk = new Stack<>();
        while(list2 != null){
            stk.add(list2);
            list2 = list2.next;
        }
        start = head;
        while(start != null && !stk.isEmpty()){
            ListNode temp = start.next;
            start.next = stk.pop();
            start = start.next;
            start.next = temp;
            start = temp;
            if(start == null) break;
            temp = start.next;
        }
    }
}