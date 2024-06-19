# Rotate List

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

# ListNode

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of singly-linked list

```
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int length = 1;
        ListNode lastTail = head;
        while(lastTail.next != null){
            lastTail = lastTail.next;
            length++;
        }
        ListNode targetTail = head;
        for(int j = length - k%length; j > 1; j--){
            targetTail = targetTail.next;
        }
        lastTail.next = head;
        head = targetTail.next;
        targetTail.next = null;
        return head;
    }
}
```
