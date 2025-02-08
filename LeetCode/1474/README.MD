# Delete N Nodes After M Nodes of a Linked List

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
  - N as number of nodes in the linked list

```java
class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode validLastNode = head;

        while(head != null){
            int sizeM = m,
                sizeN = n;
            while(sizeM > 0 && head != null){
                validLastNode = head;
                head = head.next;
                sizeM--;
            }
            while(sizeN > 0 && head != null){
                head = head.next;
                sizeN--;
            }
            validLastNode.next = head;
        }
        return dummy.next;
    }
}
```
