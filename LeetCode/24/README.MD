# Swap Nodes in Pairs

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
- Space Complexity: O(1)
  - N as nodes in linkedlist

```java
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head,
                 prev = dummy;
        while(cur != null && cur.next != null){
            prev.next = cur.next;
            cur.next = prev.next.next;
            prev.next.next = cur;
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as nodes in linkedlist

```java
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode firstNode = head,
                 secondNode = head.next;

        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }
}
```
