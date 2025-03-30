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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = length(head);
        if(length == 0){
            return null;
        }
        if(n == 0 || n > length){
            return head;
        }
        if(length == 1 && n == 1){
            return null;
        }
        if(n == length){
            head = head.next;
            return head;
        }
        ListNode iter = head;
        for(int i =1; i < length-n; i++){
            iter = iter.next;
        }
        if(n == 1){
            iter.next = null;
            return head;
        }
        iter.next = iter.next.next;
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