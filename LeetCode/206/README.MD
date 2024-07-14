# Reverse Linked List

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as nodes of linkedlist

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
```
