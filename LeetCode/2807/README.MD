# Insert Greatest Common Divisors in Linked List

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

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as nodes

```java
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while(cur.next != null){
            int gcd = gcd(cur.val, cur.next.val);
            ListNode node = new ListNode(gcd);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        return head;
    }

    public int gcd(int x, int y){
        return (y == 0)? x: gcd(y, x%y);
    }
}
```
