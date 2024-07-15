# Convert Binary Number in a Linked List to Integer

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

# Bit Operation

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while(head != null){
            res = (res << 1) | head.val;
            head = head.next;
        }
        return res;
    }
}
```
