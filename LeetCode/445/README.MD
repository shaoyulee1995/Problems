# Add Two Numbers II

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
- Space Complexity: O(Max(L1, L2))
  - L1 as length of l1
  - L2 as length of l2

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> list1 = new Stack(),
                       list2 = new Stack();
        while(l1 != null){
            list1.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            list2.add(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(),
                 cur = dummy;
        int carry = 0;
        while(!list1.isEmpty() || !list2.isEmpty()){
            int a = (list1.isEmpty())? 0: list1.pop(),
                b = (list2.isEmpty())? 0: list2.pop(),
                sum = a + b + carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            cur.next = node;
            cur = cur.next;
        }
        if(carry != 0){
            cur.next = new ListNode(1);
        }
        return reverse(dummy.next);
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

- Time Complexity: O(Max(L1, L2))
- Space Complexity: O(Max(L1, L2))
  - L1 as length of l1
  - L2 as length of l2

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        return add(l1, l2);
    }

    public ListNode add(ListNode a, ListNode b){
        int carry = 0;
        ListNode dummy = new ListNode(),
                 cur = dummy;
        while(a != null || b != null){
            int x = (a == null)? 0: a.val,
                y = (b == null)? 0: b.val,
                sum = x + y + carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            cur.next = node;
            cur = cur.next;
            a = (a == null)? null: a.next;
            b = (b == null)? null: b.next;
        }
        if(carry != 0){
            cur.next = new ListNode(1);
        }
        return reverse(dummy.next);
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
