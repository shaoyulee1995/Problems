# Add Two Numbers

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

- Time Complexity: O(Max(L1, L2))
- Space Complexity: O(1)
  - L1 as length of l1
  - L2 as length of l2

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(),
                 cur = dummy;
        while(l1 != null || l2 != null){
            int x = (l1 == null)? 0: l1.val,
                y = (l2 == null)? 0: l2.val,
                sum = x+y + carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            cur.next = node;
            cur = cur.next;
            l1 = (l1 == null)? null: l1.next;
            l2 = (l2 == null)? null: l2.next;
        }
        if(carry != 0){
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}
```
