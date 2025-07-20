# Sort List

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

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of linkedlist

```java
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null,
                 slow = head,
                 fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head),
                 l2 = sortList(slow);
        return mergeList(l1, l2);
    }

    private ListNode mergeList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0),
                 cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null){
            cur.next = l1;
        }else if(l2 != null){
            cur.next = l2;
        }
        return dummy.next;
    }
}
```
