# Maximum Twin Sum of a Linked List

```java
Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of linkedlist

```java
class Solution {
    public int pairSum(ListNode head) {
        if(head == null){
            return 0;
        }
        ListNode slow = head,
                 fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode y = reverse(slow),
                 x = head;
        int res = 0;
        while(x != null && y != null){
            res = Math.max(res, x.val + y.val);
            x = x.next;
            y = y.next;
        }
        return res;
    }

    public ListNode reverse(ListNode node){
        ListNode prev = null;
        while(node != null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
```