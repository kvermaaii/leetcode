/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2) {
    struct ListNode* dummy = (struct ListNode*)malloc(sizeof(struct ListNode));
    struct ListNode* crr = dummy;
    struct ListNode* ptr1 = list1;
    struct ListNode* ptr2 = list2;
     while(ptr1 != NULL && ptr2 != NULL){
            if(ptr1->val >ptr2->val){
                crr->next = ptr2;
                ptr2 = ptr2->next;
            } else{
                crr->next = ptr1;
                ptr1 = ptr1->next;
            }
            crr = crr->next;
        }
        
    crr->next = (ptr1 != NULL) ? ptr1 : ptr2;

    struct ListNode* mergedList = dummy->next;
    free(dummy);
        return mergedList;
}