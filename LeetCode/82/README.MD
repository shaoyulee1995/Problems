# Remove Duplicates from Sorted List II

```
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
```

# Recursion

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of linkedlist

```
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        if(head.val != head.next.val){
            head.next = deleteDuplicates(head.next);
            return head;
        }else{
            while(head.next != null && head.val == head.next.val){
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }
    }
}
```

# Iterate

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of linkedlist

```
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0, head),
                 prev = dummyHead;
        while(head != null){
            while(head.next != null && head.val == head.next.val){
                head = head.next;
            }
            if(prev.next == head){
                prev = prev.next;
            }else{
                prev.next = head.next;
            }
            head = head.next;
        }
        return dummyHead.next;
    }
}
```
