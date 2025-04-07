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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int length = length(head);
        if(length == 1){
            return head;
        }
        k = k%length;
        if(k == 0){
            return head;
        }
        ListNode iter = head;
        for(int i =1; i<length - k; i++){
            iter = iter.next;
        }
        ListNode newHead = iter.next;
        iter.next = null;
        ListNode p = newHead;
        while(p.next != null){
            p = p.next;
        }
        p.next = head;
        head = newHead;
        return head;
    }
    
    public int length(ListNode head){
        ListNode iter = head;
        int count = 0;
        while(iter != null){
            iter = iter.next;
            count++;
        }
        return count;
    }
}