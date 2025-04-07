/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* rotateRight(struct ListNode* head, int k) {
    if(head == NULL){
        return head;
    }
    struct ListNode* ptr = head;
    int length = 0;
    while(ptr != NULL){
        length++;
        ptr = ptr->next;
    }
    k = k%length;
    if(k == 0 || length == 0 || length == 1){
        return head;
    }
    struct ListNode* prev;
    struct ListNode* curr = head;
    for(int i =0; i<length -k; i++){
        prev = curr;
        curr = curr->next;
    }
    prev->next = NULL;
    struct ListNode* newHead = curr;
    while(curr->next != NULL){
        curr = curr->next;
    }
    curr->next = head;
    head = newHead;
    return head;    
}