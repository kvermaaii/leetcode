/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    struct ListNode* dummy = (struct ListNode*)malloc(sizeof(struct ListNode));
    dummy->next = head;
    struct ListNode* current = dummy;
    int length = 0;
    while(current != NULL){
        length++;
        current = current->next;
    }
    current = dummy;
    length -= n;
    for(int i=1; i<length; i++){
        current = current->next;
    }
    current->next = current->next->next;
    return dummy->next;
}