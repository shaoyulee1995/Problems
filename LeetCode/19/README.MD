# Remove Nth Node From End of List

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as nodes in linkedlist

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head,
                 fast = head,
                 dummy = new ListNode(0);
        dummy.next = head;
        while(n-- > 0){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
```

```
Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
```
