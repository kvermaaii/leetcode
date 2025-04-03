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
    public boolean isPalindrome(ListNode head) {
        int length = length(head);
        Stack<Integer> stk = new Stack<Integer>();

        if(length%2 == 0){
            length = length/2;
        for(int i = 0; i<length; i++){
            stk.push(head.val);
            head = head.next;
        }
        for(int i = 0; i<length; i++){
            if(head.val == stk.peek()){
                stk.pop();
            }
            head = head.next;
        }
        } else{
            length = (length-1)/2;
        for(int i = 0; i<length; i++){
            stk.push(head.val);
            head = head.next;
        }
        head = head.next;
        for(int i = 0; i<length; i++){
            if(head.val == stk.peek()){
                stk.pop();
            }
            head = head.next;
        }
        }

        return stk.isEmpty();
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