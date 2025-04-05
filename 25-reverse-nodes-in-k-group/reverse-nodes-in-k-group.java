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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1){
            return head;
        }
        int length = length(head);
        int no_of_iter = length/k;
        ListNode ptr1 = head;
        ListNode ptr2 = head.next;
        ListNode ptr3 = head;
        ListNode prev = head;
        for(int i =0; i<no_of_iter; i++){
            for(int j = 0; j<k-1; j++){
                ptr3 = ptr2.next;
                if(ptr1 == head){
                    ptr1.next = null;
                    ptr2.next = ptr1;
                    
                } else{
                    ptr2.next = ptr1;
                }
                ptr1 = ptr2;
                ptr2 = ptr3;
                if(ptr3 != null){
                ptr3 = ptr3.next;
                }
            }
            if(i>0){
                prev.next = ptr1;
            }
            if(i == 0){
                head = ptr1;
            }
            for(int j = 0; j<k-1; j++){
                ptr1 = ptr1.next;
                prev = ptr1;
            }
            ptr1.next = ptr2;
            ptr1 = ptr2;
            ptr2 = ptr3;
        } // try dry run with 1st example to understand
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