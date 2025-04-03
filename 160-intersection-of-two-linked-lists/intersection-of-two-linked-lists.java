/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthOfA = length(headA);
        int lengthOfB = length(headB);
        if(lengthOfA == 0 || lengthOfB == 0){
            return null;
        }
/*
for handling case LL = 1 ie headA and headB point to the same node of a single linked list so there can be casse where a linked list is a subset of another lin ked list  
*/
        if(headA == headB){
            return headA;
        }
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        if(lengthOfA > lengthOfB){
            for(int i = 0; i<lengthOfA-lengthOfB; i++){
                ptrA = ptrA.next;
            }
        } else{
            for(int i = 0; i<lengthOfB-lengthOfA; i++){
                ptrB = ptrB.next;
            }            
        }
        while(ptrA != null || ptrB != null){
            if(ptrA == ptrB){
                break;
            }
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        if(ptrA != null && ptrA == ptrB){
            return ptrA;
        } else{
            return null;
        }
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